package com.example.javaencrypt.basic;

import java.util.Base64;

public class BasicDecoding {
	public static void main(String[] args) {
		String encodedAuth = "YWYwZDExNjIzNmRmNDM3ZjgzMTQ4M2VlOWM1MDBiYzQ6NDMzYTg0MjFiZTc1NGIzNDk4OTA0OGNmMTQ4YTVmZmM=";
		String decodedAuth = new String(Base64.getDecoder().decode(encodedAuth));
		System.out.println(decodedAuth);
	}
}
