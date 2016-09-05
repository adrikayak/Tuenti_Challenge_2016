
public class LinkedList {
	Word first;
	Word active;
	Word last;

	Word[] freqs = new Word[3];

	LinkedList(Word first){
		this.first = first;
		active = first;
		last = first;
		freqs[0] = first;
		Word initializingTop3 = new Word("");
		freqs[1] = initializingTop3;
		freqs[2] = initializingTop3;
	}

	boolean moveNext(){
		if(active.next != null){
			active = active.next;
			return true;
		}else{
			return false;
		}
	}

	void moveFirst(){
		active = first;
	}

	void moveLast(){
		active = last;
	}

	void addWord(String word){
		moveLast();
		Word newWord = new Word(word);
		active.next = newWord;
		last = newWord;
		active = newWord;
	}

	void sortFreqs(){
		//System.out.println(active.word);
		//System.out.println(active.word + active.freq + " and " + freqs[0].word + freqs[0].freq);
		if(active.word.equals(freqs[0].word)){}
		else{
			if(active.freq > freqs[0].freq){
				freqs[1] = freqs[0];
				freqs[0] = active;
			}
			else{
				if(active.word.equals(freqs[1].word)){}
				else{
					if(active.freq > freqs[1].freq){
						freqs[2] = freqs[1];
						freqs[1] = active;
					}
					else{
						if(active.word.equals(freqs[2].word)){}
						else{
							freqs[2] = active;
						}
					}
				}
			}
		}
		//System.out.println(freqs[0].word);
		//System.out.println(freqs[1].word);
		//System.out.println(freqs[2].word);
		//System.out.println();
	}
	
/*	void sortFreqs(){
		boolean flag = false;
		System.out.println(active.word);
		System.out.println(active.word + active.freq + " and " + freqs[0].word + freqs[0].freq);
		if(active.freq > freqs[0].freq){
			freqs[2] = freqs[1];
			freqs[1] = freqs[0];
			freqs[0] = active;
			flag = true;
		}else{
			if(active.freq > freqs[1].freq && !flag){
				freqs[2] = freqs[1];
				freqs[1] = active;
				flag = true;
			}else{
				if(active.freq > freqs[2].freq && !flag){
					freqs[2] = active;
				}else{}
			}
		}
		System.out.println(freqs[0].word);
		System.out.println(freqs[1].word);
		System.out.println(freqs[2].word);
		System.out.println();
	}*/
}
