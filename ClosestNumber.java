import java.util.Arrays;

public class ClosestNumber {

	public static void main(String[] args) {
		 int[] testArray = {3, 9, 50, 15, 99, 7, 98, 65};
	        int result = distClosestNumbers(testArray);
	        System.out.println(result); // Expected result is 1 (the 2 closest numbers are 98 and 99)
		
	}
	
	
	  public static int distClosestNumbers(int numbers[]) {
	       Arrays.sort(numbers);
	       int numberSize = numbers.length;
	       int minNr = numbers[numberSize-1];
	       
	       System.out.println(minNr);
	       
	       for(int i=0; i<numberSize-1; i++) {
	    	   System.out.println("Min Number is "+minNr);
	    	   System.out.println("Diff is "+(numbers[i+1]-numbers[i]));
	    	   minNr = Math.min(minNr, numbers[i+1]-numbers[i]);
	       }
	       return minNr;
	    }
}

