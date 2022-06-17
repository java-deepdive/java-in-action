package kr.seok.url;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueryStringTest {
	
	@Test
	void testCase1() {
		QueryString qs = new QueryString();
		qs.add("hl", "en");
		qs.add("as_q", "Java");
		qs.add("as_epq", "I/O");
		String url = "http://www.google.com/search?" + qs;
		System.out.println("url = " + url);
	}
}