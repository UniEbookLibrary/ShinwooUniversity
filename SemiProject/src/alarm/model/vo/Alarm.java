package alarm.model.vo;

public class Alarm {
	private int alarmNo;
	private int alarmPt;
	private String alarmCont;
	private String memberId;
	private String status;
	public Alarm(int alarmNo, int alarmPt, String alarmCont, String memberId, String status) {
		super();
		this.alarmNo = alarmNo;
		this.alarmPt = alarmPt;
		this.alarmCont = alarmCont;
		this.memberId = memberId;
		this.status = status;
	}
	public int getAlarmNo() {
		return alarmNo;
	}
	public void setAlarmNo(int alarmNo) {
		this.alarmNo = alarmNo;
	}
	public int getAlarmPt() {
		return alarmPt;
	}
	public void setAlarmPt(int alarmPt) {
		this.alarmPt = alarmPt;
	}
	public String getAlarmCont() {
		return alarmCont;
	}
	public void setAlarmCont(String alarmCont) {
		this.alarmCont = alarmCont;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Alarm [alarmNo=" + alarmNo + ", alarmPt=" + alarmPt + ", alarmCont=" + alarmCont + ", memberId="
				+ memberId + ", status=" + status + "]";
	}
	
	
}
