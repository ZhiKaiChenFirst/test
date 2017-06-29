package cn.test.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {

	private static String driver;
	private static String url;
	private static String user;
	private static String password;

	static {
		try {
			// 1.读取配置文件
			Properties pro = new Properties();
//			pro.load(new FileInputStream("src/db.properties"));
			pro.load(JDBCUtils.class.getResourceAsStream("/db.properties"));
			driver = pro.getProperty("driver");
			url = pro.getProperty("url");
			user = pro.getProperty("user");
			password = pro.getProperty("password");
			// 2.注册驱动
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void close(Connection conn, Statement st, ResultSet res) {
		if (res != null) {
			try {
				res.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (st != null) {
					try {
						st.close();
					} catch (SQLException e) {
						e.printStackTrace();
					} finally {
						if (conn != null) {
							try {
								conn.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
	}

	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("创建链接失败");
		}
		return conn;
	}
}
