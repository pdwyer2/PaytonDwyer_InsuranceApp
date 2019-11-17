import java.util.ArrayList;
public class Assessor {
	/**
	 * This class assesses an individual member based on point values.
	 * It then adds each member to an array list to print a report.
	 * @author Payton Dwyer
	 */
	
	
	/**
	 * This function scores an individual member by accessing information about age, weight, BP, etc.
	 * It determines a total point value and then delivers a verdict based on those points.
	 * @param members the array list containing all of the data for each member read in from the file
	 * @return returns a new array list that contains the name, point total, and verdict for each member assessed. 
	 */
	public ArrayList<InsuranceScore> scoreMembers(ArrayList<Member> members) {
		ArrayList<InsuranceScore> Members = new ArrayList<InsuranceScore>();
		InsuranceScore mem;
		for (Member m : members) {
		String lastname = m.getLastname();
		String firstname = m.getFirstname();
		int age = m.getAge();
		int weight = m.getWeight();
		int BPsys = m.getBPsyst();
		int BPdia = m.getBPdias();
		String cancer = m.getCancer();
		String diabetes = m.getDiabetes();
		String alzheimers = m.getAlzheimers();
		double kgweight = (m.getWeight() * (0.45359237));
		double msquaredheight = ((m.getHeight() * m.getHeight()) * (0.00064516));
		double BMI = kgweight/msquaredheight;
		int points = 0;
		//Age point calculations
		if (age < 30) {
			points = points + 0;
		} else if ((age >= 30) & (age < 40)) {
			points = points + 10;
		} else if ((age >= 40) & (age < 60)) {
			points = points + 20;
		} else {
			points = points + 30;
		}
		//BMI point calculations
		if ((BMI >= 18.5) & (BMI <= 24.9)) {
			points = points + 0;
		} else if ((BMI >= 25.0) & (BMI <= 29.9)) {
			points = points + 30;
		} else {
			points = points + 75;
		}
		//Blood pressure point calculations
		if ((BPsys < 120) & (BPdia < 80)) {
			points = points + 0;
		} else if (((BPsys >= 120) & (BPsys <= 129)) & (BPdia < 80)) {
			points = points + 15;
		} else if (((BPsys >= 130) & (BPsys <= 139)) | ((BPdia >= 80) & (BPdia <= 90))) {
			points = points + 30;
		} else if (((BPsys >= 140) & (BPsys <= 180)) | ((BPdia >= 90) & (BPdia <= 120))) {
			points = points + 75;
		} else if ((BPsys > 180) || (BPdia > 120)) {
			points = points + 100;
		}
		//Family disease point calculation
		if (cancer.equals("y")) {
			points = points + 10;
		} else if (diabetes.equals("y")) {
			points = points + 10;
		} else if (alzheimers.equals("y")) {
			points = points + 10;
		} else {
			points = points + 0;
		}
		String verdict = null;
		if (points <= 20) {
			verdict = "low risk";
		} else if ((points <= 50) & (points > 20)) {
			verdict = "moderate risk";
		} else if ((points <= 75) & (points > 50)) {
			verdict = "high risk";
		} else {
			verdict = "uninsurable";
		}	
		mem = new InsuranceScore(lastname, firstname, points, verdict);
		Members.add(mem);
		}
		return Members;		
	}
}