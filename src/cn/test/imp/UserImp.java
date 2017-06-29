package cn.test.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.test.entity.User;

import cn.test.service.UserService;
import cn.test.utils.JDBCUtils;

public class UserImp implements UserService{


	@Override
	public User getUserByUsername(String username) {
		Connection conn = JDBCUtils.getConnection();
		PreparedStatement st=null;
		ResultSet res=null;
		try {
			st = conn.prepareStatement("select * from usertable where username=?");
			st.setString(1, username);
			res = st.executeQuery();
			if (res.next()) {
				User user = new User();
				user.setUid(res.getInt("uid"));
				user.setUsername(res.getString("username"));
				user.setPassword(res.getString("password"));
				return user;
			}
		} catch (Exception e) {
			System.out.println("Sql_Error:"+e.getMessage());
		}finally{
			JDBCUtils.close(conn, st, res);
		}
		return null;
	}

	@Override
	public int InsertUser(User user) {
		Connection conn = JDBCUtils.getConnection();
		PreparedStatement st=null;
		ResultSet res=null;
		try {
			st = conn.prepareStatement("insert usertable(username,password) values(?,?)");
			st.setString(1, user.getUsername());
			st.setString(2, user.getPassword());
			int executeUpdate = st.executeUpdate();
			return executeUpdate;
		} catch (Exception e) {
			System.out.println("Sql_Error:"+e.getMessage());
		}finally{
			JDBCUtils.close(conn, st, res);
		}
		return -1;
	}

}
