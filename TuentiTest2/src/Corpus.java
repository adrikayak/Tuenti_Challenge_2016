import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Corpus {

	public static void main(String[] args) throws IOException {
		String word;

		// Opens input.txt file to read from it
		FileReader fr_input = new FileReader("testInput2.txt");
		BufferedReader br_input = new BufferedReader(fr_input);

		// Opens corpus.txt file to read from it
		FileReader fr_corpus = new FileReader("corpus.txt");
		BufferedReader br_corpus = new BufferedReader(fr_corpus);
		
		// Creates output.txt to write the output in it
		FileWriter fw = new FileWriter("output.txt", false);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);
		
		//  Gets the corpus
		String corpus = br_corpus.readLine();
		
		// Gets the number of cases
		int N = Integer.parseInt(br_input.readLine());
		
		// Creates an array of StringTokenizers, one per case. They get words from corpus.txt as tokens, separated by a space
		StringTokenizer[] st_corpus = new StringTokenizer[N];

		int numberOfWords = new StringTokenizer(corpus," ", false).countTokens();		

		for(int i = 0; i < N; i++){			
			// Gets numbers from input.txt as tokens, separated by a space
			StringTokenizer st_input = new StringTokenizer(br_input.readLine()," ", false);
			int firstWord = Integer.valueOf(st_input.nextToken());
			int secondWord = Integer.valueOf(st_input.nextToken());
			
			// Gets numbers from corpus.txt as tokens, separated by a space
			st_corpus[i] = new StringTokenizer(corpus," ", false);
			
			while(st_corpus[i].countTokens() > numberOfWords-firstWord+1){
				st_corpus[i].nextToken();				
			}
			
			// Instantiates a Linked List containing the table of words frequency
			LinkedList linkedlist = new LinkedList(new Word(st_corpus[i].nextToken()));
			
			while(st_corpus[i].countTokens() > numberOfWords-secondWord){
				word = st_corpus[i].nextToken();
				do{
					if(linkedlist.active.word.equals(word)){
						linkedlist.active.freq++;
						//System.out.println(linkedlist.active.word);
						linkedlist.sortFreqs();
						break;
					}else
						if(linkedlist.active.next != null){}
						else{
							linkedlist.addWord(word);
						}
				}while(linkedlist.moveNext());
				linkedlist.moveFirst();
			}	
			pw.println("Case #" + (i+1) + ": " + linkedlist.freqs[0].word + " " + linkedlist.freqs[0].freq + "," 
					+ linkedlist.freqs[1].word + " " + linkedlist.freqs[1].freq + "," 
					+ linkedlist.freqs[2].word + " " + linkedlist.freqs[2].freq);
			
			System.out.println("Case #" + (i+1) + ": " + linkedlist.freqs[0].word + " " + linkedlist.freqs[0].freq + "," 
					+ linkedlist.freqs[1].word + " " + linkedlist.freqs[1].freq + "," 
					+ linkedlist.freqs[2].word + " " + linkedlist.freqs[2].freq);
		}

		br_corpus.close();
		br_input.close();
		pw.close();
	}
}
