
public class NoLowerAlphaException extends Exception {
	NoLowerAlphaException(){
		super("The password must contain at least one lowercase alphabetic character");
	}
}
