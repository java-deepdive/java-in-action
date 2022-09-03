package kr.seok.java8.chicken;

import java.util.Arrays;

public enum ChickenBrand {
	BHC,
	KFC,
	KYOCHON,
	GOOBNE,
	BBQ,
	GCOVA,
	NENE,
	PELICANA,
	HOOCHAM,
	MOMSTOUCH,
	PURADAK;
	
	public boolean isMatch(ChickenBrand brand) {
		return Arrays.stream(values())
			.anyMatch(b -> b == brand);
	}
	
	public String getName() {
		return this.name();
	}
}
