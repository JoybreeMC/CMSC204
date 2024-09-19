
public class ArraySum {
	
	public int sumOfArray(Integer[] myArray, int index) {
		
		if(index < 0) {
			return 0;
		}
		
		return myArray[index] + sumOfArray(myArray, index-1);
		
	}
}
