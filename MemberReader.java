import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.beans.XMLDecoder;
public class MemberReader {
	
	/**
	 * This class includes functions for reading in different file formats such as .txt, .bin, and .xml
	 * @author Payton Dwyer
	 */
	
	/**
	 * This function reads in members and their data from a text file.
	 * For each line in the text file it splits the data at the tabs.
	 * @param fname is the name of the user inputted text file
	 * @return it will return an array list containing all of the members from the text file and their data
	 */
	public static ArrayList<Member> readMembersFromTextFile(String fname) {
		ArrayList<Member> result = new ArrayList<Member>();
		try {
			Scanner fsc = new Scanner(new File(fname));
			String line; String firstname = ""; String lastname = ""; 
			String cancer = ""; String diabetes = ""; String alzheimers = "";
			int age = 0; int height = 0; int weight = 0; int BPsyst = 0; int BPdias = 0;
			Member mem;
			while (fsc.hasNextLine()) {
				line = fsc.nextLine().trim();
				String[] parts = line.split("\t");
				for (String part : parts) {
					firstname = parts[0];
					lastname = parts[1];
					age = Integer.parseInt(parts[2]);
					height = Integer.parseInt(parts[3]);
					weight = Integer.parseInt(parts[4]);
					BPsyst = Integer.parseInt(parts[5]);
					BPdias = Integer.parseInt(parts[6]);
					cancer = parts[7];
					diabetes = parts[8];
					alzheimers = parts[9];
				}
				mem = new Member(firstname, lastname, age, height, weight,
						BPsyst, BPdias, cancer, diabetes, alzheimers);
				result.add(mem);
			}
			fsc.close();
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	/**
	 * This function reads in member data from a binary file.
	 * @param fname is the user specified .bin file
	 * @return it will return an array list of members
	 */
	public static ArrayList<Member> readMembersFromBinary(String fname)  {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fname));
			ArrayList<Member> result = (ArrayList<Member>)ois.readObject();
			ois.close();
			return result;
		} catch (Exception ex) {
			return null;
		}
	}
	/**
	 * This function reads in member data from an xml file.
	 * @param fname is the user specified .xml file
	 * @return it will return an array list of members
	 */
	public static ArrayList<Member> readMembersFromXML(String fname) {
		try {
			XMLDecoder dec = new XMLDecoder(new BufferedInputStream(new
					FileInputStream(fname)));
			ArrayList<Member> result = (ArrayList<Member>)dec.readObject();
			dec.close();
			return result;
		} catch (Exception ex) {
			return null;
		}
	}
}