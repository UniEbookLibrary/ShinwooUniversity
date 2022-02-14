package question.model.vo;

import java.sql.Date;

public class Question {
	private int quest_No;
	private String quest_cont;
	private Date quest_date;
	private String answer;
	private String quest_Id;
	private String ans_Id;
	private String ans_YN;
	private String quest_name;
	
	public Question() {}

	public Question(int quest_No, String quest_cont, Date quest_date, String answer, String quest_Id, String ans_Id,
			String ans_YN, String quest_name) {
		super();
		this.quest_No = quest_No;
		this.quest_cont = quest_cont;
		this.quest_date = quest_date;
		this.answer = answer;
		this.quest_Id = quest_Id;
		this.ans_Id = ans_Id;
		this.ans_YN = ans_YN;
		this.quest_name = quest_name;
	}

	public int getQuest_No() {
		return quest_No;
	}

	public void setQuest_No(int quest_No) {
		this.quest_No = quest_No;
	}

	public String getQuest_cont() {
		return quest_cont;
	}

	public void setQuest_cont(String quest_cont) {
		this.quest_cont = quest_cont;
	}

	public Date getQuest_date() {
		return quest_date;
	}

	public void setQuest_date(Date quest_date) {
		this.quest_date = quest_date;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getQuest_Id() {
		return quest_Id;
	}

	public void setQuest_Id(String quest_Id) {
		this.quest_Id = quest_Id;
	}

	public String getAns_Id() {
		return ans_Id;
	}

	public void setAns_Id(String ans_Id) {
		this.ans_Id = ans_Id;
	}

	public String getAns_YN() {
		return ans_YN;
	}

	public void setAns_YN(String ans_YN) {
		this.ans_YN = ans_YN;
	}
	
	public String getQuest_name() {
		return quest_name;
	}

	public void setQuest_name(String quest_name) {
		this.quest_name = quest_name;
	}

	@Override
	public String toString() {
		return "Question [quest_No=" + quest_No + ", quest_cont=" + quest_cont + ", quest_date=" + quest_date
				+ ", answer=" + answer + ", quest_Id=" + quest_Id + ", ans_Id=" + ans_Id + ", ans_YN=" + ans_YN
				+ ", quest_name=" + quest_name + "]";
	}
	
}
