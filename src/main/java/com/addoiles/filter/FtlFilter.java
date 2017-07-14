package com.addoiles.filter;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FtlFilter implements Filter{
	protected final Logger logger = Logger.getLogger(this.getClass());
	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request2 = (HttpServletRequest) request;
		HttpServletResponse response2 = (HttpServletResponse) response;
		response2.sendRedirect(HttpUtils.getBasePath(request2)+"/404.htm");
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}
	
}
