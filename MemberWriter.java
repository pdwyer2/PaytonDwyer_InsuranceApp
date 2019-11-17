import java.util.ArrayList;
import java.io.*;
import java.beans.XMLEncoder;

public class MemberWriter {
	/**
	 * This class houses functions for writing members to various formats including files and within the program itself.
	 * @author Payton Dwyer
	 */
	
	/**
	 * This function prints the array list of members to the screen in a formatted manner.
	 * @param members is the array list that contains the data for each member
	 */
	public static void writeMembersToScreen(ArrayList<Member> members) {
		System.out.println("");
		for (Member m : members) {
			System.out.print(m.toString());
		}
		System.out.println("");
	}
	/**
	 * This function writes the list of members to a text file in a tab delimited format.
	 * @param fname is the user specified .txt file 
	 * @param members is the array list of members that contains member names and data
	 * @return it will return true if it is able to print successfully or false if it cannot.
	 */
	public static boolean writeMembersToTextFile(String fname, ArrayList<Member> members) {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(
					new FileWriter(fname)));
			for (Member m : members) {
				pw.println(m.toString2());
			}
			pw.close();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	/**
	 * This function writes the list of members to a binary file.
	 * @param fname is the user specified .bin file 
	 * @param members is the array list of members that contains member names and data
	 * @return it will return true if it is able to print successfully or false if it cannot.
	 */
	public static boolean writeMembersToBinary(String fname, ArrayList<Member> members) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fname));
			oos.writeObject(members);
			oos.close();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	/**
	 * This function writes the list of members to an xml file.
	 * @param fname is the user specified .xml file 
	 * @param members is the array list of members that contains member names and data
	 * @return it will return true if it is able to print successfully or false if it cannot.
	 */
	public static boolean writeMembersToXML(String fname, ArrayList<Member> members) {
		try {
			XMLEncoder enc = new XMLEncoder(new BufferedOutputStream(new
					FileOutputStream(fname)));
			enc.writeObject(members);
			enc.close();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
}