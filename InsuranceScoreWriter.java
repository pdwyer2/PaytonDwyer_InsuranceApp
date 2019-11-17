import java.util.ArrayList;
import java.io.*;
import org.json.simple.*;
public class InsuranceScoreWriter {
	
	public static void writeAssessmentsToScreen(ArrayList<Member> members) {
		Assessor report = new Assessor();
		ArrayList<InsuranceScore> reports = report.scoreMembers(members);
		for (InsuranceScore r : reports) {
			System.out.println(r.toString3());
		}
	}
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