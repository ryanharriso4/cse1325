import java.util.Scanner; 

public class Quiz{

	private Question [] questions = new Question [2]; 

	public Quiz()
	{
		loadQuiz(); 
	}

	public double takeQuiz()
	{
		Scanner in = new Scanner(System.in); 
		double numCorrect = 0; 
		for(int i = 0; i < questions.length; i++)
		{
			System.out.println(questions[i]); 
			System.out.print("What is the correct answer? "); 
			String answer = in.nextLine(); 
			System.out.println("\n\n"); 
			if(questions[i].checkAnswer(Integer.parseInt(answer)))
				numCorrect++; 
		}
		  
		return numCorrect/questions.length; 
	}

	private void loadQuiz()
	{
		String [] Q1Answers = {"-2","-1","100", "2"}; 
		String [] Q2Answers = {"5", "100", "-2", "2"}; 
		Question Q1 = new Question("What is 1 + 1?", Q1Answers, 4);
		Question Q2 = new Question("What is 5 x 20?", Q2Answers, 2); 
		questions[0] = Q1;
		questions[1] = Q2; 
	}
}