import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
public class CSVTester {
        public static void main(String[] args) throws IOException, EmptyLineException, EntryOutOfBoundsException {
                Scanner sc = new Scanner(System.in);
                ArrayList<String> lines = new ArrayList<String>();
                while(sc.hasNext()) {
                        lines.add(sc.nextLine());
                }
                sc.close();
                CSVWriter fileWriter = new CSVWriter("CSVTester.csv");
                String[] stringsForALine;
                for(int i = 0; i <= lines.size()-1; i++) {
                        if(lines.get(i).equals(""))
                                throw new EmptyLineException("Line input cannot be empty");
                        stringsForALine = lines.get(i).split(" ");
                        if(i == 0)
                                fileWriter.setInitialLineLength(stringsForALine.length);
                        fileWriter.writeln(stringsForALine);
                }
                fileWriter.flush();
        }
}
