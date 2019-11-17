import java.util.ArrayList;
import java.io.*;
import org.json.simple.*;
public class InsuranceScoreWriter {
	
	/**
	 * This class includes functions for writingi the insurance score assessments.
	 * It has functions for writing the assessments to the screen and also a JSON file.
	 * @author Payton Dwyer
	 */
	
	/**
	 * This function prints the insurance score assessments to the screen.
	 * It calls the scoreMembers function to score each member and add them to an array list of reports.
	 * @param members is the main array list containing all of the data for each member.
	 */
	public static void writeAssessmentsToScreen(ArrayList<Member> members) {
		Assessor report = new Assessor();
		ArrayList<InsuranceScore> reports = report.scoreMembers(members);
		for (InsuranceScore r : reports) {
			System.out.println(r.toString3());
		}
	}
	
	/**
	 * This function writes the insurance score assessments to a JSON file.
	 * @param fname is the user specified JSON file name
	 * @param Members is the arraylist containing the insurance scores for each member
	 * @return it returns false if an error occurs when printing to a JSON file
	 */
	public static boolean writeAssessmentsToJSON(String fname, 
			ArrayList<InsuranceScore> Members) {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new 
					FileWriter(fname)));
			JSONObject memObj;
			JSONArray array = new JSONArray();
			for (InsuranceScore mem : Members) {
				memObj = new JSONObject();
				memObj.put("lastname,",mem.getLastname());
				memObj.put("firstname",mem.getFirstname());
				memObj.put("score",mem.getScore());
				memObj.put("verdict",mem.getVerdict());
				array.add(memObj);
			}
			JSONObject outer = new JSONObject();
			outer.put("students", array);
			pw.println(outer.toJSONString());
			pw.close();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
}