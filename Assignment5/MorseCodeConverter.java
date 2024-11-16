import java.io.*;
import java.util.*;


public class MorseCodeConverter {
	static MorseCodeTree tree = new MorseCodeTree();
	public static String printTree() {
		String letters = "";
		ArrayList<String> list = tree.toArrayList();
		for(int i = 0;i <list.size();i++) {
			letters += list.get(i) + " ";
		}
		letters = letters.substring(0, letters.length()-1);
		return letters;
	}
	public static String convertToEnglish(String code) {
		String[] words = code.split("/");
		String[][] letters = new String[words.length][];
		for(int i = 0; i < letters.length;i++) {
			letters[i] = words[i].split(" ");
		}
		String english = "";
		for(int i = 0; i < letters.length;i++) {
			for(int j = 0; j < letters[i].length;j++) {
				english += tree.fetch(letters[i][j]);
			}
			english += " ";
		}
		english = english.substring(0, english.length()-1);
		return english;
	}
	public static String convertToEnglish(File codeFile) throws FileNotFoundException {
		Scanner scan = new Scanner(codeFile);
		String code = "";
		while(scan.hasNext()) {
			code += scan.nextLine();
		}
		String english = convertToEnglish(code);
		return english;
	}
}
