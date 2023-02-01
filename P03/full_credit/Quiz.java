public class Quiz{

	private Question [] questions; 

	public Quiz()
	{
		loadQuiz(); 
	}

	public double takeQuiz()
	{

	}

	private void loadQuiz()
	{
		String [] Q1Answers = {"-2","-1","100", "2"}; 
		String [] Q2Answers = {"5", "100", "-2", "2"}; 
		Question Q1 = new Question("What is 1 + 1?", Q1Answers, 4);
		Question Q2 = new Question("What is 5 x 20?", Q2Answers, 2); 
	}
}