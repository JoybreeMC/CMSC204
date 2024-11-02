
public class CourseDBElement implements Comparable<CourseDBElement>{
	private String ID;
	private int CRN;
	private int credits;
	private String room;
	private String instructor;
	
	CourseDBElement(String id, int crn,int cred,String roomNum, String teacher){
		ID = id;
		CRN = crn;
		credits = cred;
		room = roomNum;
		instructor = teacher;
	}
	CourseDBElement(){
		
	}
	public String getID(){
		return ID;
	}
	public int getCRN() {
		return CRN;
	}
	public int getCredits() {
		return credits;
	}
	public String getRoomNum() {
		return room;
	}
	public String getInstructor() {
		return instructor;
	}
	
	public void setID(String id) {
		ID = id;
	}
	public void setCRN(int crn) {
		CRN = crn;
	}public void setCredits(int cred) {
		credits = cred;
	}
	public void setRoomNum(String roomNum) {
		room = roomNum;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	@Override
	public int compareTo(CourseDBElement o) {
		return CRN - o.getCRN();
	
	}
	@Override
	public String toString() {
		String st = "\nCourse:" + ID + " CRN:" + CRN + " Credits:" + credits + " Instructor:" + instructor + " Room:" + room;
		System.out.print(st);
		return st;
	}
	
}
