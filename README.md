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
	int findAnagrams(String phrase, int max, TreeSet<String> dictionary) {
		//recursive method
		dict=dictionary;
		if(phrase.length()>0){
			if(isDict(phrase)==true){
				answers.add(phrase);
			}
			String[] let=allLetters(phrase);
			//shuffle all letters, return isDict for every possible string
			for(int x=0;x<let.length;x++) {
				
			}
			return findAnagrams( phrase.substring(1), max, dictionary);
		}
		return 0;
	}
	
	public String[] allLetters(String phrase){
		String[] letters=new String[phrase.length()];
		for(int x=0;x<phrase.length();x++) {
			letters[x]=phrase.substring(x,x+1);
		}
		return letters;
	}
	
	public boolean isDict(String phrase) {
		for(String x:dict) {
			if(x.equals(phrase)) {
				dict.remove(x);
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		String done="";
		for(String xyz:answers) {
			done+=xyz;
		}
		return done;
	}
}
