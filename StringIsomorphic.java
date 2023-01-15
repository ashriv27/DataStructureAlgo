package prims;

import java.util.HashMap;

public class StringIsomorphic {

	
	 public static boolean isIsomorphic(String s, String t) {
         
		 char[] c1 = s.toCharArray();
		 char[] c2 = t.toCharArray();
		 
		 if(s.isEmpty() ||t.isEmpty() ||c1.length != c2.length) {
		 
		 return false;
		 }
			
		 HashMap<Character, Character> hm = new HashMap<Character, Character>();
		 
			for(int i=0;i<c1.length;i++) {
				
				if(hm.containsKey(c1[i])) {
					
					if(hm.get(c1[i]) != (c2[i])) {
						return false;
					}
					
				}else {
					
					if(hm.containsValue(c2[i]))
						return false;
					
					hm.put(c1[i], c2[i]);
				}
				 
				 
			 }
			return true;
			 
		 

	    }
	
	
	
	
	public static void main(String[] args) {
		
		String str1 = "foo", str2 = "bar";  
		System.out.println("Are "+str1 +" and "+str2 +" Isomorphic? "+isIsomorphic(str1, str2));  
	}

}
