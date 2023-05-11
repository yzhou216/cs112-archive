import java.util.Scanner;
public class EightLines {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                String lines[] = new String[8];
                for(int i = 0; i <= 7; i++) {
                        lines[i] = sc.nextLine();
                }
                int emptyLineCounter = 0;
                for(int i = 0; i <= 7; i++) {
                        if(!lines[i].equals(""))
                                System.out.println(lines[i]);
                        else
                                emptyLineCounter++;
                }
                if(emptyLineCounter > 0)
                        System.err.println("ERROR: fewer than 8 input lines");
        }
}
