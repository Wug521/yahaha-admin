package com.example.system.shiro;

import java.lang.annotation.Annotation;

import org.apache.shiro.aop.MethodInvocation;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.aop.AuthorizingAnnotationHandler;
import org.apache.shiro.subject.Subject;

public class AplPermissionAnnotationHandler extends AuthorizingAnnotationHandler{
      
	public AplPermissionAnnotationHandler(){
		super(RequiresPermissions.class);
	}
	
	protected String[] getAnnotationValue(Annotation a) {
        RequiresPermissions rpAnnotation = (RequiresPermissions) a;
        return rpAnnotation.value();
    }
	
    public void assertAuthorized(MethodInvocation mi) throws AuthorizationException {
    	assertAuthorizedClass(mi);
    	assertAuthorizedMethod(mi);
    }
    private void assertAuthorizedClass(MethodInvocation mi) throws AuthorizationException{
    	RequiresPermissions classAnnotation = mi.getThis().getClass().getAnnotation(RequiresPermissions.class);
    	if(null == classAnnotation)
    		return;		
        String[] classPerms = classAnnotation.value();
        Subject subject = getSubject();
        
        if (classPerms.length == 1) {
            subject.checkPermission(classPerms[0]);
            return;
        }
        if (Logical.AND.equals(classAnnotation.logical())) {
            getSubject().checkPermissions(classPerms);
            return;
        }
        if (Logical.OR.equals(classAnnotation.logical())) {
            // Avoid processing exceptions unnecessarily - "delay" throwing the exception by calling hasRole first
            boolean hasAtLeastOnePermission = false;
            for (String permission : classPerms) if (getSubject().isPermitted(permission)) hasAtLeastOnePermission = true;
            // Cause the exception if none of the role match, note that the exception message will be a bit misleading
            if (!hasAtLeastOnePermission) getSubject().checkPermission(classPerms[0]);

        }
    }
    private void assertAuthorizedMethod(MethodInvocation mi) throws AuthorizationException{
    	RequiresPermissions methodAnnotation = mi.getMethod().getAnnotation(RequiresPermissions.class);
        String[] methodPerms = methodAnnotation.value();
        Subject subject = getSubject();
        
        if (methodPerms.length == 1) {
            subject.checkPermission(methodPerms[0]);
            return;
        }
        if (Logical.AND.equals(methodAnnotation.logical())) {
            getSubject().checkPermissions(methodPerms);
            return;
        }
        if (Logical.OR.equals(methodAnnotation.logical())) {
            // Avoid processing exceptions unnecessarily - "delay" throwing the exception by calling hasRole first
            boolean hasAtLeastOnePermission = false;
            for (String permission : methodPerms) if (getSubject().isPermitted(permission)) hasAtLeastOnePermission = true;
            // Cause the exception if none of the role match, note that the exception message will be a bit misleading
            if (!hasAtLeastOnePermission) getSubject().checkPermission(methodPerms[0]);

        }
    }
	@Override
	public void assertAuthorized(Annotation a) throws AuthorizationException {
		// TODO Auto-generated method stub
		if (!(a instanceof RequiresPermissions)) return;  
		  
	    RequiresPermissions rpAnnotation = (RequiresPermissions) a;  
	    String[] perms = getAnnotationValue(a);  
	    Subject subject = getSubject();  
	  
	    if (perms.length == 1) {  
	        subject.checkPermission(perms[0]);  
	        return;  
	    }  
	    if (Logical.AND.equals(rpAnnotation.logical())) {  
	        getSubject().checkPermissions(perms);  
	        return;  
	    }  
	    if (Logical.OR.equals(rpAnnotation.logical())) {  
	        // Avoid processing exceptions unnecessarily - "delay" throwing the exception by calling hasRole first  
	        boolean hasAtLeastOnePermission = false;  
	        for (String permission : perms) 
	        	if (getSubject().isPermitted(permission)) 
	        		hasAtLeastOnePermission = true;  
	        // Cause the exception if none of the role match, note that the exception message will be a bit misleading  
	        if (!hasAtLeastOnePermission) 
	        	getSubject().checkPermission(perms[0]);  
	          
	    } 
	}
}
