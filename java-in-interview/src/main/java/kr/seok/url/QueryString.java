package kr.seok.url;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class QueryString {
	private StringBuilder query = new StringBuilder();
	
	public QueryString() {}
	
	public synchronized void add(String name, String value) {
		query.append('&');
		encode(name, value);
	}
	
	private void encode(String name, String value) {
		try {
			query.append(URLEncoder.encode(name, StandardCharsets.UTF_8.name()));
			query.append('=');
			query.append(URLEncoder.encode(value, StandardCharsets.UTF_8.name()));
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("Broken VM does not support UTF-8");
		}
	}
	
	public synchronized String getQuery() {
		return query.toString();
	}
	
	@Override
	public String toString() {
		return getQuery();
	}
}
