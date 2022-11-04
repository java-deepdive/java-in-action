package kr.seok.item7.memoryleek;

import kr.seok.item7.DBConnection;

public class Connection {
	public static void main(String[] args) {
		// DB 자원 접근
		DBConnection conn = new DBConnection.Builder("", "", "", "").build();
		
		// Connection 정보 확인
		java.sql.Connection connection = conn.getConnection();
		
		// 메타 정보 살짝 확인
		conn.getMetaDataInfo(connection);

        // 자원 반환
        conn.disConnect();
    }
}
