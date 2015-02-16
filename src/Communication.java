import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Class responsible for reading user`s input and writing output
 * @author 6pM
 *
 */
public class Communication 
{
	private String _text;
	Global global = new Global();
	private int _row = 0;
	private int _col = 0;
	
	public String read()
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in) );
		try 
		{
			_text = in.readLine();
			//for testing purposes
			//if (_text != null) { System.out.println(_text); }
		} catch (IOException e) { e.printStackTrace(); }
		return _text;
	}
	/**
	 * Reads input and splits String to get 2 numbers
	 * Validates for correct input
	 * @return String[] - number of rows and columns
	 */
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
				print(global.wrongMsg);
				print(global.correctSizeMsg);
			}
			else if (Integer.valueOf(parts[0]) < 1 || Integer.valueOf(parts[1]) < 1)
			{
				print(global.wrongSizeMsg);
				print(global.correctSizeMsg);
			}
		} while  (parts.length != 2 || isNumeric(parts[0]) == false
				|| isNumeric(parts[1]) == false 
				|| Integer.valueOf(parts[0]) < 1 || Integer.valueOf(parts[1]) < 1);
		_row = Integer.valueOf(parts[0]);
		_col = Integer.valueOf(parts[1]);
		return parts;
	}
	/**
	 * Reads input and splits String to get 3 values
	 * Validates input
	 * @return String[] 0 - column 1 - row 2 - orientation
	 */
	public String[] origin()
	{
		String[] origin = null; 
		do
		{
			String text = read();
			origin = text.trim().split("\\s+");
			if ((origin.length != 3 || isNumeric(origin[0]) == false || 
					isNumeric(origin[1]) == false || global.COMPASS.contains(origin[2]) == false) )
			{
				print(global.wrongMsg);
				print(global.correctOriginMsg);
			}
			else if (Integer.valueOf(origin[0]) < 1 || Integer.valueOf(origin[1]) < 1
					|| Integer.valueOf(origin[0]) > _row || Integer.valueOf(origin[1]) > _col)
			{
				print(global.wrongOriginMsg + _row + " "+ _col);
				print(global.originMsg);
			}
		} while ( (origin.length != 3 || isNumeric(origin[0]) == false || 
				isNumeric(origin[1]) == false || global.COMPASS.contains(origin[2]) == false) 
				|| Integer.valueOf(origin[0]) < 1 || Integer.valueOf(origin[1]) < 1
				|| Integer.valueOf(origin[0]) > _row || Integer.valueOf(origin[1]) > _col);
		return origin;
	}
	/**
	 * Reads input and puts it to char[]
	 * Validates input
	 * @return char[] - array of moves
	 */
	public char[] movements()
	{
		char[] moves = null;
		do
		{
			String text = read();
			moves = text.toCharArray();
			if (isValidMove(moves) == false)
			{
				print(global.wrongMsg);
				print(global.correctMoveMsg);
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
	/**
	 * validates that entered stinrg is a number
	 * @param str
	 * @return boolean true/false
	 */
	public static boolean isNumeric(String str)
	{
		if (Character.isDigit(str.toCharArray()[0]) == false ) { return false;}
		else { return true; }
	}
	/**
	 * Validates that only "R","L","F" letters are entered
	 * @param moves - char[] of moves
	 * @return boolean true/false
	 */
	public boolean isValidMove(char[] moves)
	{
		for(char move : moves)
		{
			if (global.MOVES.contains(String.valueOf(move)) == false )
			{
				return false;
			}
		}
		return true;
	}

}
