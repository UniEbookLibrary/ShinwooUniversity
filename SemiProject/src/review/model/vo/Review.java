package review.model.vo;

import java.sql.Date;

public class Review {
	private int reviewNo;	
	private String bookName;	
	private String reviewTitle;	
	private String reviewContent;
	private Date reviewDate;		
	private int views;				
	private String reviewWriter;
	private String memberId;
	private String status;			
	private int recommend;
	
	public Review() {}
	
	public Review(int reviewNo, String bookName, String reviewTitle, String reviewContent, Date reviewDate, int views,
			String reviewWriter, String memberId, String status, int recommend) {
		super();
		this.reviewNo = reviewNo;
		this.bookName = bookName;
		this.reviewTitle = reviewTitle;
		this.reviewContent = reviewContent;
		this.reviewDate = reviewDate;
		this.views = views;
		this.reviewWriter = reviewWriter;
		this.memberId = memberId;
		this.status = status;
		this.recommend = recommend;
	}

	public Review(int reviewNo, String bookName, String reviewTitle, String reviewContent, Date reviewDate, int views,
			String reviewWriter, String memberId, String status) {
		super();
		this.reviewNo = reviewNo;
		this.bookName = bookName;
		this.reviewTitle = reviewTitle;
		this.reviewContent = reviewContent;
		this.reviewDate = reviewDate;
		this.views = views;
		this.reviewWriter = reviewWriter;
		this.memberId = memberId;
		this.status = status;
	}

	public Review(int reviewNo, String bookName, String reviewTitle, String reviewContent, Date reviewDate, int views,
			String reviewWriter, String status) {
		super();
		this.reviewNo = reviewNo;
		this.bookName = bookName;
		this.reviewTitle = reviewTitle;
		this.reviewContent = reviewContent;
		this.reviewDate = reviewDate;
		this.views = views;
		this.reviewWriter = reviewWriter;
		this.status = status;
	}
	public int getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getReviewTitle() {
		return reviewTitle;
	}
	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public Date getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public String getReviewWriter() {
		return reviewWriter;
	}
	public void setReviewWriter(String reviewWriter) {
		this.reviewWriter = reviewWriter;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	
	public int getRecommend() {
		return recommend;
	}

	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}

	@Override
	public String toString() {
		return "Review [reviewNo=" + reviewNo + ", bookName=" + bookName + ", reviewTitle=" + reviewTitle
				+ ", reviewContent=" + reviewContent + ", reviewDate=" + reviewDate + ", views=" + views
				+ ", reviewWriter=" + reviewWriter + ", memberId=" + memberId + ", status=" + status + ", recommend="
				+ recommend + "]";
	}

	
	
}
