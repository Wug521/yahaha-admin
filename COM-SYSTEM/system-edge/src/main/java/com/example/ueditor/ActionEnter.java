package com.example.ueditor;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.example.ueditor.define.ActionMap;
import com.example.ueditor.define.AppInfo;
import com.example.ueditor.define.BaseState;
import com.example.ueditor.define.State;
import com.example.ueditor.hunter.FileManager;
import com.example.ueditor.hunter.ImageHunter;
import com.example.ueditor.upload.Uploader;




@Service
public class ActionEnter {
	
	@Resource
	private ConfigManager configManager;
	
	@Resource
	private Uploader uploader;

	public String exec (HttpServletRequest request, String rootPath) {
		
		String callbackName = request.getParameter("callback");
		
		if ( callbackName != null ) {

			if ( !validCallbackName( callbackName ) ) {
				return new BaseState( false, AppInfo.ILLEGAL ).toJSONString();
			}
			
			return callbackName+"("+this.invoke(request, rootPath)+");";
			
		} else {
			return this.invoke(request, rootPath);
		}

	}
	
	public String invoke(HttpServletRequest request, String rootPath) {
		
		String actionType = request.getParameter( "action" );
		
		if ( actionType == null || !ActionMap.mapping.containsKey( actionType ) ) {
			return new BaseState( false, AppInfo.INVALID_ACTION ).toJSONString();
		}
		
		if ( configManager == null || !configManager.valid() ) {
			return new BaseState( false, AppInfo.CONFIG_ERROR ).toJSONString();
		}
		
		State state = null;
		
		int actionCode = ActionMap.getType( actionType );
		
		Map<String, Object> conf = null;
		
		switch ( actionCode ) {
		
			case ActionMap.CONFIG:
				return configManager.getAllConfig().toString();
				
			case ActionMap.UPLOAD_IMAGE:
			case ActionMap.UPLOAD_SCRAWL:
			case ActionMap.UPLOAD_VIDEO:
			case ActionMap.UPLOAD_FILE:
				conf = configManager.getConfig( actionCode , rootPath);
			    conf.put("useOSSUpload",this.configManager.getAllConfig().getBoolean("useOSSUpload"));  
				state = uploader.doExec(request, conf);
				break;
				
			case ActionMap.CATCH_IMAGE:
				conf = configManager.getConfig( actionCode , rootPath );
				String[] list = request.getParameterValues( (String)conf.get( "fieldName" ) );
				state = new ImageHunter( conf ).capture( list );
				break;
				
			case ActionMap.LIST_IMAGE:
			case ActionMap.LIST_FILE:
				conf = configManager.getConfig( actionCode , rootPath );
				int start = this.getStartIndex(request);
				state = new FileManager( conf ).listFile( start );
				break;
				
		}
		
		return state.toJSONString();
		
	}
	
	public int getStartIndex (HttpServletRequest request) {
		
		String start = request.getParameter( "start" );
		
		try {
			return Integer.parseInt( start );
		} catch ( Exception e ) {
			return 0;
		}
		
	}
	
	/**
	 * callback参数验证
	 */
	public boolean validCallbackName ( String name ) {
		
		if ( name.matches( "^[a-zA-Z_]+[\\w0-9_]*$" ) ) {
			return true;
		}
		
		return false;
		
	}
	
}