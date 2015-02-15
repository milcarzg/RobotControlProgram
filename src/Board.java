import java.awt.Point;
import java.text.MessageFormat;

public class Board 
{
	private static int[][] _board;
	Constants constant = new Constants();
	Communication com = new Communication();
	
	public void init(int x, int y)
	{
		_board = new int[x][y];
		constant.setBoardSize(x, y);
	}
	public int[][] getBoard()
	{
		return _board;
	}
	
	public void setOrigin(int y, int x, String orientation)
	{
		try
		{
			_board[x-1][y-1] = 1;
			constant.setOrientation(orientation);
			constant.setLocation(x, y);
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
		com.print(String.valueOf(end.y) + " " + String.valueOf(end.x) +" "+ constant.COMPASS.get(constant.ORIENTATION) );
		if(constant.wallCount > 0) { com.print(MessageFormat.format(constant.wallMsg,constant.wallCount)); }
	}
	
	public void move()
	{
		Point current = constant.getLocation();
		
		Point next = new Point();
		switch(constant.getOrientation() )
		{
			case "N" :
					next.y = current.y;
					next.x = current.x + constant.NORTH;
					push(current, next);
					break;
			case "E" :
					next.y = current.y + constant.EAST;
					next.x = current.x;
					push(current, next);
					break;
			case "S" :
					next.y = current.y;
					next.x = current.x + constant.SOUTH;
					push(current, next);
					break;
			case "W" :
					next.y = current.y + constant.WEST;
					next.x = current.x;
					push(current, next);
					break;
		}
	}
	
	public int getElement(int x, int y)
	{
		return _board[x-1][y-1];
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
