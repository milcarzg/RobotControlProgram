import java.awt.Point;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;


public class Constants 
{
	ArrayList<String> COMPASS = new ArrayList<String>(Arrays.asList(new String[] {"N","E","S","W"}));
	ArrayList<String> MOVES = new ArrayList<String>(Arrays.asList(new String[] {"R","L","F"}));
	String board = null;
	int LEFT = -1;
	int RIGHT = 1;
	int NORTH = -1;
	int SOUTH = 1;
	int WEST = -1;
	int EAST = 1;
	int ORIENTATION = 0;
	Point location = new Point();
	String sizeMsg = "Enter size of the room :  (X Y format)";
	String originMsg = "Enter start point and orientation :  (X Y Z format)";
	String moveMsg = "Enter movements :  (XYZ format)";
	String correctSizeMsg = "Enter size of the room : \n Correct input contains 2 integers seperated by space";
	String correctOriginMsg = "Enter start point and orientation :  \n Correct input contains 2 integers an letter seperated by spaces (allowed letters : 'N','E','S','W')";
	String correctMoveMsg = "Enter movements : \n Correct input contains only letters without spaces (allowed letters 'R','L','F')";
	String wrongMsg = "Wrong input";
	String wallMsg = "You tried walking into wall {0} times " ;
	String wrongOriginMsg = "Minimum start position is 1 1";
	String wrongSizeMsg = "Minimum board size is 1 1";
	int wallCount = 0;
	
	public void setBoardSize(int x, int y)
	{
		board = String.valueOf(x) + " x " + String.valueOf(y);
	}
	
	public void increaseWall ()
	{
		wallCount = wallCount + 1;
	}
	
	public void setLocation(int x, int y)
	{
		location.setLocation(x, y);
	}
	
	public Point getLocation()
	{
		return location;
	}
	
	public void changeOrientation(int change)
	{
		if (ORIENTATION + change == COMPASS.size())
		{
			setOrientation(COMPASS.get(0));
		}
		else if (ORIENTATION + change == -1)
		{
			setOrientation(COMPASS.get(3));
		}
		else
		{
			setOrientation(COMPASS.get(ORIENTATION+change));
		}
	}
	
	public void setOrientation(String orientation)
	{
		ORIENTATION = COMPASS.indexOf(orientation);
	}
	
	public String getOrientation()
	{
		return COMPASS.get(ORIENTATION);
	}
}
