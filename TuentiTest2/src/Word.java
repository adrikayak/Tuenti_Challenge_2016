
public class Word {
	Word next;
	String word;
	int freq = 1;
	
	Word(String word){
		this.word = word;
		next = null;
	}
}
