import java.util.*;

public class CLI {
	private static Scanner input = new Scanner(System.in);
	
	//main method
	public static void main(String[] args) {
			String str1 = readLine("Type some text: ");
			System.out.println("Text read is: " + str1);
			int i = readPosInt("Type an integer: ");
			System.out.println("Integer read is: " + i);
			String str2 = readLine("Type some text again: ");
			System.out.println("Text read is: " + str2);
	}
	
	//read a line
	private static String readLine(String a_in) {
		//set the argument for out
		String a_out = null;
		System.out.print(a_in);
		//read the input
		a_out = input.nextLine();
		return a_out;
	}
	private static int readPosInt(String a_in) {
		//local variable
		int judge = 1;
		int i_out=0;
		String temp;
		while(judge==1) {
			System.out.print(a_in);
			//read the input
			try {
				i_out = input.nextInt();
				//judge if positive
				if(i_out >= 0) {
					//if the positive int is read successfully, i will be set to 0 to break the loop
					judge=0;
				}
				else
					//if not positive, which means the function have not return
					System.out.println("Positive integers only!");
			}
			catch(InputMismatchException e) {
				System.out.println("You must type an integer!");
			}
			finally {
				temp = input.nextLine();
			}
		}
		return i_out;
	}
}
