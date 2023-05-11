import java.util.Scanner;
public class CountChars {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                String str = "";
                while(sc.hasNext()) {
                        str = sc.nextLine();
                }
                sc.close();
                System.out.println();
                for(int unicodeIndex = 0; unicodeIndex <= 255; unicodeIndex++) {
                        int occurrence = 0;
                        for(int i = 0; i <= str.length()-1; i++) {
                                if((int) str.charAt(i) == unicodeIndex)
                                        occurrence++;
                        }
                        if(occurrence != 0)
                                System.out.println(String.valueOf((char) unicodeIndex) + " " + occurrence);
                }
        }
}
