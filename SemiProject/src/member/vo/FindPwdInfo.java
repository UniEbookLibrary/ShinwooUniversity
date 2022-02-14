package member.vo;

public class FindPwdInfo {
	private String memberId;
	private String inputEmail;
	private String tempPwd;
	
	public FindPwdInfo() {}

	public FindPwdInfo(String memberId, String inputEmail, String tempPwd) {
		super();
		this.memberId = memberId;
		this.inputEmail = inputEmail;
		this.tempPwd = tempPwd;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getInputEmail() {
		return inputEmail;
	}

	public void setInputEmail(String inputEmail) {
		this.inputEmail = inputEmail;
	}

	public String getTempPwd() {
		return tempPwd;
	}

	public void setTempPwd(String tempPwd) {
		this.tempPwd = tempPwd;
	}

	@Override
	public String toString() {
		return "FindPwdInfo [memberId=" + memberId + ", inputEmail=" + inputEmail + ", tempPwd=" + tempPwd + "]";
	}
}
