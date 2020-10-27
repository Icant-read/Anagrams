# Anagrams
Comp Sci III K Project
package setMaps;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;
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
	public int findAnagrams(String p, int max, TreeSet<String> dictionary) {
		//both
		for(int bilbo=0;bilbo<p.length();bilbo++) {
			if(!(p.substring(bilbo,bilbo+1).equals(" "))) {
				phrase+=p.substring(bilbo,bilbo+1);
			}
		}
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
			System.out.print(ans[y] + " ");
		}
		System.out.println();

		mixArray(ans);
		return answers2.size();
	}
	
	public void mixArray(String[] array) {
		//Kalen
		
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
		//Brianna
		
		if(a.length()!=b.length()) {
			return false;
		}
		
		TreeMap<String, Integer> amap;
		amap=new TreeMap<String, Integer>();
		for(int x=0;x<a.length();x++) {
			if(amap.get(a.substring(x,x+1))==null) {
				amap.put(a.substring(x,x+1),1);
			}
			else {
				amap.put(a.substring(x,x+1),amap.get(a.substring(x,x+1))+1);
			}
		}
		
		
		TreeMap<String, Integer> bmap;
		bmap=new TreeMap<String, Integer>();
		for(int y=0;y<b.length();y++) {
			if(bmap.get(b.substring(y,y+1))==null) {
				bmap.put(b.substring(y,y+1),1);
			}
			else {
				bmap.put(b.substring(y,y+1),bmap.get(b.substring(y,y+1))+1);
			}
		}
		for(int z=0;z<a.length();z++) {
			String str=a.substring(z,z+1);
			if(bmap.get(str)!=null) {
				if(bmap.get(str)!=amap.get(str)) {
					return false;
				}
			}
			else {
				return false;
			}
		}
		
		for(int z=0;z<b.length();z++) {
			String str=b.substring(z,z+1);
			if(amap.get(str)!=null) {
				if(bmap.get(str)!=amap.get(str)) {
					return false;
				}
			}
			else {
				return false;
			}
		}
		
		return true;
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
