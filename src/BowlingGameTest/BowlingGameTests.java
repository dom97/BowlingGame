package BowlingGameTest;

import BowlingGame.Game;
import junit.framework.TestCase;

public class BowlingGameTests extends TestCase {
	private Game game;
	
	public BowlingGameTests()
	{
		game = new Game();
	}
	
	public void testGutterGame() throws Exception {
		rollMany(20, 0);		
		assertEquals(0, game.score());
	}
	
	public void testAllOnes() throws Exception {	
		rollMany(20, 1);		
		assertEquals(20, game.score());
	}
	
	public void testOneSpare() throws Exception {
		rollMany(2, 5);
		rollMany(18, 1);
		
		assertEquals(29, game.score());
	}
	
	public void testOneStrike() throws Exception {
		rollMany(1, 10);
		rollMany(18, 1);
		
		assertEquals(30, game.score());
	}
	
	public void testAllStrikes() throws Exception {
		rollMany(12, 10);
		
		assertEquals(300, game.score());
	}
	
	public void testMixOfSparesAndStrikes() throws Exception {
		rollMany(2, 10);
		rollMany(6, 5);
		rollMany(10, 2);
		
		assertEquals(107, game.score());
	}
	
	private void rollMany(int rolls, int pins)
	{
		for (int i = 0; i < rolls; i++)
			game.roll(pins);		
	}
}
