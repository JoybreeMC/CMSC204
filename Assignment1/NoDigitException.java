
public class NoDigitException extends Exception{
	NoDigitException(){
		super("The password must contain at least one digit");
	}
}
