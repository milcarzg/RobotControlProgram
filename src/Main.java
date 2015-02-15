import java.awt.Point;
import java.util.Arrays;

public class Main 
{
	private static String _room;
	private static String[] size;
	private static String _origin;
	private static String[] _coordinates;
	private static char[] _steps;
	private static String _moves;
	
	public static void main(String[] args)
	{
		Communication com = new Communication();
		Constants constant = new Constants();
		Board board = new Board();
		
		com.print(constant.sizeMsg);
		
		size = com.boardSize();
		
		board.init(Integer.valueOf(size[0]), Integer.valueOf(size[1]) );
		
		com.print(constant.originMsg);
		
		_coordinates = com.origin();
		
		
		board.setOrigin(Integer.valueOf(_coordinates[0] ), Integer.valueOf(_coordinates[1] ), _coordinates[2] );
		
		com.print(constant.moveMsg);
		
		_steps = com.movements();
		
		board.play(_steps);
	}
}
