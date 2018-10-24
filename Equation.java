import java.lang.Math;

/*
 *  !!!!!!!!!!!!!!!!!!!!!!!!!! 
 *  Notes for End Users:
 *  Please read the comments, which are grayed out texts like this. 
 *  They should tell you what to do or not to do.
 *  
 *  When variables are defined I'm usually using one of 2 datatypes, double or int
 *  int is short for integer, and an int can be any whole number from 2147483648 to 2147483647
 *  double is a number type that can have up to 2^64 digits and so is very accurate 
 *  Even into very very small numbers. That's why I used it for calculus
 *  !!!!!!!!!!!!!!!!!!!!!!!!!!
 */

public class microsope1 {
	public static void main(String[] args) {		
		//things users change based off what they want the program to find
		//Users are allowed to and encouraged to touch this, these determine the outputs!!!!!
		double x = 0; //starting value of the first window
		double windows = 5; //windows, as in, number of changes from initial change to final change. Will zoom in number of window xs
		double numPerWindow = 100; //how many data points per window
		double initialChange = 1; // what first window will change by
		double finalChange = .000001; //what last window will change by
		double zoomNum = 20; //what number we want the limit of
		
/*  End user no touch, nothing after this this shouldn't change except for line 74, 
 *  the equation. Change that depending on
 *  what equation you want the limit of
 *  Nothing from this point on should be touched (other than line 74) or the program will be liable 
 *  to break. If this happens please restore the original code before asking me about it.
 *  If something breaks and you think its the code's fault feel free to contact me */
		double currentChange = initialChange;
		double windowCurrent = 1;
		int count = 0;		
		double[][] coordinates = new double[(int) (numPerWindow * windows + 2)][2];
		//this makes a 2d array where the first bracket is the x value and the second is the y value.
		System.out.println("Initial Change is: " + initialChange);
		
/*any comments beyond this are explaining the code. If you dont want to understand it, then feel free
*to stop reading here.
*/
		while(initialChange < numPerWindow) { // this will always be true, and ends later 
			if(count > (numPerWindow * windowCurrent) || count > (numPerWindow * windows)) {
//this if then statement causes the following code to execute every x we finish a windows worth of numbers
				windowCurrent++; //increases what window we're on, which is important on lines 36 and 39
				currentChange = (finalChange / initialChange) * Math.pow(10, 5 - windowCurrent);
				//formula for what the delta x is on each window
				x = zoomNum - (.5 * numPerWindow * currentChange);
				//sets it so that no matter the zoom our zoomNum will be on the list
				double slope = ((coordinates[count][1] - coordinates[(int) (count - numPerWindow)][1] )
						/ (count - numPerWindow))/(coordinates[count][0] - coordinates[(int) (count - numPerWindow)][0]);
				//determines the slope of each window
				double microscopeEquation = slope * (coordinates[count][0] - 
coordinates[(int) (count - numPerWindow)][0]) + coordinates[count - 100][1];
//microscope equation, gives us the limit of our target number
				
//the following lines give information for the user. \n causes a line break 
				System.out.println("\nSlope at " +zoomNum + " is: " + slope);
				System.out.println("Limit at " + zoomNum + " is: " + microscopeEquation);
				System.out.println("windowcurrent is: " + windowCurrent);
				System.out.println("windowcurrent * numPerWindow is: " + windowCurrent * numPerWindow);
				System.out.println("Count is : " + count);
				System.out.println("New zoom, the delta x is: " + currentChange + "\n");
			}
/*following if then says that if the number of data points exceeds the number we want, to stop running the
*while loop.That's what the break keyword does, stops the while loop, the print lets the user know it does */
			if(count > numPerWindow * windows ) {
				System.out.println("Please disregard the last windowcurrent and zoom, as it refers\n"
						+ "to data that will not be available to you, the user \n");
				System.out.println("Zoomed in as far as user requested, ending program. \n"
							+ "If you would like to zoom in more or try a different equation, \n"
							+ "please change your console inputs or contact a programmer to assist you");
				break;
			}
			
				x = x + currentChange; //increases x by our current delta x
				
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! End user can touch
				double equation = Math.sin(x) ; //the equation we are using, end users can change this.
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! End user can no longer touch
				
				coordinates[count][0] = x; //sets a new x value every x the loop runs
				coordinates[count][1] = equation ; //runs the equation and sets its value
// sets a new y value every x a new x value is made, with x being the x value
				System.out.print(coordinates[count][0] + " , "); //prints x coordinates
				System.out.println(coordinates[count][1]); //prints the y coordinates
				count++;
		}	
	}
}

