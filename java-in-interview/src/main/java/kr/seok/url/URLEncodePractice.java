package kr.seok.url;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class URLEncodePractice {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		System.out.println(URLEncoder.encode("This String has spaces", StandardCharsets.UTF_8.name()));
		System.out.println(URLEncoder.encode("This*String*has*asterisks", StandardCharsets.UTF_8.name()));
		System.out.println(URLEncoder.encode("This%String%has%percent%signs", StandardCharsets.UTF_8.name()));
		System.out.println(URLEncoder.encode("This+String+has+pluses", StandardCharsets.UTF_8.name()));
		System.out.println(URLEncoder.encode("This+String+has+pluses", StandardCharsets.UTF_8.name()));
		System.out.println(URLEncoder.encode("This/String/has/slashes", StandardCharsets.UTF_8.name()));
		System.out.println(URLEncoder.encode("This\"String\"has\"quote\"marks", StandardCharsets.UTF_8.name()));
		System.out.println(URLEncoder.encode("This:String:has:colons", StandardCharsets.UTF_8.name()));
		System.out.println(URLEncoder.encode("This-String-has-tildes", StandardCharsets.UTF_8.name()));
		System.out.println(URLEncoder.encode("This(String)has(parentheses)", StandardCharsets.UTF_8.name()));
		System.out.println(URLEncoder.encode("This.String.has.periods", StandardCharsets.UTF_8.name()));
		System.out.println(URLEncoder.encode("This=String=has=equals=signs", StandardCharsets.UTF_8.name()));
		System.out.println(URLEncoder.encode("This&String&has&ampersands", StandardCharsets.UTF_8.name()));
		System.out.println(URLEncoder.encode("ThisèStringèhasènon-ASCII characters", StandardCharsets.UTF_8.name()));
		String query = URLEncoder.encode("https://www.google.com/search?hl=en&as_q=Java&as_epq=I/O", StandardCharsets.UTF_8.name());
		System.out.println(query);
		
		String url = "https://www.google.com/search?";
		url += URLEncoder.encode("hl", StandardCharsets.UTF_8.name());
		url += "=";
		url += URLEncoder.encode("en", StandardCharsets.UTF_8.name());
		url += "&";
		url += URLEncoder.encode("as_q", StandardCharsets.UTF_8.name());
		url += "=";
		url += URLEncoder.encode("Java", StandardCharsets.UTF_8.name());
		url += "&";
		url += URLEncoder.encode("as_epq", StandardCharsets.UTF_8.name());
		url += "=";
		url += URLEncoder.encode("I/O", StandardCharsets.UTF_8.name());

		System.out.println("url = " + url);
	}
}
