package prims;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

	
    public static List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> l1= new ArrayList<List<Integer>>();
        List<Integer> l2= new ArrayList<Integer>();
        l2.add(1);
        l1.add(l2);
        
        if(numRows ==1)
        	return l1;
        
        for(int i=0;i<numRows-1;i++){

          List newLst =  new ArrayList<>();
          newLst.add(1);
          System.out.println("Here:" + l2.size());
          for(int j=0;j<l2.size()-1;j++){
        	 System.out.println("Here:" + l2.size());
            newLst.add(l2.get(j)+ l2.get(j+1));             
          }
         newLst.add(1);
         l1.add(newLst);
         l2=newLst;
        }
  

        return l1;
      }
	
	
	
	public static void main(String[] args) {
		int numRows = 2;
		
		List<List<Integer>> lst = generate(numRows);
		

			System.out.println(lst);
			
	

	}

}
