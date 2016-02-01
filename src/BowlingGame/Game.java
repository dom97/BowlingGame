package BowlingGame;

public class Game {
	
	private int[] rolls;
	private int roll;	
	
	public Game()
	{
		rolls = new int[21];
		roll = 0;
	}
	
	public void roll(int pins)
	{
		rolls[roll++] = pins;
	}
	
	public int score()
	{
		int currentRoll = 0;
		int score = 0;
		
		for (int frame = 0; frame < 10; frame++)
		{
			if (isStrike(currentRoll))
			{
				score += calculateStrikeFrame(currentRoll);
				currentRoll++;
			}
			else if (isSpare(currentRoll))
			{
				score += calculateSpareFrame(currentRoll);
				currentRoll += 2;
			}
			else
			{
				score += calculateOpenFrame(currentRoll);
				currentRoll += 2;
			}
		}
		
		return score;
	}

	private int calculateOpenFrame(int roll) {
		return rolls[roll] + rolls[roll + 1];
	}

	private int calculateStrikeFrame(int roll) {
		return rolls[roll] + rolls[roll + 1] + rolls[roll + 2];
	}

	private int calculateSpareFrame(int roll) {
		return rolls[roll] + rolls[roll + 1] + rolls[roll + 2];
	}
	
	private boolean isStrike(int roll)
	{
		return rolls[roll] == 10;
	}
	
	private boolean isSpare(int roll)
	{
		return calculateOpenFrame(roll) == 10;
	}
}
