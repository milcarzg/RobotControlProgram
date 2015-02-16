import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;


public class Tests 
{
	@Test
	public void testBoardInit() 
	{
		Board board = new Board();
		board.init(5, 5);
		assertEquals(board.getSize(), "5 x 5");
	}
	
	@Test
	public void testOrigin() 
	{
		Board board = new Board();
		board.init(5, 5);
		board.setOrigin(2, 3, "N");
		assertEquals(board.getLocation(), new Point(1,2) );
	}
	
	@Test
	public void testNorthMove() 
	{
		Board board = new Board();
		board.init(5, 5);
		board.setOrigin(3, 4, "N");
		//System.out.println(board.getLocation().toString());
		board.move();
		//System.out.println(board.getLocation().toString());
		assertEquals(board.getLocation(), new Point(2,2));
	}
	@Test
	public void testSouthMove() 
	{
		Board board = new Board();
		board.init(5, 5);
		board.setOrigin(3, 4, "S");
		//System.out.println(board.getLocation().toString());
		board.move();
		//System.out.println(board.getLocation().toString());
		assertEquals(board.getLocation(), new Point(2,4));
	}
	@Test
	public void testWestMove() 
	{
		Board board = new Board();
		board.init(5, 5);
		board.setOrigin(3, 4, "W");
		//System.out.println(board.getLocation().toString());
		board.move();
		//System.out.println(board.getLocation().toString());
		assertEquals(board.getLocation(), new Point(1,3));
	}
	@Test
	public void testEastMove() 
	{
		Board board = new Board();
		board.init(5, 5);
		board.setOrigin(3, 4, "E");
		//System.out.println(board.getLocation().toString());
		board.move();
		//System.out.println(board.getLocation().toString());
		assertEquals(board.getLocation(), new Point(3,3));
	}
	@Test
	public void testWallMove() 
	{
		Board board = new Board();
		board.init(5, 5);
		board.setOrigin(1, 1, "N");
		//System.out.println(board.getLocation().toString());
		board.move();
		//System.out.println(board.getLocation().toString());
		assertEquals(board.getLocation(), new Point(0,0));
	}
	
	
	@Test
	public void testLeftPlay() 
	{
		Board board = new Board();
		board.init(5, 5);
		board.setOrigin(1, 1, "N");
		char[] moves = new String("L").toCharArray();
		board.play(moves);
		assertEquals(board.getOrientation(),"W");
	}
	@Test
	public void testRightPlay() 
	{
		Board board = new Board();
		board.init(5, 5);
		board.setOrigin(1, 1, "N");
		char[] moves = new String("R").toCharArray();
		board.play(moves);
		assertEquals(board.getOrientation(),"E");
	}
	

}
