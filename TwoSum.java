package prims;

import java.util.HashMap;

public class TwoSum {

	
	 public static int[] twoSum(int[] nums, int target) {
	        
	     HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	     
	     int a=0,b=0;  
     	 for(int i=0;i<nums.length;i++) {
	     if(map.containsKey(nums[i])) {
	    	 a=i;
	    	 b=map.get(nums[i]);
	    	 
	     }else {
	    	 map.put(target - nums[i],i);
	     }
	     
	     
	     }
	return new int[] {b,a};
     	 
	    }
	
	public static void main(String[] args) {
		
		int[] nums = {2,7,11,15};
		int target =9;
		int[] arr = twoSum(nums, target);
        System.out.println(arr[0] + " "+arr[1]);
	}

}
