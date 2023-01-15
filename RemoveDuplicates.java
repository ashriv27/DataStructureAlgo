package prims;

public class RemoveDuplicates {

public static int[] removeDuplicates(int[] nums) {
        
	int t = 1;
	
        for(int i=1;i<nums.length;i++) {
        	
        	if(nums[i] != nums[i-1]) {
        		t++;
        		nums[t-1] = nums[i];
        	}
        	
        }
        
        return nums;
    }
	
	 public static void main(String[] args) {
	
		 int[] nums = {0,0,1,1,1,2,2,3,3,4};
		 int[] arr = removeDuplicates(nums);
		 for(int i: arr) {
			 
			 System.out.println(arr[i]);
		 }
		 

		 System.out.println(arr);
		 
	 }
	

}
