
public class NoSpecialCharacterException extends Exception{
	NoSpecialCharacterException(){
		super("The password must contain at least one special character");
	}
}
