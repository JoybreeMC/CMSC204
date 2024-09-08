import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordCheckerUtility {
	
	public static void comparePasswords(String password, String passwordConfirm)throws UnmatchedException  {
		if(password.length() != passwordConfirm.length()) {
			throw new UnmatchedException();
		}
		for(int i = 0; i < password.length();i++){
			if(password.charAt(i) != passwordConfirm.charAt(i)) {
				throw new UnmatchedException();
			}
		}
	}
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
		if(password.length() != passwordConfirm.length()) {
			return false;
		}
		for(int i = 0; i < password.length();i++){
			if(password.charAt(i) != passwordConfirm.charAt(i)) {
				return false;
			}
		}
		return true;
	}
	public static boolean isValidLength(String password)throws LengthException {
		if(password.length() < 6) {
			throw new LengthException();
		}
		return true;
	}
	public static boolean hasUpperAlpha(String password)throws NoUpperAlphaException {
		for(int i = 0; i < password.length();i++) {
			if((int)password.charAt(i) >= 65 && (int)password.charAt(i) <= 90) {
				return true;
			}
		}
		throw new NoUpperAlphaException();
	}
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException {
		for(int i = 0; i < password.length();i++) {
			if((int)password.charAt(i) >= 97 && (int)password.charAt(i) <= 122) {
				return true;
			}
		}
		throw new NoLowerAlphaException();
	}
	public static boolean hasDigit(String password)throws NoDigitException {
		for(int i = 0; i < password.length();i++) {
			if(Character.isDigit(password.charAt(i))) {
				return true;
			}
		}
		throw new NoDigitException();
	}
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException {
		for(int i = 0; i < password.length();i++) {
			if(((int)password.charAt(i) >= 32 && (int)password.charAt(i) <= 47)||((int)password.charAt(i) >= 58 && (int)password.charAt(i) <= 64)||((int)password.charAt(i) >= 91 && (int)password.charAt(i) <= 96)||((int)password.charAt(i) >= 123 && (int)password.charAt(i) <= 126)) {
				return true;
			}
		}
		throw new NoSpecialCharacterException();
	}
	public static boolean noSameCharInSequence(String password)throws InvalidSequenceException {
		Pattern pattern = Pattern.compile("((\\w)\\2{2,})");
		Matcher matcher = pattern.matcher(password);
		if(!matcher.find()) {
			return false;
		}
		throw new InvalidSequenceException();

	}
	public static boolean isValidPassword(String password)throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
		if(isValidLength(password) && hasUpperAlpha(password) && hasLowerAlpha(password) && hasDigit(password) && hasSpecialChar(password) && !(noSameCharInSequence(password))) {
			return true;
		}
		return false;
	}
	public static boolean hasBetweenSixAndNineChars(String password) {
		if(password.length() >=6 && password.length() <=9) {
			return true;
		}
		return false;
	}
	public static boolean isWeakPassword(String password)throws WeakPasswordException {
		ArrayList passwordList = new ArrayList();
		if(getInvalidPasswords(passwordList).isEmpty() && !(hasBetweenSixAndNineChars(password))) {
			return false;
		}
		throw new WeakPasswordException();
	}
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {
		int k = 0;
		ArrayList invalidPasswords = new ArrayList();
		for(int i = 0; i < passwords.size();i++) {
			String tempPass = passwords.get(i);
			boolean validPass = false;
			String exception = null;
			try {
				 isValidPassword(tempPass);
				 validPass = true;
			}catch(NoUpperAlphaException e){
				exception = e.getMessage();
			}catch(LengthException e){
				exception = e.getMessage();
			}catch(NoLowerAlphaException e){
				exception = e.getMessage();
			}catch(NoDigitException e){
				exception = e.getMessage();
			}catch(NoSpecialCharacterException e){
				exception = e.getMessage();
			}catch(InvalidSequenceException e){
				exception = e.getMessage();
			}if(!validPass) {
				invalidPasswords.add(tempPass + " " + exception);
			}
		}
		return invalidPasswords;
		
	}
}
