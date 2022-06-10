package entity;

public class Sercurity {
	private int questionId;
	private String question;
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public Sercurity(int questionId, String question) {
		super();
		this.questionId = questionId;
		this.question = question;
	}
	public Sercurity() {
		super();
	}
	public Sercurity(String question) {
		super();
		this.question = question;
	}
	@Override
	public String toString() {
		return "Sercurity [questionId=" + questionId + ", question=" + question + "]";
	}
	
}
