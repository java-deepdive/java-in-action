package com.example.javaencrypt.basic;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class AuthBasic {
	
	public AuthBasic() {
	
	}
	
	public void basicEncoding() {
		String username = "af0d116236df437f831483ee9c500bc4";
		String password = "433a8421be754b34989048cf148a5ffc";
		String auth = username + ":" + password;
		String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes(StandardCharsets.UTF_8));
		String authHeader = "Basic " + encodedAuth;
		System.out.println(authHeader);
	}
	
	public static void main(String[] args) {
	}
}
