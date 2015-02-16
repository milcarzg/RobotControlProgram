import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class for global values.
 * @author 6pM
 *
 */
public class Global 
{
	//Array of possible orientations
	ArrayList<String> COMPASS = new ArrayList<String>(Arrays.asList(new String[] {"N","E","S","W"}));
	//Array of possible moves
	ArrayList<String> MOVES = new ArrayList<String>(Arrays.asList(new String[] {"R","L","F"}));
	int LEFT = -1;
	int RIGHT = 1;
	int NORTH = -1;
	int SOUTH = 1;
	int WEST = -1;
	int EAST = 1;
	int ORIENTATION = 0;
	Point location = new Point();
	//message definitions
	String sizeMsg = "Enter size of the room :  (X Y format)";
	String originMsg = "Enter start point and orientation :  (X Y Z format)";
	String moveMsg = "Enter movements :  (XYZ format)";
	String correctSizeMsg = "Enter size of the room : \n Correct input contains 2 integers seperated by space";
	String correctOriginMsg = "Enter start point and orientation :  \n Correct input contains 2 integers an letter seperated by spaces (allowed letters : 'N','E','S','W')";
	String correctMoveMsg = "Enter movements : \n Correct input contains only letters without spaces (allowed letters 'R','L','F')";
	String wrongMsg = "Wrong input";
	String wallMsg = "You tried walking into wall {0} times " ;
	String wrongOriginMsg = "Origin position has to be between 1 1 and ";
	String wrongSizeMsg = "Minimum board size is 1 1 ";
	int wallCount = 0;
	
	
	public void increaseWall ()
	{
		wallCount = wallCount + 1;
	}
	
	public void setLocation(int row, int col)
	{
		location.setLocation(row, col);
	}
	
	public Point getLocation()
	{
		return location;
	}
	/**
	 * Changes orientation of the robot
	 * @param change
	 */
	public void changeOrientation(int change)
	{
		if (ORIENTATION + change == COMPASS.size() )
		{
			setOrientation(COMPASS.get(0));
		}
		else if (ORIENTATION + change == -1)
		{
			setOrientation(COMPASS.get(3) );
		}
		else
		{
			setOrientation(COMPASS.get(ORIENTATION+change) );
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
