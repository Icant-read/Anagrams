# Anagrams
Comp Sci III K Project
package setMaps;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Anagrams2ElectricBoogaloo {
	private static TreeSet<String> dict;
	private static TreeSet<String> answers;
	private static TreeSet<ArrayList<String>> answers2;
	private static String phrase;
	public Anagrams2ElectricBoogaloo(){
		//constructor
		dict=new TreeSet<String>();
		answers=new TreeSet<String>();
		answers2=new TreeSet<ArrayList<String>>();
		phrase="";
	}
	public int findAnagrams(String phrase, int max, TreeSet<String> dictionary) {
		//both
		phrase=phrase;
		dict=dictionary;
		if(phrase.length()>0){
			if(isDict(phrase)==true){
				answers.add(phrase);
			}
			recur(phrase, "");
		}
		
		//next step is to convert the 'answers' to String[] answers
		String[] ans=new String[answers.size()];
		int bob=0;
		for(String x:answers) {
			ans[bob]=x;
			bob++;
		}
		for(int y=0;y<ans.length;y++) {
			System.out.println(ans[y]);
		}
		//make a method that gets all combinations of strings within String[] answers
		mixArray(ans);
		//print out all combinations that have the same letters as phrase
		//AND that don't have more words in them than max
		System.out.println(answers2);
		
		return answers2.size();
	}
	
	public void mixArray(String[] array) {
		//this method must mix the array into every possible order and call recurArray for all of them
		
	}
	
	public void recurArray(ArrayList<String> building, String[] words, int max) {
		//Brianna
		String done="";
		for(int x=0;x<building.size();x++) {
			done+=building.get(x);
		}
		if(areSame(phrase,done)==true) {
			answers2.add(building);
		}
		if(done.length()<phrase.length() && building.size()<max && words.length>1) {
			building.add(words[0]);
			String[] w=new String[words.length-1];
			for(int y=1;y<words.length;y++) {
				w[y-1]=words[y];
			}
			recurArray(building, w, max);
		}
	}
	
	public boolean areSame(String a, String b) {
		//returns whether the strings have the same characters
		return false;
	}
	
	
	
	static void recur(String str, String ans) { 
	//recursive method, gets all anagrams - Brianna
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
		//checks if the anagram is in the dictionary - Brianna
		for(String x:dict) {
			if(x.equals(phrase)) {
				dict.remove(x);
				return true;
			}
		}
		return false;
	}

}
