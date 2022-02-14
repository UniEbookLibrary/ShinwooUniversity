package review.model.vo;

import java.sql.Date;

public class ReviewBook {
	private String bookNo;
	private String bookTitle;
	private String cateName;
	private String author;
	private String imageFile;
	private String publisher;
	private Date releaseDate;
	
	public ReviewBook() {}

	
	
	public ReviewBook(String bookNo, String bookTitle, String cateName, String author, String imageFile,
			String publisher) {
		super();
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.cateName = cateName;
		this.author = author;
		this.imageFile = imageFile;
		this.publisher = publisher;
	}
	
	public ReviewBook(String bookNo, String bookTitle, String cateName, String author, String imageFile,
			String publisher, Date releaseDate) {
		super();
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.cateName = cateName;
		this.author = author;
		this.imageFile = imageFile;
		this.publisher = publisher;
		this.releaseDate = releaseDate;
	}



	public ReviewBook(String bookNo, String bookTitle, String cateName, String author, String imageFile) {
		super();
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.cateName = cateName;
		this.author = author;
		this.imageFile = imageFile;
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

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getImageFile() {
		return imageFile;
	}

	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}

	
	
	public String getPublisher() {
		return publisher;
	}



	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}


	@Override
	public String toString() {
		return "ReviewBook [bookNo=" + bookNo + ", bookTitle=" + bookTitle + ", cateName=" + cateName + ", author="
				+ author + ", imageFile=" + imageFile + ", publisher=" + publisher + ", releaseDate=" + releaseDate
				+ "]";
	}
	
	
}
