package book.model.vo;

import java.sql.Date;

public class BookDetail {
	private String bookNo;
	private String bookTitle;
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
	private String filePath;
	private String rental_Id;
	private Date rentalDate;
	private Date returnDate;
	private String returnYN;
	private int categoryNo;
	
	public BookDetail() {}
	
	public BookDetail(String bookNo, String bookTitle, String author, String publisher, Date regDate, int rentTotal,
			String ownYN, String bookInfo, String refer, Date releaseDate, String categoryName, String changeName,
			String filePath, String rental_Id, Date rentalDate, Date returnDate, String returnYN, int categoryNo) {
		super();
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
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
		this.filePath = filePath;
		this.rental_Id = rental_Id;
		this.rentalDate = rentalDate;
		this.returnDate = returnDate;
		this.returnYN = returnYN;
		this.categoryNo = categoryNo;
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
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
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
	public String getChangeName() {
		return changeName;
	}
	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getRental_Id() {
		return rental_Id;
	}
	public void setRental_Id(String rental_Id) {
		this.rental_Id = rental_Id;
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
	public String getReturnYN() {
		return returnYN;
	}
	public void setReturnYN(String returnYN) {
		this.returnYN = returnYN;
	}
	
	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	@Override
	public String toString() {
		return "BookDetail [bookNo=" + bookNo + ", bookTitle=" + bookTitle + ", author=" + author + ", publisher="
				+ publisher + ", regDate=" + regDate + ", rentTotal=" + rentTotal + ", ownYN=" + ownYN + ", bookInfo="
				+ bookInfo + ", refer=" + refer + ", releaseDate=" + releaseDate + ", categoryName=" + categoryName
				+ ", changeName=" + changeName + ", filePath=" + filePath + ", rental_Id=" + rental_Id + ", rentalDate="
				+ rentalDate + ", returnDate=" + returnDate + ", returnYN=" + returnYN + ", categoryNo=" + categoryNo
				+ "]";
	}
	
}
