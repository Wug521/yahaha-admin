package com.example.ueditor.upload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.system.edge.service.IFileService;
import com.example.ueditor.define.AppInfo;
import com.example.ueditor.define.BaseState;
import com.example.ueditor.define.State;

@Service
public class StorageManager {
	
	public static final int BUFFER_SIZE = 8192;
	
	public static Logger logger = LoggerFactory.getLogger(StorageManager.class);
	
	@Resource 
	private IFileService fileService;

	public static State saveBinaryFile(byte[] data, String path) {
		File file = new File(path);

		State state = valid(file);

		if (!state.isSuccess()) {
			return state;
		}

		try {
			BufferedOutputStream bos = new BufferedOutputStream(
					new FileOutputStream(file));
			bos.write(data);
			bos.flush();
			bos.close();
		} catch (IOException ioe) {
			logger.error("saveBinaryFile is error,state[{}];",state);
			return new BaseState(false, AppInfo.IO_ERROR);
		}

		state = new BaseState(true, file.getAbsolutePath());
		state.putInfo( "size", data.length );
		state.putInfo( "title", file.getName() );
		logger.debug("saveBinaryFile is success,state[{}];",state);
		return state;
	}

	public static State saveFileByInputStream(InputStream is, String path,
			long maxSize) {
		State state = null;

		File tmpFile = getTmpFile();

		byte[] dataBuf = new byte[ 2048 ];
		BufferedInputStream bis = new BufferedInputStream(is, StorageManager.BUFFER_SIZE);

		try {
			BufferedOutputStream bos = new BufferedOutputStream(
					new FileOutputStream(tmpFile), StorageManager.BUFFER_SIZE);

			int count = 0;
			while ((count = bis.read(dataBuf)) != -1) {
				bos.write(dataBuf, 0, count);
			}
			bos.flush();
			bos.close();

			if (tmpFile.length() > maxSize) {
				tmpFile.delete();
				logger.error("saveFileByInputStream is error,tmpFile length max_size[{}];",tmpFile.length());
				return new BaseState(false, AppInfo.MAX_SIZE);
			}

			state = saveTmpFile(tmpFile, path);

			if (!state.isSuccess()) {
				tmpFile.delete();
			}
			logger.debug("saveFileByInputStream is success,state[{}];",state);
			return state;
			
		} catch (IOException e) {
		}
		return new BaseState(false, AppInfo.IO_ERROR);
	}

	public static State saveFileByInputStream(InputStream is, String path) {
		State state = null;

		File tmpFile = getTmpFile();

		byte[] dataBuf = new byte[ 2048 ];
		BufferedInputStream bis = new BufferedInputStream(is, StorageManager.BUFFER_SIZE);

		try {
			BufferedOutputStream bos = new BufferedOutputStream(
					new FileOutputStream(tmpFile), StorageManager.BUFFER_SIZE);

			int count = 0;
			while ((count = bis.read(dataBuf)) != -1) {
				bos.write(dataBuf, 0, count);
			}
			bos.flush();
			bos.close();

			state = saveTmpFile(tmpFile, path);

			if (!state.isSuccess()) {
				tmpFile.delete();
			}
			logger.debug("saveFileByInputStream is success,state[{}];",state);
			return state;
		} catch (IOException e) {
		}
		return new BaseState(false, AppInfo.IO_ERROR);
	}

	public static File getTmpFile() {
		File tmpDir = FileUtils.getTempDirectory();
		String tmpFileName = (Math.random() * 10000 + "").replace(".", "");
		return new File(tmpDir, tmpFileName);
	}

	private static State saveTmpFile(File tmpFile, String path) {
		State state = null;
		File targetFile = new File(path);

		if (targetFile.canWrite()) {
			logger.error("saveTmpFile is error,no can weite,path[{}];",path);
			return new BaseState(false, AppInfo.PERMISSION_DENIED);
		}
		try {
			FileUtils.moveFile(tmpFile, targetFile);
		} catch (IOException e) {
			logger.error("saveTmpFile is error IO,e[{}];",e);
			return new BaseState(false, AppInfo.IO_ERROR);
		}

		state = new BaseState(true);
		state.putInfo( "size", targetFile.length() );
		state.putInfo( "title", targetFile.getName() );
		
		return state;
	}
	
	  /**
	   * 上传FTP文件
	   * @param is
	   * @param path
	   * @param maxSize
	   * @return
	 * @throws IOException 
	   */
	  public State saveFtpFileByInputStream(MultipartFile multipartFile, String path,long maxSize) throws IOException{
	    State state = null;
	    InputStream in = null;;
		try {
			in = multipartFile.getInputStream();
			int size = in.available();
			if (size > maxSize) {
				logger.error("saveFileByInputStream is error,MAX_SIZE,size[{}];",size);
			    return new BaseState(false, AppInfo.MAX_SIZE);
			}
			fileService.ftpUploadFile(in, path);
			state = new BaseState(true);
			state.putInfo("size", size);
			state.putInfo("title", multipartFile.getOriginalFilename());
			logger.debug("saveFtpFileByInputStream is success,state[{}];",state);
			return state;
		} catch (Exception e) {
			logger.error("saveFtpFileByInputStream is error;", e);
			e.printStackTrace();
		} finally {
			if (in != null){
				in.close();
			}
		}
		return new BaseState(false,AppInfo.IO_ERROR);
	  }

	private static State valid(File file) {
		File parentPath = file.getParentFile();

		if ((!parentPath.exists()) && (!parentPath.mkdirs())) {
			return new BaseState(false, AppInfo.FAILED_CREATE_FILE);
		}

		if (!parentPath.canWrite()) {
			return new BaseState(false, AppInfo.PERMISSION_DENIED);
		}

		return new BaseState(true);
	}
}
