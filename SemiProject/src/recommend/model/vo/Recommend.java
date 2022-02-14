package recommend.model.vo;

public class Recommend {
	private int recNo;
	private int reviewNo;
	private String recId;
	
	public Recommend() {}
	
	public Recommend(int recNo, int reviewNo, String recId) {
		super();
		this.recNo = recNo;
		this.reviewNo = reviewNo;
		this.recId = recId;
	}

	public int getRecNo() {
		return recNo;
	}

	public void setRecNo(int recNo) {
		this.recNo = recNo;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public String getRecId() {
		return recId;
	}

	public void setRecId(String recId) {
		this.recId = recId;
	}

	@Override
	public String toString() {
		return "Recommend [recNo=" + recNo + ", reviewNo=" + reviewNo + ", recId=" + recId + "]";
	}
	
	
	
}
