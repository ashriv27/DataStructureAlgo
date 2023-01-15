package prims;

public class PlusOne {

	public static int[] plusOne(int[] digits) {

//// My SOution		
//		 int n = digits.length;
//		 int carry =0;
//		    
//		    if(digits[n-1] < 9) {
//		    	digits[n-1]++;
//		    	return digits;		    	
//		    }else {
//		    	digits[n-1] =0;
//		    	carry = 1;
//		    	for(int i=n-2; i>=0; i--) {
//		    		
//		    		digits[i] = digits[i] + carry;
//		    		if(digits[i]<=9) {
//		    			carry=0;
//		    		}else {
//		    			digits[i]=0;
//		    		}
//		    		
//		    	}
//		    }
//		    
//		    if(carry ==1) {
//		    	int[] newNumber = new int [n+1];
//			    newNumber[0] = 1;
//			    
//			    return newNumber;
//		    }else {
//		    	return digits;
//		    }

		
		
		
	//Better Solution
		
		for (int i = digits.length - 1; i >= 0; i--) {
	        
	        
	        if (digits[i] != 9) {
	            digits[i]++;
	            break;
	            
	        } else {
	            digits[i] = 0;
	        }
	    }
	    if (digits[0] == 0) {    
	        int[] res = new int[digits.length + 1];    
	        res[0] = 1;                              
	        return res;
	    }
	    return digits;   
		
		
		
		
		
		
    }
	
	
	
	public static void main(String[] args) {
		
		int[] p = {8,9,9,9};
		int[] s = plusOne(p);
		
		for(int t: s) {
			
			System.out.print(t);
		}

	}

}
