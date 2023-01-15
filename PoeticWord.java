package prims;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class PoeticWord {
 
	public static void mostPoeticWord(String s) {
		
		char[] vowels = {'A','E','I','O','U','a','e','i','o','u'};
		
		String[] words = s.split(" ");
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		for(String word:words) {
			int count=0;
			for(int i=0;i<word.length();i++) {
				
				
				if(Arrays.binarySearch(vowels, word.charAt(i))>0) {
					count++;
										
				}
				if(word.charAt(i) == 'K' || word.charAt(i) == 'k') {
					
					count--;
					
				}
if(word.charAt(i) == 'X' || word.charAt(i) == 'x') {
					
					count = count-2;
					
				}
				
				
			}
			
			map.put(word, count);
			
		}
		
		
		
		Map<String, Integer> sortByValueMap = map.entrySet().stream().sorted(Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue(),
						(entry1, entry2) -> entry2, LinkedHashMap::new));
		
		System.out.println("HashMap after sorting by value - " + sortByValueMap);
		
		
	}
	
	
	
	public static void main(String[] args) {
		
		mostPoeticWord("taregtxkaaaI fleece");
	}
	
}
