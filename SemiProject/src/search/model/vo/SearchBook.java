package search.model.vo;

import java.sql.Date;

public class SearchBook {
	private String bookNo;
	private String bookTitle;
	private int category;
	private String author;
	private String publisher;
	private int rentTotal;
	private String ownYN;
	private String bookInfo;
	private Date releaseDate;
	private String imageFile;
	private int fileId;
	
	public SearchBook() {}

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

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getImageFile() {
		return imageFile;
	}

	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	@Override
	public String toString() {
		return "SearchBook [bookNo=" + bookNo + ", bookTitle=" + bookTitle + ", category=" + category + ", author="
				+ author + ", publisher=" + publisher + ", rentTotal=" + rentTotal + ", ownYN=" + ownYN + ", bookInfo="
				+ bookInfo + ", releaseDate=" + releaseDate + ", imageFile=" + imageFile + ", fileId=" + fileId + "]";
	}
}
