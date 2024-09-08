
public class NoUpperAlphaException extends Exception{
	NoUpperAlphaException(){
		super("The password must contain at least one uppercase alphabetic character");
	}
}
