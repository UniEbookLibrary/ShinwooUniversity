package admin.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import admin.model.vo.RentalBook;
import admin.model.vo.UserList;
import oracle.jdbc.proxy.annotation.Pre;

public class AdminDAO {
	private Properties prop = null;
	
	public AdminDAO() {
		prop = new Properties();
		
		String fileName = AdminDAO.class.getResource("/sql/admin/admin-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	

	public ArrayList<UserList> selectUserList(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<UserList> list = null;
		
		String query = prop.getProperty("selectUserList");
		
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			list = new ArrayList<UserList>();
			while(rset.next()) {
				UserList ul = new UserList(
											rset.getString("member_id"),
											rset.getString("member_name"),
											rset.getString("department"),
											rset.getString("phone"),
											rset.getString("address"),
											rset.getString("email"),
											rset.getString("status"));
				list.add(ul);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return list;
	}


	public UserList selectUserInfo(Connection conn, String mi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		UserList u = null;
		
		String query = prop.getProperty("selectUserInfo");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mi);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				u = new UserList(
							rset.getString("member_id"),
							rset.getString("member_name"),
							rset.getString("department"),
							rset.getString("phone"),
							rset.getString("address"),
							rset.getString("email"),
							rset.getString("status"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(rset);
			close(pstmt);
		}
		
		return u;
	}
	
	public int updateUserInfo(Connection conn, UserList ul) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateUserInfo");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, ul.getMemberName());
			pstmt.setString(2, ul.getDepartment());
			pstmt.setString(3, ul.getEmail());
			pstmt.setString(4, ul.getMemberId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		return result;
	}

	public ArrayList<RentalBook> selectRentalBookList(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<RentalBook> list = null;
		
		String query = prop.getProperty("selectRentalBook");
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			list = new ArrayList<RentalBook>();
			while(rset.next()) {
				RentalBook rb = new RentalBook(
											rset.getString("book_no"),
											rset.getString("book_title"),
											rset.getString("author"),
											rset.getString("member_id"),
											rset.getString("member_name"),
											rset.getDate("rental_date"),
											rset.getDate("return_date"),
											rset.getString("return_yn"));
				list.add(rb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return list;
	}
}
