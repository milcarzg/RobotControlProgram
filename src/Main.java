

public class Main 
{
	private static String[] _size;
	private static String[] _coordinates;
	private static char[] _steps;
	
	public static void main(String[] args)
	{
		Communication com = new Communication();
		Constants constant = new Constants();
		Board board = new Board();
		
		com.print(constant.sizeMsg);
		
		_size = com.boardSize();
		
		board.init(Integer.valueOf(_size[0]), Integer.valueOf(_size[1]) );
		
		com.print(constant.originMsg);
		
		_coordinates = com.origin();
		
		
		board.setOrigin(Integer.valueOf(_coordinates[0] ), Integer.valueOf(_coordinates[1] ), _coordinates[2] );
		
		com.print(constant.moveMsg);
		
		_steps = com.movements();
		
		board.play(_steps);
	}
}
