package kr.seok.date;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimePractice {

	public static void main(String[] args) {
//		String format = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME); // 2022-05-18T17:27:20.382097
//		String format = LocalDateTime.now().format(DateTimeFormatter.ISO_TIME); // 17:27:41.501495
//		String format = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE); // 2022-05-18
//		String format = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME); // 17:27:57.10572
//		String format = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE); // 2022-05-18
//		String format = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME); // 2022-05-18T17:29:09.592916
//		String format = LocalDateTime.now().format(DateTimeFormatter.ISO_WEEK_DATE); // 2022-W20-3
//		String format = LocalDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE); // 20220518
		String format = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));
		System.out.println("format = " + format);
		System.out.println("format = " + format.substring(0, 20));
	}
}
