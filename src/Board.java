import java.awt.Point;
import java.text.MessageFormat;
/**
 * Class responsible for moving the robot in the table
 * @author 6pM
 *
 */
public class Board 
{
	private static int[][] _board;
	Global global = new Global();
	Communication com = new Communication();
	
	/**
	 * Initialize the board
	 * @param col
	 * @param row
	 */
	public void init(int col, int row)
	{
		_board = new int[row][col];
	}
	/**
	 * @return int[][] - board size
	 */
	public int[][] getBoard()
	{
		return _board;
	}
	/**
	 * Set initial origin of the robot
	 * @param row
	 * @param col
	 * @param orientation
	 */
	public void setOrigin(int row, int col, String orientation)
	{
		try
		{
			// decrease row/column value by 1 because array starts iterating from 0
			_board[row-1][col-1] = 1;
			global.setOrientation(orientation);
			global.setLocation(row, col);
		} catch (ArrayIndexOutOfBoundsException e) { com.print(MessageFormat.format(global.wrongOriginMsg, getSize()));}
	}
	/**
	 * Find location of the robot
	 * @return Point
	 */
	public Point getLocation()
	{
		for (int rowIndex = 0; rowIndex < _board.length; rowIndex++)
		{
			int[] row = _board[rowIndex];
			if (row!=null)
			{
				for (int columnIndex = 0; columnIndex < row.length; columnIndex++)
				{
					if (row[columnIndex] == 1)
					{
						return new Point(rowIndex, columnIndex);
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * Execute each move and print the final position
	 * @param moves
	 */
	public void play(char[] moves)
	{
		for (char m : moves)
		{
			switch(String.valueOf(m))
			{
				case "R":
					global.changeOrientation(global.RIGHT);
					break;
				case "L":
					global.changeOrientation(global.LEFT);
					break;
				case "F":
					move();
					break;
				default :
					throw new IllegalArgumentException("Invalid Comand");
			}
		}
		Point end = global.getLocation();
		if (end != null)
		{
			com.print(String.valueOf(end.x) + " " + String.valueOf(end.y) +" "+ getOrientation() );
		}
		if(global.wallCount > 0) { com.print(MessageFormat.format(global.wallMsg,global.wallCount)); }
	}
	/**
	 * Execute forward move
	 */
	public void move()
	{
		Point current = global.getLocation();
		Point next = new Point();
		switch(global.getOrientation() )
		{
			case "N" :
				//System.out.println("N");
				//System.out.println(current.x + " " + current.y);
				next.y = current.y + global.NORTH;
				next.x = current.x;
				//System.out.println(next.x + " " + next.y);
				push(current, next);
				break;
			case "E" :
				//System.out.println("E");
				//System.out.println(current.x + " " + current.y);
				next.y = current.y;
				next.x = current.x + global.EAST;
				//System.out.println(next.x + " " + next.y);
				push(current, next);
				break;
			case "S" :
				//System.out.println("S");
				//System.out.println(current.x + " " + current.y);
				next.y = current.y + global.SOUTH;
				next.x = current.x;
				//System.out.println(next.x + " " + next.y);
				push(current, next);
				break;
			case "W" :
				//System.out.println("W");
				//System.out.println(current.x + " " + current.y);
				next.y = current.y;
				next.x = current.x + global.WEST;
				//System.out.println(next.x + " " + next.y);
				push(current, next);
				break;
		}
	}
	
	public int getElement(int col, int row)
	{
		// decrease row/column value by 1 because array starts iterating from 0
		return _board[col-1][row-1];
	}
	/**
	 * Format of Y x Z
	 * @return string size of board
	 */
	public String getSize()
	{
		int r = 0;
		int c = 0;
		for (int [] row : _board) 
		{
			r++;
			c = 0;
			for ( int column : row)
			{
				c++;
			}
		}
		String text = String.valueOf(r) + " x " + String.valueOf(c);
		return text;
	}
	/**
	 * Relocate the robot
	 * @param current - current position of robot
	 * @param next - next position of robot
	 */
	public void push(Point current, Point next)
	{
		try {
			// decrease row/column value by 1 because array starts iterating from 0
			_board[next.x-1][next.y-1] = 1;
			_board[current.x-1][current.y-1] = 0;
			global.setLocation(next.x, next.y);
		} catch (ArrayIndexOutOfBoundsException e) { global.increaseWall();}
		
	}
	
	public String getOrientation()
	{
		return global.getOrientation();
	}
}
