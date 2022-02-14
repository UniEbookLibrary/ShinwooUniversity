package reqBook.model.vo;

import java.sql.Date;

public class ReqBook {
	private int reqBookNo;
	private String reqBookTitle;
	private Date reqBookDate;
	private String reqBookPub;
	private String reqBookAuthor;
	private String reqBookContent;
	private String reqBookWriter;
	private String reqBookComment;
	private String reqBookReason;
	private int status;
	private String reqWriterId;
	
	public ReqBook() {}
	
	
	
	public ReqBook(int reqBookNo, String reqBookTitle, Date reqBookDate, String reqBookPub, String reqBookAuthor,
			String reqBookContent, String reqBookWriter, String reqBookComment, String reqBookReason, int status,
			String reqWriterId) {
		super();
		this.reqBookNo = reqBookNo;
		this.reqBookTitle = reqBookTitle;
		this.reqBookDate = reqBookDate;
		this.reqBookPub = reqBookPub;
		this.reqBookAuthor = reqBookAuthor;
		this.reqBookContent = reqBookContent;
		this.reqBookWriter = reqBookWriter;
		this.reqBookComment = reqBookComment;
		this.reqBookReason = reqBookReason;
		this.status = status;
		this.reqWriterId = reqWriterId;
	}



	public ReqBook(int reqBookNo, String reqBookTitle, Date reqBookDate, String reqBookPub, String reqBookAuthor,
			String reqBookContent, String reqBookReason, int status, String reqWriterId) {
		super();
		this.reqBookNo = reqBookNo;
		this.reqBookTitle = reqBookTitle;
		this.reqBookDate = reqBookDate;
		this.reqBookPub = reqBookPub;
		this.reqBookAuthor = reqBookAuthor;
		this.reqBookContent = reqBookContent;
		this.reqBookReason = reqBookReason;
		this.status = status;
		this.reqWriterId = reqWriterId;
	}
	public ReqBook(int reqBookNo, String reqBookTitle, Date reqBookDate, String reqBookPub, String reqBookAuthor,
			String reqBookWriter, String reqBookComment, String reqBookReason, int status, String reqWriterId) {
		super();
		this.reqBookNo = reqBookNo;
		this.reqBookTitle = reqBookTitle;
		this.reqBookDate = reqBookDate;
		this.reqBookPub = reqBookPub;
		this.reqBookAuthor = reqBookAuthor;
		this.reqBookWriter = reqBookWriter;
		this.reqBookComment = reqBookComment;
		this.reqBookReason = reqBookReason;
		this.status = status;
		this.reqWriterId = reqWriterId;
	}
	
	public int getReqBookNo() {
		return reqBookNo;
	}


	public String getReqBookWriter() {
		return reqBookWriter;
	}

	public void setReqBookWriter(String reqBookWriter) {
		this.reqBookWriter = reqBookWriter;
	}

	public String getReqBookComment() {
		return reqBookComment;
	}


	public void setReqBookComment(String reqBookComment) {
		this.reqBookComment = reqBookComment;
	}
	
	public void setReqBookNo(int reqBookNo) {
		this.reqBookNo = reqBookNo;
	}

	public String getReqBookTitle() {
		return reqBookTitle;
	}

	public void setReqBookTitle(String reqBookTitle) {
		this.reqBookTitle = reqBookTitle;
	}

	public Date getReqBookDate() {
		return reqBookDate;
	}

	public void setReqBookDate(Date reqBookDate) {
		this.reqBookDate = reqBookDate;
	}

	public String getReqBookPub() {
		return reqBookPub;
	}

	public void setReqBookPub(String reqBookPub) {
		this.reqBookPub = reqBookPub;
	}

	public String getReqBookAuthor() {
		return reqBookAuthor;
	}

	public void setReqBookAuthor(String reqBookAuthor) {
		this.reqBookAuthor = reqBookAuthor;
	}

	public String getReqBookContent() {
		return reqBookContent;
	}

	public void setReqBookContent(String reqBookContent) {
		this.reqBookContent = reqBookContent;
	}

	public String getReqBookReason() {
		return reqBookReason;
	}

	public void setReqBookReason(String reqBookReason) {
		this.reqBookReason = reqBookReason;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getReqWriterId() {
		return reqWriterId;
	}

	
	
	public void setReqWriterId(String reqWriterId) {
		this.reqWriterId = reqWriterId;
	}

	@Override
	public String toString() {
		return "ReqBook [reqBookNo=" + reqBookNo + ", reqBookTitle=" + reqBookTitle + ", reqBookDate=" + reqBookDate
				+ ", reqBookPub=" + reqBookPub + ", reqBookAuthor=" + reqBookAuthor + ", reqBookContent="
				+ reqBookContent + ", reqBookReason=" + reqBookReason + ", status=" + status + ", reqWriterId="
				+ reqWriterId + "]";
	}
	
	
	
}

