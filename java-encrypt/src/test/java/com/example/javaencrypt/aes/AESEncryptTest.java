package com.example.javaencrypt.aes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class AESEncryptTest {
	
	private static Stream<Arguments> 암호화_데이터() {
		return Stream.of(
			Arguments.of("", "")
		);
	}
	
	@DisplayName("AES 암호화 테스트")
	@MethodSource("암호화_데이터")
	@ParameterizedTest(name = "{index} => cipherText={0}, key={1}")
	void testCase1(String signData, String secretKey) {
		String encrypt = AESEncrypt.encryptSHA256AndHex(signData, secretKey);
		System.out.println("encrypt = " + encrypt);
	}
}