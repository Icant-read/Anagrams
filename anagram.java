# Anagrams
Comp Sci III K Project

package setMaps;

import java.util.Set;
import java.util.TreeSet;

public class Anagrams {
	private static TreeSet<String> dict;
	private static TreeSet<String> answers;
	public Anagrams(){
		//constructor
		dict=new TreeSet<String>();
		answers=new TreeSet<String>();
	}
	public int findAnagrams(String phrase, int max, TreeSet<String> dictionary) {
		dict=dictionary;
		if(phrase.length()>0){
			if(isDict(phrase)==true){
				answers.add(phrase);
			}
			recur(phrase, "");
		}
		if(max==0) {
			String done="";
			for(String xyz:answers) {
				done+=xyz;
				done+= " ";
			}
			System.out.println(done);
			return 0;
		}
		return 0;
	}
	
	static void recur(String str, String ans) { 
	//recursive method, gets all anagrams
        	if (str.length() == 0) { 
            		if(isDict(ans)==true) {
            			answers.add(ans);
            		}
        	} 
  
        for (int i = 0; i < str.length(); i++) { 
            char ch = str.charAt(i); 
            String ros = str.substring(0, i) +  
                         str.substring(i + 1); 
            recur(ros, ans + ch); 
            recur(ros, ans);
        } 
    }

	public static boolean isDict(String phrase) {
		//checks if the anagram is in the dictionary
		for(String x:dict) {
			if(x.equals(phrase)) {
				dict.remove(x);
				return true;
			}
		}
		return false;
	}

}
