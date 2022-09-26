package com.example.javaencrypt.basic;

public class BasicDecoding {
	public static void main(String[] args) {
		String encodedAuth = "dW5kZWZpbmVkOnVuZGVmaW5lZA==";
		String decodedAuth = new String(java.util.Base64.getDecoder().decode(encodedAuth));
		System.out.println(decodedAuth);
	}
}
