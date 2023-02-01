public class Question{
	private String question; 
	private String [] answers; 
	private int rightAnswer;
	private static int nextQuestionNumber = 1; 
	private final int questionNumber;  

	public Question(String question, String [] answers, int rightAnswer)
	{
		this.question = question;
		this.answers = answers; 
		questionNumber = nextQuestionNumber++; 
		if((rightAnswer < 1) || (rightAnswer > answers.length))
		{
			throw new IllegalArgumentException("The Number of correct answers chosen is wrong. Correct answers must be in between 1 and " + answers.length + "(The number of answers entered)"); 
		}
	}

	public boolean checkAnswer(int answer)
	{

	}

	@Override
	public String toString()
	{
		String output = questionNumber + ". " + question + "\n\t"; 
		for(int i = 0; i < answers.length; i++)
		{
			output += i + 1 ")  " + answers[i] + "\n\t";
		}
		return output; 
	}
}