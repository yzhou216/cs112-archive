import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class ReadTable {
        public static void main(String[] args) throws IOException {
                File file = null;
                try {
                        file = new File(args[0]);
                } catch(FileNotFoundException exception) {
                        System.err.println("ERROR, FILE NOT FOUND");
                        System.exit(0);
                }
                if(isCorrectFormat(file)) {
                        System.out.println("Total Number of Lines: " + file.getTotalNumberOfLines());
                } else {
                        System.err.println("ERROR, INVALID FORMAT");
                        System.exit(0);
                }
                HashMap<Integer, String> table = new HashMap<Integer, String>();
                Pattern pattern = Pattern.compile("(\\d+):(\\w+),");
                Matcher matcher;
                for(int i = 0; i <= file.getTotalNumberOfLines()-1; i++) {
                        matcher = pattern.matcher(file.getLine(i));
                        while(matcher.find())
                                table.put(Integer.parseInt(matcher.group(1)), matcher.group(2));
                }
                for(int i = 1; i <= args.length-1; i++) {
                        try {
                                if(table.get(Integer.parseInt(args[i])) == null)
                                        System.err.println("ERROR, VALUE NOT FOUND");
                                else
                                        System.out.println(table.get(Integer.parseInt(args[i])));
                        } catch(NumberFormatException exception) {
                                System.err.println("ERROR, INVALID KEY");
                        }
                }
        }
        private static boolean isCorrectFormat(File file) {
                Pattern pattern = Pattern.compile("\\d+:\\w+,");
                Matcher matcher;
                for(int i = 0; i <= file.getTotalNumberOfLines()-1; i++) {
                        matcher = pattern.matcher(file.getLine(i));
                        if(!matcher.matches())
                                return false;
                }
                return true;
        }
}
