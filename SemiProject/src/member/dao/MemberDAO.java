package member.dao;

import static common.JDBCTemplate.*;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import member.vo.FindPwdInfo;
import member.vo.Member;

public class MemberDAO {
	private Properties prop = null;

	public MemberDAO() {
		prop = new Properties();

		String fileName = MemberDAO.class.getResource("/sql/member/member-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Member loginMember(String memberId, String memberPwd, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member loginUser = null;

		String query = prop.getProperty("login");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPwd);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				loginUser = new Member(rset.getString("MEMBER_ID"), rset.getString("PW"), rset.getString("MEMBER_NAME"),
						rset.getString("DEPARTMENT"), rset.getString("PHONE"), rset.getString("ADDRESS"),
						rset.getString("EMAIL"), rset.getString("MEMBER_TYPE"), rset.getString("STATUS"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return loginUser;

	}

	public String isFirstLogin(String memberId, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String status = null;

		String query = prop.getProperty("checkFirst");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				status = rset.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return status;

	}

	public int firstUpdate(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("firstUpdate");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getMemberPwd());
			pstmt.setString(2, m.getPhone());
			pstmt.setString(3, m.getAddress());
			pstmt.setString(4, m.getEmail());
			pstmt.setString(5, m.getMemberId());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int updatePwd(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("updatePwd");

		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, m.getMemberPwd());
			pstmt.setString(2, m.getMemberId());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int updateMember(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("updateMember");

		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, m.getPhone());
			pstmt.setString(2, m.getAddress());
			pstmt.setString(3, m.getEmail());
			pstmt.setString(4, m.getMemberId());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int checkPwd(Connection conn, String userId, String userPwd) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;

		String query = prop.getProperty("checkPwd");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				result = rset.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return result;
	}

	public Member selectMember(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member member = null;

		String query = prop.getProperty("selectMember");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				member = new Member(rset.getString("MEMBER_ID"), rset.getString("PW"), rset.getString("MEMBER_NAME"),
						rset.getString("DEPARTMENT"), rset.getString("PHONE"), rset.getString("ADDRESS"),
						rset.getString("EMAIL"), rset.getString("MEMBER_TYPE"), rset.getString("STATUS"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return member;
	}

//	public int findPwd(Connection conn, String inputEmail, String memberId) {
//		PreparedStatement pstmt = null;
//		ResultSet rset = null;
//		int result = 0;
//		
//		String query = prop.getProperty("findEmail");
//		// findEmail=SELECT COUNT(*) FROM MEMBER WHERE EMAIL = ? AND MEMBER_ID = ?
//		
//		try {
//			pstmt = conn.prepareStatement(query);
//			pstmt.setString(1, inputEmail);
//			pstmt.setString(2, memberId);
//			
//			rset = pstmt.executeQuery();
//			if(rset.next()) {
//				result = rset.getInt(1);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(rset);
//			close(pstmt);
//		}
//		return result;
//	}

//	public int sendEmail(Connection conn, String tempPwd, String inputEmail) {
//		PreparedStatement pstmt = null;
//		int result = 0;
//		
//		String query = prop.getProperty("sendPwEmail");
//		// sendPwEmail=UPDATE MEMBER SET PW=? WHERE EMAIL=?
//		String email = inputEmail.trim();
//		System.out.println(tempPwd);
//		try {
//			pstmt = conn.prepareStatement(query);
//			pstmt.setString(1, tempPwd);
//			pstmt.setString(2, email);
//			
//			result = pstmt.executeUpdate();
//			System.out.println(result);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(pstmt);
//		}
//		
//		return result;
//	}

	public int selectId(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("selectId");
		// selectId=SELECT COUNT(*) FROM MEMBER WHERE MEMBER_ID = ?
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public int correctEmail(Connection conn, FindPwdInfo fpi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("correctEmail");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, fpi.getMemberId());
			pstmt.setString(2, fpi.getInputEmail());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public int updateTempPwd(Connection conn, FindPwdInfo fpi) {
		PreparedStatement pstmt = null;
		int result = 0;
		 String query = prop.getProperty("updateTempPwd");
		 
		 try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, fpi.getTempPwd());
			pstmt.setString(2, fpi.getMemberId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int checkEmail(Connection conn, String userEmail) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;

		String query = prop.getProperty("checkEmail");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userEmail);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				result = rset.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return result;
	}
}
