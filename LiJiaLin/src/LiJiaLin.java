
import java.sql.*;

public class LiJiaLin {
    public static void main(String[] args) throws Exception {
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
        try {
            // 1. ע�����ݿ������
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2.ͨ��DriverManager��ȡ���ݿ�����
            String url = 
            "jdbc:mysql://localhost:3306/jdbc?serverTimezone=GMT%2B8&useSSL=false";
            String username = "P20200307123";    //���ݿ��û���
            String password = "123456";    //���ݿ�����
            conn = DriverManager.getConnection(url, username, password);
            // 3.ͨ��Connection�����ȡStatement����
            stmt = conn.createStatement();
            // 4.ʹ��Statementִ��SQL��䡣
            String sql = "select * from users";
            rs = stmt.executeQuery(sql);
            // 5. ����ResultSet�����
            System.out.println("id	| 	name	|	password|email	|	birthday");
            while (rs.next()) {
                int id = rs.getInt("id"); // ͨ��������ȡָ���ֶε�ֵ
                String name = rs.getString("name");
                String email = rs.getString("email");
                Date birthday = rs.getDate("birthday");
                System.out.println(id + "	|	" + name + "	|	" + password + "	|	" + email + "	|	" + birthday);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 6.�������ݿ���Դ
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                rs = null;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                stmt = null;
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                conn = null;
            }
        }
    }
}
