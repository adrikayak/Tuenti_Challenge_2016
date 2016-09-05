import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;


public class Tables {

	public static void main(String[] args) throws Exception {

		int diners; // Number of diners for the current case
		int tables; // Number of tables needed
		// Opens text file to read
		FileReader fr = new FileReader("input.txt");
		BufferedReader br = new BufferedReader(fr);

		// Opens text file to write		
		FileWriter fw = new FileWriter("output.txt", false);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);

		// Reads number of cases present in the text file
		byte T = Byte.parseByte(br.readLine());

		// Goes through all the cases present in the input text file
		for(int t = 1; t <= T; t++){
			// Obtains the number of dinners for the current case
			diners = Integer.parseInt(br.readLine());

			// If diners == 0
			if(diners == 0){
				tables = 0;
			}else{
				diners -= 5;
				// If 0 < diners < 5 
				if(diners < 0){
					tables = 1;
				}else{
					tables = (diners/2)+2;
				}
			}
			pw.println("Case #" + t + ": " + tables);

		}
		pw.close();
		br.close();
	}
}
