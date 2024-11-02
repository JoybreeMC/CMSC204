import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
public class CourseDBManager implements CourseDBManagerInterface{
	CourseDBStructure structure;
	CourseDBManager(){
		structure = new CourseDBStructure(100);
	}
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		CourseDBElement element = new CourseDBElement(id,crn,credits,roomNum,instructor);
		structure.add(element);
	}

	@Override
	public CourseDBElement get(int crn) {
		CourseDBElement a;
		try {
			a =structure.get(crn);
		}catch(IOException e) {
			return null;
		}
		return a;
	}

	@Override
	public void readFile(File input) throws FileNotFoundException {
		Scanner read = new Scanner(input);
		while(read.hasNextLine()) {
			String course = read.nextLine();
			String[] data = course.split(" ");
			String ID =  data[0];
			int CRN = Integer.parseInt(data[1]);
			int credits = Integer.parseInt(data[2]);
			String room = data[3];
			String teacher = data[4];
			this.add(ID, CRN, credits, room, teacher);
		}
		
	}

	@Override
	public ArrayList<String> showAll() {
		ArrayList<String> list = structure.showAll();
		return list;
	}
	
}
