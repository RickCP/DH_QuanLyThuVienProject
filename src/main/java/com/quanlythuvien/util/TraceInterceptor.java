package com.quanlythuvien.util;

import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.springframework.aop.interceptor.CustomizableTraceInterceptor;

/**
 * 
 * @author lvhuy08t2@gmail.com
 * 
 */
public class TraceInterceptor extends CustomizableTraceInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3748264846889214565L;

	protected static Logger logger4J = Logger.getLogger("aop");

	@Override
	protected void writeToLog(Log logger, String message, Throwable ex) {
		if (ex != null) {
			logger4J.debug(message, ex);
		}

	}
	@Override
	protected boolean isInterceptorEnabled(MethodInvocation invocation,
			Log logger) {
		
		return true;
	}

}
