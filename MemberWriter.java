import java.util.ArrayList;
import java.io.*;
import java.beans.XMLEncoder;

public class MemberWriter {
	public static void writeMembersToScreen(ArrayList<Member> members) {
		System.out.println("");
		for (Member m : members) {
			System.out.print(m.toString());
		}
		System.out.println("");
	}
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