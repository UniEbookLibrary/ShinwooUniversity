package reqBook.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import reqBook.model.dao.ReqBookDAO;
import reqBook.model.vo.ReqBook;
import book.model.vo.Book;

import static common.JDBCTemplate.*;

public class ReqBookService {

	private ReqBookDAO rDAO = new ReqBookDAO();
	private ReqBookDAO rkDAO = new ReqBookDAO();
	private ReqBookDAO nDAO = new ReqBookDAO();

	public ArrayList<ReqBook> selectList() {
		Connection conn = getConnection();

		ArrayList<ReqBook> list = rDAO.selectList(conn);

		close(conn);

		return list;

	}

	public int confirmList(int reqNo) {

		Connection conn = getConnection();

		int result = rDAO.confirmList(conn, reqNo);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);

		return result;

	}

	public ReqBook sendReqinfo(int reqNo) {

		Connection conn = getConnection();

		ReqBook r = rDAO.sendReqinfo(conn, reqNo);

		close(conn);

		return r;
	}

	public ReqBook reqBookDetail(int reqNo) {

		Connection conn = getConnection();

		ReqBook r = rDAO.reqBookDetail(conn, reqNo);

		close(conn);

		return r;

	}

	public int defineList(int reqNo, String reason) {
		Connection conn = getConnection();

		int result = rDAO.defineList(conn, reqNo);

		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);

		return result;
	}

	public int insertReason(int reqNo, String reason) {

		Connection conn = getConnection();

		int result = rDAO.insertReason(conn, reqNo, reason);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;
	}

	public int insertAlarm1(String writer, String bookName) {
		Connection conn = getConnection();

		int result = rDAO.insertAlarm1(conn, writer, bookName);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;
	}

	public int insertAlarm2(String writer, String bookName) {
		Connection conn = getConnection();

		int result = rDAO.insertAlarm2(conn, writer, bookName);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;

	}

	public ArrayList<ReqBook> selectMyList(String memberId) {
		Connection conn = getConnection();

		ArrayList<ReqBook> list = rkDAO.selectMyList(conn, memberId);
		close(conn);

		return list;
	}

	public ReqBook getReject(int rno) {
		Connection conn = getConnection();

		ReqBook rb = rkDAO.getReject(conn, rno);
		close(conn);

		return rb;
	}

	public int insertRequest(ReqBook r) {
		Connection conn = getConnection();

		int result = nDAO.insertRequest(conn, r);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;
	}

	public int checkBookExist(Book b) {
		Connection conn = getConnection();

		int result = nDAO.checkBookExist(conn, b);

		close(conn);

		return result;
	}
}
