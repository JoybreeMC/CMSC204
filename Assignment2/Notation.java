import java.util.ArrayList;

public class Notation {
	
	public static String convertInfixToPostfix(String infix)throws InvalidNotationFormatException{
		 MyQueue<String> postfixSolutionQueue = new MyQueue(infix.length());
		 MyStack<String> operatorStack = new MyStack(infix.length());
		for(int i = 0; i < infix.length(); i++) {
			if(infix.charAt(i) == ' ') {	
			}else if(Character.isDigit(infix.charAt(i))) {
				try {
					postfixSolutionQueue.enqueue(Character.toString(infix.charAt(i)));
				}catch(QueueOverflowException e){
					throw new InvalidNotationFormatException();
				}
			}else if(infix.charAt(i) == 40) {
				try {
					operatorStack.push(Character.toString(infix.charAt(i)));
				}catch(StackOverflowException e){
					throw new InvalidNotationFormatException();
			}
			}else if(infix.charAt(i) == 41) {
				try {
					while(!operatorStack.top().equals("(")) {
						String temp = operatorStack.pop();
						postfixSolutionQueue.enqueue(temp);
					}
					
				}catch(StackUnderflowException e) {
				
					throw new InvalidNotationFormatException();
				}catch(QueueOverflowException e) {
					throw new InvalidNotationFormatException();

				}
				try {
					operatorStack.pop();
				}catch(StackUnderflowException e) {
					throw new InvalidNotationFormatException();
				}
				
			}else {
				switch(infix.charAt(i)) {
				case '+':
				case '-':
					try {
						while(operatorStack.top() == "+" || operatorStack.top() == "-") {
							String temp = operatorStack.pop();
							postfixSolutionQueue.enqueue(temp);
						}
						operatorStack.push(Character.toString(infix.charAt(i)));
						break;
					}catch(Exception e) {
						throw new InvalidNotationFormatException();
					}
				case '*':
				case '/':
					try {
						while(operatorStack.top() == "+" || operatorStack.top() == "*" ||operatorStack.top() == "/" || operatorStack.top() == "-") {
							String temp = operatorStack.pop();
							postfixSolutionQueue.enqueue(temp);
						}
						operatorStack.push(Character.toString(infix.charAt(i)));
						break;
					}catch(Exception e) {
						throw new InvalidNotationFormatException();
					}
				default: 
					throw new InvalidNotationFormatException();
				}
			}
			/*try {
				System.out.print(postfixSolutionQueue.toString() + " ");
				System.out.println(operatorStack.toString() + " ");
			}catch(Exception e){
		}*/
		
			
		}
		while(!operatorStack.isEmpty()) {
			try {
				postfixSolutionQueue.enqueue(operatorStack.pop());
			}catch(Exception e) {
				throw new InvalidNotationFormatException();
			}
		}
		String solution = "";
		while(!(postfixSolutionQueue.isEmpty())){
			try {
				solution += postfixSolutionQueue.dequeue();
			}catch(QueueUnderflowException e) {
				throw new InvalidNotationFormatException();
			}
		}
		return solution;
	}
	public static String convertPostfixToInfix(String postfix)throws InvalidNotationFormatException{
		MyStack<String> operatorStack = new MyStack(postfix.length());
		for(int i = 0; i < postfix.length();i++) {
			if(postfix.charAt(i) == ' ') {
				
			}else if(Character.isDigit(postfix.charAt(i))){
				try {
					operatorStack.push(Character.toString(postfix.charAt(i)));
				}catch(StackOverflowException e) {
					throw new InvalidNotationFormatException();
				}
			}else if(postfix.charAt(i) == '+'||postfix.charAt(i) == '-'||postfix.charAt(i) == '*'||postfix.charAt(i) == '/') {
				try {
					String temp1 = operatorStack.pop();
					String temp2 = operatorStack.pop();
					String result = "(" + temp2 + Character.toString(postfix.charAt(i)) + temp1 + ")"; 
					operatorStack.push(result);
				}catch(Exception e) {
					throw new InvalidNotationFormatException();
				}
				
			}else {
				throw new InvalidNotationFormatException();
			}
			
		}
		try {
			String awnser = operatorStack.pop();
			if(operatorStack.isEmpty()) {
				for(int i = 0; i < awnser.length();i++) {
					
				}
				return awnser;
			}
		}catch(StackUnderflowException e) {
			throw new InvalidNotationFormatException();
		}
		throw new InvalidNotationFormatException();
	}
	public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException{
		MyStack<String> solutionStack = new MyStack(postfixExpr.length());
		for(int i = 0; i < postfixExpr.length();i++) {
			if(postfixExpr.charAt(i) == ' ') {
				
			}else if(Character.isDigit(postfixExpr.charAt(i))) {
				try {
					solutionStack.push(Character.toString(postfixExpr.charAt(i)));
				}catch(StackOverflowException e) {
					throw new InvalidNotationFormatException();
				}
			}else if(postfixExpr.charAt(i) == '+'||postfixExpr.charAt(i) == '-'||postfixExpr.charAt(i) == '*'||postfixExpr.charAt(i) == '/') {
				String tempResult;
				double temp1;
				double temp2;
				try {
					 temp2 = Double.parseDouble(solutionStack.pop());
					 temp1 = Double.parseDouble(solutionStack.pop());
				}catch(StackUnderflowException e) {
					throw new  InvalidNotationFormatException();
				}
					switch(postfixExpr.charAt(i)) {
					case '+':
						tempResult = Double.toString(temp1 + temp2);
						break;
					case '-':
						tempResult = Double.toString(temp1 - temp2);
						break;
					case'*':
						tempResult = Double.toString(temp1 * temp2);
						break;
					case'/':
						tempResult = Double.toString(temp1 / temp2);
						break;
					default:
						throw new InvalidNotationFormatException();
					}
				
				try {
					solutionStack.push(tempResult);
				}catch(StackOverflowException e) {
					throw new  InvalidNotationFormatException();
				}
			}
			
		}
		try {
			double awnser = Double.parseDouble(solutionStack.pop());
			if(solutionStack.isEmpty()) {
				return awnser;
			}
		}catch(StackUnderflowException e) {
			throw new InvalidNotationFormatException();
		}
		throw new InvalidNotationFormatException();
	}
		
	

}
