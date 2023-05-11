import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class Word {
        private String word;
        int index;
        public Word() throws IOException {
                do {
                        /* random generate the index reference within the range
                         * of the index of the array */
                        index = (int) (Math.random() * readWords().length);
                } while(readWords()[index].length() != 5);
                word = readWords()[index];
        }
        public String getWord() {
                return word;
        }
        private static String[] readWords() throws IOException {
                List<String> words = new ArrayList<String>();
                /* read words from file with BufferedReader */
                BufferedReader bf = new BufferedReader(new FileReader("words.txt"));
                String line = bf.readLine();
                while(line != null) {
                        words.add(line);
                        line = bf.readLine();
                }
                bf.close();
                String[] wordsArray = words.toArray(new String[0]);
                return wordsArray;
        }
}
