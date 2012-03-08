///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            TestLinkedSet.java
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
 * This class demonstrates the capability of the LinkedSet class. The user
 * enters numbers to make a list and different commands to show what the 
 * class does. It is not robust against improper input from the user because
 * it is a test program and proper input was assumed.
 *
 * <p>Bugs: not robust for input
 *
 * @author Erin Rasmussen
 */
public class TestLinkedSet {
	
	public static void main(final String[] args) {
		LinkedSet<Integer> ls = new LinkedSet<Integer>();
		Iterator<Integer> iter;
		Scanner stdin = new Scanner(System.in);
		String input = "1";
		boolean done = false;
		printOptions();
		while (!done) {
			System.out.print("Enter option ( acheiqlrus ): ");
			input = stdin.nextLine();
			input = input.toLowerCase();  // convert input to lower case
			int position = 0;
			LinkedSet<Integer> ls2 = new LinkedSet<Integer>();
			LinkedSet<Integer> ls3 = new LinkedSet<Integer>();
			// only do something if the user enters at least one character
			if (input.length() > 0) {
				char choice = input.charAt(0);  // strip off option character
				String remainder = "";  // used to hold the remainder of input
				if (input.length() > 1) {
					// trim off any leading or trailing spaces
					remainder = input.substring(1).trim(); 
				}

				switch (choice) {
				
				case 'a':
					if (ls.contains(Integer.parseInt(remainder))){
						System.out.println("You already added that!!");
					}
					ls.add(Integer.parseInt(remainder));
					break;
				
				case 'c':
					if (ls.contains(Integer.parseInt(remainder))){
						System.out.println(Integer.parseInt(remainder) 
								+ " is in your LinkedSet");
					}
					else {
						System.out.println(Integer.parseInt(remainder) 
								+ " is not in your LinkedSet");
					}
					break;
					
				case 'h': 
					printOptions();
					break;
					
				case 'e':
					if (ls.isEmpty()){
						System.out.println("Your LinkedSet is empty");
					}
					else {
						System.out.println("Your LinkedSet is not" +
								" empty and has " + ls.size() + " integers");
					}

					break;	
					
				case 'i':
					position = 0;
					while (!input.equals("n")){
					   System.out.println("Please enter an integer for your " +
								"LinkedSet" + " to show the intersection");
						input = stdin.next();
						if (!input.equals("n")){
						position = Integer.parseInt(input);
						ls2.add(position);
						}
					}
					ls3 = (LinkedSet<Integer>) ls.intersection(ls2);
					iter = ls3.iterator();
					while (iter.hasNext()){
						System.out.print(iter.next() + ", ");
					}
					System.out.println();

					break;

				case 'q':
					done = true;
					System.out.println("quit");
					break;

				case 'l':
					ls.clear();
					System.out.println("The size of your LinkedSet is now " 
							+ ls.size());
					break;
					
				case 'r':
					ls.remove(Integer.parseInt(remainder));
					break;
					
				case 'u':
					position = 0;
					while (!input.equals("n")){
						System.out.println("Please enter an integer for " +
								"your LinkedSet" + " to show the union");
						input = stdin.next();
						if (!input.equals("n")){
						position = Integer.parseInt(input);
						ls2.add(position);
						}
					}
					ls3 = (LinkedSet<Integer>) ls.union(ls2);
					iter = ls3.iterator();
					while (iter.hasNext()){
						System.out.print(iter.next() + ", ");
					}
					System.out.println();
					break;

				case 's':
					System.out.println(ls.size());
					break;

				default:  // ignore any unknown commands
					break;
				}
			}
		}
	}
	
	private static void printOptions() {
		System.out.println("a <integer> add an integer to your list");
		System.out.println("c <integer> see if the linked set contains your " +
				"integer");
		System.out.println("e - see if the linked list is empty");
		System.out.print("i <LinkedSet> returns the intersections of the " +
				"two sets");
		System.out.print(" list integers separated by commas 1,2,3 for the " +
				"other set");
		System.out.println();
		System.out.println("q - quit");
		System.out.println("h - print options");
		System.out.println("u <LinkedSet> - returns the union of the two " +
				"sets");
		System.out.println("l - clears the set");
		System.out.print("r <integer> - remove the integer from the linked " +
				"list");
		System.out.println();
		System.out.print("s - returns the amount of integers in the list");
		System.out.println();
	}
	
}
