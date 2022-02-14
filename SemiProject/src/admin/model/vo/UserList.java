package admin.model.vo;

public class UserList {
	private String memberId;
	private String memberName;
	private String department;
	private String phone;
	private String address;
	private String email;
	private String status;
	
	public UserList() {}

	public UserList(String memberId, String memberName, String department, String phone, String address, String email,
			String status) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.department = department;
		this.phone = phone;
		this.address = address;
		this.email = email;
		this.status = status;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "UserList [memberId=" + memberId + ", memberName=" + memberName + ", department=" + department
				+ ", phone=" + phone + ", address=" + address + ", email=" + email + ", status=" + status + "]";
	}
	
	
}
