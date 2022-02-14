package photo.model.vo;

import java.sql.Date;

public class Photo {
	private int fileId;
	private String bookNo;
	private String originName;
	private String changeName;
	private String filePath;
	private Date uploadDate;
	private String status;
	
	public Photo() {}

	public Photo(int fileId, String bookNo, String originName, String changeName, String filePath, Date uploadDate,
			String status) {
		super();
		this.fileId = fileId;
		this.bookNo = bookNo;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.uploadDate = uploadDate;
		this.status = status;
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public String getBookNo() {
		return bookNo;
	}

	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
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

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Photo [fileId=" + fileId + ", bookNo=" + bookNo + ", originName=" + originName + ", changName="
				+ changeName + ", filePath=" + filePath + ", uploadDate=" + uploadDate + ", status=" + status + "]";
	}
	
}
