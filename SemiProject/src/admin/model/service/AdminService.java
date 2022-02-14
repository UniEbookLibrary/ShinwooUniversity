package admin.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import admin.model.dao.AdminDAO;
import admin.model.vo.RentalBook;
import admin.model.vo.UserList;

public class AdminService {
	
	private AdminDAO aDAO = new AdminDAO();

	public ArrayList<UserList> selectUserList() {
		Connection conn = getConnection();
		ArrayList<UserList> list = aDAO.selectUserList(conn);
		
		close(conn);
		
		return list;
	}

	public UserList selectUserInfo(String mi) {
		Connection conn = getConnection();
		
		UserList u = aDAO.selectUserInfo(conn, mi);
		
		close(conn);
		
		return u;
	}
	public int updateUserInfo(UserList ul) {
		Connection conn = getConnection();
		
		int result = aDAO.updateUserInfo(conn, ul);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public ArrayList<RentalBook> selectRentalBookList() {
		Connection conn = getConnection();
		
		ArrayList<RentalBook> list = aDAO.selectRentalBookList(conn);
		
		close(conn);
		return list;
	}


	


	
	

}
