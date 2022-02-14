package bookRental.model.dao;
import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import bookRental.model.vo.BookRental;
import member.dao.MemberDAO;
import reqBook.model.vo.ReqBook;
import review.model.vo.PageInfo;
import review.model.vo.ReviewBook;
public class BookRentalDAO {
	private Properties prop = null;

	public BookRentalDAO() {
		prop = new Properties();

		String fileName = MemberDAO.class.getResource("/sql/bookRental/bookRental-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getListCount(Connection conn, String user) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int listCount = -1;
		
		String query = prop.getProperty("getListCount");
		System.out.println(user);
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, user);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return listCount;
	}

	public ArrayList<BookRental> selectRentalList(Connection conn, PageInfo pi, String user) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<BookRental> list = null;
		
		String query = prop.getProperty("selectRentalList");
		
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, user);
			pstmt.setString(2, user);
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<BookRental>();
			System.out.println(startRow);
			System.out.println(endRow);
			System.out.println(user);
			while(rset.next()) {
				BookRental br = new BookRental(rset.getInt("rental_code"),
												rset.getDate("rental_date"),
												rset.getDate("return_date"),
												rset.getString("return_yn"),
												rset.getString("rental_id"),
												rset.getString("book_no"),
									  			rset.getString("book_title"),
									  			rset.getString("author"));
				
				list.add(br);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
	}

	public int returnBook(Connection conn, int rentCode) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("returnBook");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, rentCode);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int changeDate(Connection conn, int rentCode) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("changeDate");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, rentCode);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int returnBookAuto(Connection conn) {
		Statement stmt = null;
		int result = 0;

		String query = prop.getProperty("returnBookAuto");
		//UPDATE BOOKRENTAL SET RETURN_YN = 'Y', RETURN_DATE = SYSDATE WHERE (RETURN_DATE <= SYSDATE - 1) AND RETURN_YN = 'N'
		
		try {
			stmt = conn.createStatement();
			result = stmt.executeUpdate(query);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
		}

		return result;

	}

	public ArrayList<BookRental> selectMyRental(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<BookRental> list = null;
		
		String query = prop.getProperty("selectMyRental");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			
			list = new ArrayList<BookRental>();
			while(rset.next()) {
				BookRental br = new BookRental();
				br.setRentalCode(rset.getInt("rental_code"));
				br.setDateCal(rset.getInt("date_cal"));
				br.setBookNo(rset.getString("book_no"));
				br.setBookTitle(rset.getString("book_title"));
				br.setImg(rset.getString("change_name"));
				
				
				list.add(br);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
	}

	public ArrayList<BookRental> selectReturnInfo(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<BookRental> list = null;
		
		String query = prop.getProperty("selectReturnInfo");
		//select book_title, rental_id from bookrental join book using (book_no)
		//where return_date between SYSDATE - (INTERVAL '5' SECOND) AND SYSDATE + (INTERVAL '5' SECOND)
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			list = new ArrayList<BookRental>();
			while(rset.next()) {
				BookRental br = new BookRental();
				br.setBookTitle(rset.getString("book_title"));
				br.setMemberId(rset.getString("rental_id"));
				list.add(br);
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
