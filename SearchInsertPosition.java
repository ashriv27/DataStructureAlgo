package prims;

public class SearchInsertPosition {

	  public static int searchInsert(int[] nums, int target) {
	  
		  int t= 0;
		  for(int i=0;i<nums.length;i++) {
			  
			  if(nums[i] >= target) {
				  
				  t= i;
				  break;
			  }else if(i==nums.length-1) {
				  
				  t=nums.length;
			  }
			 
		  }
		  
		  return t;
	    }
	  
	
public static void main(String[] args) {
	
	int[] nums = {1,3,3,3};
	int target =5;
	 int arr = searchInsert(nums,target);
	 
	 System.out.println(arr);
	 

	 System.out.println(arr);
	 
	
}
	  
}
