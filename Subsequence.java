package prims;

public class Subsequence {

	  public static boolean isSubsequence(String s, String t) {
	        
		  int a=0;
		  int b=0;
		  
		  while(a<s.length() && b<t.length()) {
			  
			  if(s.charAt(a)==t.charAt(b)) {
				  
				  a++;
				  b++;
			  }else {
				  b++;
			  }
			  
		  }
		  
	     return a==s.length()?true:false;
	    }
	
	
public static void main(String[] args) {

	String s = "abc", t = "ahbgdc";
	
	System.out.println(isSubsequence(s, t));
	
}	
	
}
