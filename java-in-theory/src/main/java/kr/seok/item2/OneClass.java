package kr.seok.item2;

import java.math.BigInteger;

public class OneClass {
	private final String field1;
	private final String field2;
	private final String field3;
	private final String field4;
	private final String field5;
	private final String field6;
	private final String field7;
	private final String field8;
	private final String field9;
	private final String field10;
	private final String field11;
	private final String field12;
	private final String field13;
	private final String field14;
	private final String field15;
	
	private OneClass(String field1, String field2, String field3, String field4, String field5, String field6, String field7, String field8, String field9, String field10, String field11, String field12, String field13, String field14, TwoClass otherField) {
		this(field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14, otherField.getField15());
	}
	
	private OneClass(String field1, String field2, String field3, String field4, String field5, String field6, String field7, String field8, String field9, String field10, String field11, String field12, String field13, String field14, String field15) {
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
		this.field4 = field4;
		this.field5 = field5;
		this.field6 = field6;
		this.field7 = field7;
		this.field8 = field8;
		this.field9 = field9;
		this.field10 = field10;
		this.field11 = field11;
		this.field12 = field12;
		this.field13 = field13;
		this.field14 = field14;
		this.field15 = field15;
	}
	
	public static OneClass of(String field1, String field2, String field3, String field4, String field5, String field6, String field7, String field8, String field9, String field10, String field11, String field12, String field13, String field14, String field15) {
		return new OneClass(field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14, field15);
	}
	
	public static OneClass ofJsonData(String field1, String field2, String field3, String field4, String field5, String field6, String field7, String field8, String field9, String field10, String field11, String field12, String field13, String field14, TwoClass field15) {
		return new OneClass(field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14, field15);
	}
}
