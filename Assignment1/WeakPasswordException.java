
public class WeakPasswordException extends Exception{
	WeakPasswordException(){
		super("Password is OK but weak");
	}
}
