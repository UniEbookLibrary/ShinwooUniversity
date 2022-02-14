package book.model.vo;

import java.sql.Date;

public class Book {
	private String bookNo;
	private String bookTitle;
	private int category;
	private String author;
	private String publisher;
	private Date regDate;
	private int rentTotal;
	private String ownYN;
	private String bookInfo;
	private String refer;
	private Date releaseDate;
	private String categoryName;
	private String changeName;
	
	public Book() {}

	public Book(String bookNo, String bookTitle, int category, String author, String publisher, Date regDate,
			int rentTotal, String ownYN, String bookInfo, String refer, Date releaseDate, String categoryName,
			String changeName) {
		super();
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.category = category;
		this.author = author;
		this.publisher = publisher;
		this.regDate = regDate;
		this.rentTotal = rentTotal;
		this.ownYN = ownYN;
		this.bookInfo = bookInfo;
		this.refer = refer;
		this.releaseDate = releaseDate;
		this.categoryName = categoryName;
		this.changeName = changeName;
	}

	public Book(String bookNo, String bookTitle, int category, String author, String publisher, Date regDate,
			int rentTotal, String ownYN, String bookInfo, String refer) {
		super();
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.category = category;
		this.author = author;
		this.publisher = publisher;
		this.regDate = regDate;
		this.rentTotal = rentTotal;
		this.ownYN = ownYN;
		this.bookInfo = bookInfo;
		this.refer = refer;
	}
	
	public Book(String bookNo, String bookTitle, int category, String author, String publisher, Date regDate,
			int rentTotal, String ownYN, String bookInfo, String refer, Date releaseDate) {
		super();
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.category = category;
		this.author = author;
		this.publisher = publisher;
		this.regDate = regDate;
		this.rentTotal = rentTotal;
		this.ownYN = ownYN;
		this.bookInfo = bookInfo;
		this.refer = refer;
		this.releaseDate = releaseDate;
	}
	
	public Book(String bookNo, String bookTitle, int category, String author, String publisher, Date regDate,
			int rentTotal, String ownYN, String bookInfo, String refer, Date releaseDate, String categoryName) {
		super();
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.category = category;
		this.author = author;
		this.publisher = publisher;
		this.regDate = regDate;
		this.rentTotal = rentTotal;
		this.ownYN = ownYN;
		this.bookInfo = bookInfo;
		this.refer = refer;
		this.releaseDate = releaseDate;
		this.categoryName = categoryName;
	}

	public String getBookNo() {
		return bookNo;
	}

	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public String getChangeName() {
		return changeName;
	}

	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getRentTotal() {
		return rentTotal;
	}

	public void setRentTotal(int rentTotal) {
		this.rentTotal = rentTotal;
	}

	public String getOwnYN() {
		return ownYN;
	}

	public void setOwnYN(String ownYN) {
		this.ownYN = ownYN;
	}

	public String getBookInfo() {
		return bookInfo;
	}

	public void setBookInfo(String bookInfo) {
		this.bookInfo = bookInfo;
	}

	public String getRefer() {
		return refer;
	}

	public void setRefer(String refer) {
		this.refer = refer;
	}
	
	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "Book [bookNo=" + bookNo + ", bookTitle=" + bookTitle + ", category=" + category + ", author=" + author
				+ ", publisher=" + publisher + ", regDate=" + regDate + ", rentTotal=" + rentTotal + ", ownYN=" + ownYN
				+ ", bookInfo=" + bookInfo + ", refer=" + refer + ", releaseDate=" + releaseDate + ", categoryName="
				+ categoryName + ", changeName=" + changeName + "]";
	}
	
}
