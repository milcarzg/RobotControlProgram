import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Communication 
{
	private static String _text;
	Constants constant = new Constants();
	private int _row = 0;
	private int _col = 0;
	
	public String read()
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in) );
		try 
		{
			_text = in.readLine();
		} catch (IOException e) { e.printStackTrace(); }
		return _text;
	}
	
	public String[] boardSize()
	{
		String[] parts = null;
		do
		{
			String text = read();
			parts = text.trim().split("\\s+");
			if (parts.length != 2 || isNumeric(parts[0]) == false
					|| isNumeric(parts[1]) == false)
			{
				print(constant.wrongMsg);
				print(constant.correctSizeMsg);
			}
			else if (Integer.valueOf(parts[0]) < 1 || Integer.valueOf(parts[1]) < 1)
			{
				print(constant.wrongSizeMsg);
				print(constant.correctSizeMsg);
			}
		} while  (parts.length != 2 || isNumeric(parts[0]) == false
				|| isNumeric(parts[1]) == false 
				|| Integer.valueOf(parts[0]) < 1 || Integer.valueOf(parts[1]) < 1);
		_row = Integer.valueOf(parts[0]);
		_col = Integer.valueOf(parts[1]);
		return parts;
	}
	public String[] origin()
	{
		String[] origin = null; 
		do
		{
			String text = read();
			origin = text.trim().split("\\s+");
			if ((origin.length != 3 || isNumeric(origin[0]) == false || 
					isNumeric(origin[1]) == false || constant.COMPASS.contains(origin[2]) == false) )
			{
				print(constant.wrongMsg);
				print(constant.correctOriginMsg);
			}
			else if (Integer.valueOf(origin[0]) < 1 || Integer.valueOf(origin[1]) < 1
					|| Integer.valueOf(origin[0]) > _row || Integer.valueOf(origin[1]) > _col)
			{
				print(constant.wrongOriginMsg + _row + " "+ _col);
				print(constant.originMsg);
			}
		} while ( (origin.length != 3 || isNumeric(origin[0]) == false || 
				isNumeric(origin[1]) == false || constant.COMPASS.contains(origin[2]) == false) 
				|| Integer.valueOf(origin[0]) < 1 || Integer.valueOf(origin[1]) < 1
				|| Integer.valueOf(origin[0]) > _row || Integer.valueOf(origin[1]) > _col);
		return origin;
	}
	
	public char[] movements()
	{
		char[] moves = null;
		do
		{
			String text = read();
			moves = text.toCharArray();
			if (isValidMove(moves) == false)
			{
				print(constant.wrongMsg);
				print(constant.correctMoveMsg);
			}
			else
			{
				return moves;
			}
		} while (isValidMove(moves) == false);
		return moves;
	}
	
	public void print(String text)
	{
		System.out.println(text);
	}
	
	public static boolean isNumeric(String str)
	{
		if (Character.isDigit(str.toCharArray()[0]) == false ) { return false;}
		else { return true; }
	}
	
	public boolean isValidMove(char[] moves)
	{
		for(char move : moves)
		{
			if (constant.MOVES.contains(String.valueOf(move)) == false )
			{
				return false;
			}
		}
		return true;
	}

}
