package com.example.v1;


import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;

/**
 * 상태가 없는 서블릿
 */
public class _1_1_쓰레드_안전하지_않은_일련번호_생성_프로그램 implements Servlet {
	
	@Override
	public void init(ServletConfig config) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
	@Override
	public ServletConfig getServletConfig() {
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		BigInteger i = extractFromRequest(req);
		BigInteger[] factors = factor(i);
		encodeIntoResponse(res, factors);
	}
	
	private void encodeIntoResponse(ServletResponse res, BigInteger[] factors) {
	}
	
	private BigInteger[] factor(BigInteger i) {
		return new BigInteger[0];
	}
	
	private BigInteger extractFromRequest(ServletRequest req) {
		return null;
	}
	
	@Override
	public String getServletInfo() {
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
	@Override
	public void destroy() {
		throw new UnsupportedOperationException("Not supported yet.");
	}
}
