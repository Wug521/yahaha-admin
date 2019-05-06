package com.example.system.shiro;

import org.apache.shiro.aop.AnnotationResolver;
import org.apache.shiro.aop.MethodInvocation;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.aop.AuthorizingAnnotationHandler;
import org.apache.shiro.authz.aop.AuthorizingAnnotationMethodInterceptor;
import org.apache.shiro.authz.aop.PermissionAnnotationHandler;

public class AplPermissionAnnotationMethodInterceptor extends
		AuthorizingAnnotationMethodInterceptor {
    
	public AplPermissionAnnotationMethodInterceptor() {  
        super(new PermissionAnnotationHandler());  
    } 
	
	public AplPermissionAnnotationMethodInterceptor(AuthorizingAnnotationHandler handler) {
		// TODO Auto-generated constructor stub
		super(handler);
	}

	public AplPermissionAnnotationMethodInterceptor(AnnotationResolver resolver) {
		super(new AplPermissionAnnotationHandler(), resolver);
	}

	public void assertAuthorized(MethodInvocation mi)
			throws AuthorizationException {
		try {
			AuthorizingAnnotationHandler handler = (AuthorizingAnnotationHandler) getHandler();
			if (handler instanceof AplPermissionAnnotationHandler) {
				((AplPermissionAnnotationHandler) handler).assertAuthorized(mi);
			} else {
				handler.assertAuthorized(getAnnotation(mi));
			}
		} catch (AuthorizationException ae) {
			// Annotation handler doesn't know why it was called, so add the
			// information here if possible.
			// Don't wrap the exception here since we don't want to mask the
			// specific exception, such as
			// UnauthenticatedException etc.
			if (ae.getCause() == null)
				ae.initCause(new AuthorizationException(
						"Not authorized to invoke method: " + mi.getMethod()));
			throw ae;
		}
	}
}
