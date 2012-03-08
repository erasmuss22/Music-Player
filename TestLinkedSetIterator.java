///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            TestLinkedSetIterator.java
// Files:            LinkedSet.java, SimpleSet.java, LinkedSetIterator.java
// Semester:         Spring 2011
//
// Author:           Erin Rasmussen  ejrasmussen2@wisc.edu
// CS Login:         rasmusse
// Lecturer's Name:  Beck Hasti
// Lab Section:      Lecture 2
//
//                   
//////////////////////////// 80 columns wide //////////////////////////////////
import java.util.*;

/**
 * This class demonstrates the capability of the LinkedSetIterator. The user
 * enters numbers to make a list and different commands to show what the 
 * iterator does. It is not robust against improper input from the user because
 * it is a test program and proper input was assumed.
 *
 * <p>Bugs: not robust for input
 *
 * @author Erin Rasmussen
 */
public class TestLinkedSetIterator {


	public static void main(String[] args) {
		LinkedSet<Integer> ls = new LinkedSet<Integer>();
		Iterator<Integer> iter;
		int[] a1 = new int[20];
		Scanner stdin = new Scanner(System.in);
		String input;
		boolean done = false;
		System.out.println("Please enter an integer for you doubly linked " +
				"chain");
		input = stdin.next();
		ls.add(Integer.parseInt(input));
		a1[0] = Integer.parseInt(input);
		while (!done && (ls.size() < 20)){
			System.out.println("If you'd like another integer in your chain," +
					" enter one, if not, enter n");
			input = stdin.next();
			if (input.equals("n")){
				done = true;
			}
			else {
				ls.add(Integer.parseInt(input));
			}
		}
		System.out.println("You have entered the following chain:");
		iter = ls.iterator();
		while (iter.hasNext()){
			System.out.print(iter.next() + " ");
		}
		System.out.println();
		System.out.println();
		printOptions();
		boolean quit = false;
		while (!quit){
			System.out.print("Enter option ( aphnq ): ");
			iter = ls.iterator();
			input = stdin.nextLine();
			input = input.toLowerCase();
			if (input.length() > 0) {
				char choice = input.charAt(0);  // strip off option character
				String remainder = "";  // used to hold the remainder of input
				if (input.length() > 1) {
					// trim off any leading or trailing spaces
					remainder = input.substring(1).trim(); 
				}

				switch (choice) {
				
				case 'a':
					while (iter.hasNext()){
						System.out.print(iter.next() + " ");
					}
					System.out.println();
					break;
				
				case 'p':
					int pos = Integer.parseInt(remainder);
					int i = 0;
					int result = iter.next();
					if (pos > 0 && pos <= ls.size()){
						while (iter.hasNext() && i < pos - 1){
							result = iter.next();
							i++;
						}
						System.out.println(result);
					}
					else {
						System.out.println("There is no item at that " +
								"position");
					}
					break;
					
				case 'h': 
					printOptions();
					break;
					
				case 'n':
					System.out.println("Press n to advance to show the next " +
							"node, s to stop");
					String y = stdin.next();
					while (iter.hasNext() && !y.equals("s")){
						System.out.print(iter.next() + " ");
						y = stdin.next();
					}
					System.out.println();
					if (y.equals("s")){
						System.out.println("You have choosen to stop");
					}
					else {
						System.out.println("You have reached the end of the " +
								"list");
					}
					break;
					
				case 'q':
					quit = true;
					System.out.println("quit");
					break;
				}
			}
		}
	}
	
	private static void printOptions() {
		System.out.println("a - returns a list of all numbers in list by " +
				"traversing the whole list");
		System.out.println("p <integer> shows the item at this position");
		System.out.println("n - returns the next node in the list");
		System.out.println("h - prints a list of options");
		System.out.println("q - quits");
	}

}
