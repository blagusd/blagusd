package Riddles;

public class Riddle {
	private String question;
	private String solution;
	private String explanation;
	private int moveCorrect;
	private int moveWrong;
	boolean solved;
	
	public Riddle() {}

	public Riddle(String question, String solution, String explanation, int moveCorrect, int moveWrong) {
		this.question = question;
		this.solution = solution;
		this.explanation = explanation;
		this.moveCorrect = moveCorrect;
		this.moveWrong = moveWrong;
	}
	
	public String getQuestion() {
		return question;
	}

	public String getSolution() {
		return solution;
	}

	public String getExplanation() {
		return explanation;
	}

	public int getMoveCorrect() {
		return moveCorrect;
	}

	public int getMoveWrong() {
		return moveWrong;
	}

	public boolean isSolved() {
		return solved;
	}

	public void setSolved(boolean solved) {
		this.solved = solved;
	}
	
	

}
