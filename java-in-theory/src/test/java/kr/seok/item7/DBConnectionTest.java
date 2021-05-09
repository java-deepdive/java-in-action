package kr.seok.item7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

class DBConnectionTest {

    @DisplayName("DBConnection 자원 접근 테스트")
    @Test
    void testCase1() {
        // DB 자원 접근
        DBConnection conn = new DBConnection.Builder("", "", "", "").build();

        // Connection 정보 확인
        Connection connection = conn.getConnection();

        // 메타 정보 살짝 확인
        conn.getMetaDataInfo(connection);

        // 자원 반환
        conn.disConnect();
    }
}
