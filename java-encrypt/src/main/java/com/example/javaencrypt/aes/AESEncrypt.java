package com.example.javaencrypt.aes;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESEncrypt {
	
	public static final String AES_ECB_PKCS_5_PADDING = "AES/ECB/PKCS5Padding";
	
	public static void main(String[] args) {
//		String plainText = "";
		String key = "시크릿키";
//		String cipherText = AESEncrypt.encrypt(plainText, key.substring(0, 16));
//		System.out.println(cipherText);
		String cipherText = "암호화된 문자열";
		String decryptedText = AESEncrypt.decrypt(cipherText, key.substring(0, 16));
		System.out.println(decryptedText);
	}
	
	public static String encrypt(String plainText, String key) {
		try {
			Cipher cipher = Cipher.getInstance(AES_ECB_PKCS_5_PADDING);
			SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			byte[] encrypted = cipher.doFinal(plainText.getBytes());
			return Base64.getEncoder().encodeToString(encrypted);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String encryptSHA256AndHex(String plainText, String key) {
		try {
			Cipher cipher = Cipher.getInstance(AES_ECB_PKCS_5_PADDING);
			SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			byte[] encrypted = cipher.doFinal(plainText.getBytes());
			return bytesToHex(encrypted);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static String bytesToHex(byte[] encrypted) {
		StringBuffer result = new StringBuffer();
		for (byte b : encrypted) {
			result.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
		}
		return result.toString();
	}
	
	public static String decrypt(String cipherText, String key) {
		try {
			Cipher cipher = Cipher.getInstance(AES_ECB_PKCS_5_PADDING);
			SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			byte[] decrypted = cipher.doFinal(hexToByteArray(cipherText));
			return new String(decrypted);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static byte[] hexToByteArray(String hex) {
		if (hex.length() % 2 != 0) {
			throw new IllegalArgumentException("Hex string must have even number of characters");
		}
		byte[] bytes = new byte[hex.length() / 2];
		for (int i = 0; i < hex.length(); i += 2) {
			bytes[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4) + Character.digit(hex.charAt(i + 1), 16));
		}
		return bytes;
	}
}
