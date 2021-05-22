package kr.seok.item7;

import java.sql.*;

public class DBConnection {
    private final String driver;
    private final String url;
    private final String user;
    private final String password;

    private Connection con = null;
    private PreparedStatement pre = null;
    private ResultSet rs = null;
    private Statement st = null;

    private DBConnection(Builder builder) {
        this.driver = builder.driver;
        this.password = builder.password;
        this.url = builder.url;
        this.user = builder.user;
    }

    public static class Builder {
        private final String driver;
        private final String url;
        private final String user;
        private final String password;

        public Builder(String driver, String url, String user, String password) {
            this.driver = driver;
            this.url = url;
            this.user = user;
            this.password = password;
        }

        public DBConnection build() {
            return new DBConnection(this);
        }
    }

    public Connection getConnection() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return con;
    }

    public void getMetaDataInfo(Connection con) {
        try {
            DatabaseMetaData metaData = con.getMetaData();
            System.out.println("=============== DB ===============");
            System.out.println(metaData.getDatabaseProductVersion());
            String driverName = metaData.getDriverName();
            String driverVersion = metaData.getDriverVersion();
            System.out.println("driverName : " + driverName);
            System.out.println("driverVersion : " + driverVersion);
            System.out.println("=============== DB ===============");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int executeStatement(String query) {
        int check = 0;
        try {
            if (st != null) {
                st.close();
            }
            st = con.createStatement();
            check = st.executeUpdate(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    public ResultSet executeQuery(String query, String[] params) {

        try {

            if (pre != null) {

                pre.close();
            }

            pre = con.prepareStatement(query);
            setParam(pre, params);
            rs = pre.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rs;
    }

    public int executeUpdate(String query, String[] params) {
        int check = 0;
        try {

            if (pre != null) {

                pre.close();
            }

            pre = con.prepareStatement(query);
            setParam(pre, params);
            check = pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public void setParam(PreparedStatement preparedStatement, String[] params) {

        if (params.length > 0) {
            try {
                for (int i = 0; i < params.length; i++) {
                    preparedStatement.setString(i + 1, params[i]);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void disConnect() {
        try {
            if (con != null) con.close();
            if (pre != null) pre.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
