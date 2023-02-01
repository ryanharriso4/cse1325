public class Question{
	private String question; 
	private String [] answers; 
	private int rightAnswer;
	private int nextQuestionNumber = 1; 
	private final int questionNumber; 

	public Question(String question, String [] answers, int rightAnswer)
	{
		this.question = question;
		this.answers = answers; 
		this.rightAnswer = rightAnswer; 
	}

	public boolean checkAnswer(int answer)
	{

	}

	@Override
	public String toString()
	{

	}
}