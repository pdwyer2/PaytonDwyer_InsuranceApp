public class InsuranceScore {
	/**
	 * This class sets up the insurance score for each member.
	 * An insurance score consists of the member name, point total, and verdict.
	 * It includes default and non default constructors for an insurance score.
	 * Also contains a toString function that formats how an assessment will be printed to screen.
	 * @author Payton Dwyer
	 */
	
	private String firstname;
	private String lastname;
	private int finalScore;
	private String finalVerdict;
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getScore() {
		return finalScore;
	}
	public void setScore(int finalScore) {
		this.finalScore = finalScore;
	}
	public String getVerdict() {
		return finalVerdict;
	}
	public void setVerdict(String finalVerdict) {
		this.finalVerdict = finalVerdict;
	}
	public InsuranceScore(String lastname, String firstname, 
			int totalScore, String finalVerdict) {
		setFirstname(firstname);
		setLastname(lastname);
		setScore(totalScore);
		setVerdict(finalVerdict);
	}
	public InsuranceScore() {
		firstname = "";
		lastname = "";
		finalScore = 0;
		finalVerdict = "";
	}
	public String toString3() {
		return String.format("Name:" + "\t\t" + "%s" + "," + "%s\n" + "Score:" + 
				"\t\t" + "%d\n" + "Verdict:" + "\t" + "%s\n", lastname, firstname,
				finalScore, finalVerdict);
	}
}