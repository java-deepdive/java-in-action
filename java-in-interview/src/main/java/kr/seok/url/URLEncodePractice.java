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
	}
}
