package prims;

public class MaximulSubArray {

public static int maxSubArray(int[] nums) {
        
	int count = 0;
	int maxsum = nums[0];
	
	for(int i=0;i<nums.length;i++) {
		
		if(count<0) {
			count = 0;
		}
		
		count+=nums[i];
		
		maxsum = Integer.max(maxsum, count);
	}
	
       return maxsum; 
        
    }
	
	
	public static void main(String[] args) {
		 int[] arr = {-1,-6,-1,-4,-8};
		 int c = maxSubArray(arr);
		 System.out.println(c);

	}

}
