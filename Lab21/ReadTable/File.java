import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
public class File {
        private String[] test;
        public File(String fileName) throws IOException {
                this.test = readLines(fileName);
        }
        private static String[] readLines(String fileName) throws IOException {
                List<String> words = new ArrayList<String>();
                BufferedReader bf = new BufferedReader(new FileReader(fileName));
                String line = bf.readLine();
                while(line != null) {
                        words.add(line);
                        line = bf.readLine();
                }
                bf.close();
                String[] lines = words.toArray(new String[0]);
                return lines;
        }
        public String getLine(int lineNumber) {
                return test[lineNumber];
        }
        public int getTotalNumberOfLines() {
                return test.length;
        }
}
