package com.example.v1;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;

public class StatelessFactorizer implements Runnable {
	
	@Override
	public void run() {
		// 상태가 없는 서블릿
		BigInteger i = extractFromRequest();
		BigInteger[] factors = factor(i);
		encodeIntoResponse(factors);
	}
	
	private void encodeIntoResponse(BigInteger[] factors) {
		System.out.println("encodeIntoResponse :: " + Arrays.toString(factors));
	}
	
	private BigInteger[] factor(BigInteger i) {
		BigInteger[] integer = new BigInteger[1];
		integer[0] = BigInteger.valueOf(i.intValue());
		System.out.println("factor :: " + integer[0]);
		return integer;
	}
	
	private BigInteger extractFromRequest() {
		BigInteger bigInteger = BigInteger.probablePrime(10, new Random());
		System.out.println("extractFromRequest() :: " + bigInteger);
		return bigInteger;
	}
}
