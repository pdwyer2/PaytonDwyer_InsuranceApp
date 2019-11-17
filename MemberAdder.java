import java.util.ArrayList;
import java.util.Scanner;

public class MemberAdder {
	
	/**
	 * This class includes a function that adds a new member to the array list of members.
	 * It takes in user inputted data and creates a new member.
	 * @author Payton Dwyer
	 */
	
	/**
	 * This function adds a new member to the array list of members.
	 * @param members is the already existing array list of members that is read in from the file
	 */
	public static void AddMemberToList(ArrayList<Member> members) {
		Scanner sc = new Scanner(System.in);
		String fullname = "";
		String firstname = "";
		String lastname = "";
		int age = 0;
		int height = 0;
		int weight = 0;
		int BPsyst = 0;
		int BPdias = 0;
		String cancer = null;
		String diabetes = null;
		String alzheimers = null;
		
		System.out.print("Enter first and last name: ");
		fullname = sc.nextLine().trim();
		String[] name = fullname.split(" ");
		for (String n : name) {
			firstname = name[0];
			lastname = name[1];
		}
		
		System.out.print("Enter age: ");
		age = sc.nextInt();
		
		System.out.print("Enter height in inches: ");
		height = sc.nextInt();
		
		System.out.print("Enter weight in pounds: ");
		weight = sc.nextInt();
		
		System.out.print("Enter blood pressure (sys and dia): ");
			BPsyst = sc.nextInt();
			BPdias = sc.nextInt();
	
		System.out.print("Has a family member had ...\n");
		System.out.print("Cancer? ");
		cancer = sc.next().toLowerCase();
		System.out.print("Diabetes? ");
		diabetes = sc.next().toLowerCase();
		System.out.print("Alzheimers? ");
		alzheimers = sc.next().toLowerCase();
		members.add(new Member(firstname, lastname, age, height, weight,
				BPsyst, BPdias, cancer, diabetes, alzheimers));
		System.out.println("The new member has been added.");
		System.out.println("");
	}
}