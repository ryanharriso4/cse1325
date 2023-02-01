public class Quizzer
{
	public static void main(String [] args)
	{
		try
		{
			Quiz quiz = new Quiz(); 
			System.out.println("You got a score of: " + (quiz.takeQuiz() * 100) + "%."); 

		}
		catch(IllegalArgumentException e)
		{
			System.err.println(e); 
			System.exit(-1); 
		}
	}
}