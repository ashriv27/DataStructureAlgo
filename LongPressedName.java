package prims;

public class LongPressedName {
	 
	public static boolean isLongPressedName(String name, String typed) {
	         
	         int i=0;
	         int j=0;
	   
	        	 
	     if(typed.length() <name.length())
	    	 return false;
	        	 
	        while(j<typed.length()){
	          
	          if(i < name.length() && typed.charAt(j) == name.charAt(i)){
	              i++;
	              j++;
	              continue;
	          }else if(i>0 && typed.charAt(j) == name.charAt(i-1)){
	             j++;               
	          }else{
	              break;
	          }           


	        }
	         
	          return i==name.length() && j == typed.length();

	    }
	
	
	
	public static void main(String[] args) {
		
		String name = "alex";
		String typed = "aaleexeex";
		
		System.out.println(isLongPressedName(name, typed));

	}

}
