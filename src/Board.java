import java.awt.Point;
import java.text.MessageFormat;

public class Board 
{
	private static int[][] _board;
	Constants constant = new Constants();
	Communication com = new Communication();
	
	public void init(int col, int row)
	{
		_board = new int[row][col];
	}
	public int[][] getBoard()
	{
		return _board;
	}
	
	public void setOrigin(int row, int col, String orientation)
	{
		try
		{
			_board[row-1][col-1] = 1;
			constant.setOrientation(orientation);
			constant.setLocation(row, col);
		} catch (ArrayIndexOutOfBoundsException e) { com.print(MessageFormat.format(constant.wrongOriginMsg, getSize()));}
	}
	
	public Point getLocation()
	{
		for (int rowIndex = 0; rowIndex < _board.length; rowIndex++)
		{
			int[] row = _board[rowIndex];
			if (row!=null)
			{
				for (int columnIndex = 0; columnIndex < row.length; columnIndex++)
				{
					if (1 == row[columnIndex] )
					{
						return new Point(rowIndex, columnIndex);
					}
				}
			}
		}
		return null;
	}
	
	
	public void play(char[] moves)
	{
		for (char m : moves)
		{
			switch(String.valueOf(m))
			{
				case "R":
					constant.changeOrientation(constant.RIGHT);
					break;
				case "L":
					constant.changeOrientation(constant.LEFT);
					break;
				case "F":
					move();
					break;
				default :
					throw new IllegalArgumentException("Invalid Comand");
			}
		}
		Point end = constant.getLocation();
		com.print(String.valueOf(end.x) + " " + String.valueOf(end.y) +" "+ constant.COMPASS.get(constant.ORIENTATION) );
		if(constant.wallCount > 0) { com.print(MessageFormat.format(constant.wallMsg,constant.wallCount)); }
	}
	
	public void move()
	{
		Point current = constant.getLocation();
		Point next = new Point();
		switch(constant.getOrientation() )
		{
			case "N" :
				//System.out.println("N");
				//System.out.println(current.x + " " + current.y);
				next.y = current.y + constant.NORTH;
				next.x = current.x;
				//System.out.println(next.x + " " + next.y);
				push(current, next);
				break;
			case "E" :
				//System.out.println("E");
				//System.out.println(current.x + " " + current.y);
				next.y = current.y;
				next.x = current.x + constant.EAST;
				//System.out.println(next.x + " " + next.y);
				push(current, next);
				break;
			case "S" :
				//System.out.println("S");
				//System.out.println(current.x + " " + current.y);
				next.y = current.y + constant.SOUTH;
				next.x = current.x;
				//System.out.println(next.x + " " + next.y);
				push(current, next);
				break;
			case "W" :
				//System.out.println("W");
				//System.out.println(current.x + " " + current.y);
				next.y = current.y;
				next.x = current.x + constant.WEST;
				//System.out.println(next.x + " " + next.y);
				push(current, next);
				break;
		}
	}
	
	public int getElement(int col, int row)
	{
		return _board[col-1][row-1];
	}
	
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
	
	public void push(Point current, Point next)
	{
		try {
			_board[next.x-1][next.y-1] = 1;
			_board[current.x-1][current.y-1] = 0;
			constant.setLocation(next.x, next.y);
		} catch (ArrayIndexOutOfBoundsException e) { constant.increaseWall();}
		
	}
}
