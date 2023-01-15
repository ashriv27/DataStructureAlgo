package prims;

import java.util.Arrays;

public class MergeSorted {

public static void merge(int[] nums1, int m, int[] nums2, int n) {
   
	
     for(int i =m,j=0;i<m+n && j<n;i++,j++) {
    	 
    	 nums1[i] = nums2[j];
    	 
     }
	
     Arrays.sort(nums1);
     
     for(int g:nums1) {
    	 
    	System.out.print(g+","); 
     }
    }

public static void main(String[] args) {
	
	
	
	int m = 0;
	int nums2[] = {1};
	int n = 1;
	int nums1[] = new int[m+n];
	
	merge(nums1,m,nums2,n);
			 
}
	
}
