package bookRental.model.vo;

import java.sql.Date;

public class BookRental {
	private int rentalCode;
	private int dateCal;
	private Date rentalDate;
	private Date returnDate;
	private String returnYN;
	private String memberId;
	private String bookNo;
	private String bookTitle;
	private String author;
	private String img;
	
	
	
	public BookRental(int rentalCode, int dateCal, Date rentalDate, Date returnDate, String returnYN, String memberId,
			String bookNo, String bookTitle, String author, String img) {
		super();
		this.rentalCode = rentalCode;
		this.dateCal = dateCal;
		this.rentalDate = rentalDate;
		this.returnDate = returnDate;
		this.returnYN = returnYN;
		this.memberId = memberId;
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.author = author;
		this.img = img;
	}

	public BookRental(int rentalCode, Date rentalDate, Date returnDate, String returnYN, String memberId, String bookNo,
			String bookTitle, String author) {
		super();
		this.rentalCode = rentalCode;
		this.rentalDate = rentalDate;
		this.returnDate = returnDate;
		this.returnYN = returnYN;
		this.memberId = memberId;
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.author = author;
	}

	public BookRental() {}

	public BookRental(int rentalCode, Date rentalDate, Date returnDate, String returnYN, String memberId,
			String bookNo) {
		super();
		this.rentalCode = rentalCode;
		this.rentalDate = rentalDate;
		this.returnDate = returnDate;
		this.returnYN = returnYN;
		this.memberId = memberId;
		this.bookNo = bookNo;
	}

	public int getRentalCode() {
		return rentalCode;
	}

	public void setRentalCode(int rentalCode) {
		this.rentalCode = rentalCode;
	}

	public Date getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(Date rentalDate) {
		this.rentalDate = rentalDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getReturnYN() {
		return returnYN;
	}

	public void setReturnYN(String returnYN) {
		this.returnYN = returnYN;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getBookNo() {
		return bookNo;
	}

	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}

	
	
	
	public int getDateCal() {
		return dateCal;
	}

	public void setDateCal(int dateCal) {
		this.dateCal = dateCal;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "BookRental [rentalCode=" + rentalCode + ", dateCal=" + dateCal + ", rentalDate=" + rentalDate
				+ ", returnDate=" + returnDate + ", returnYN=" + returnYN + ", memberId=" + memberId + ", bookNo="
				+ bookNo + ", bookTitle=" + bookTitle + ", author=" + author + ", img=" + img + "]";
	}
	
	
}
