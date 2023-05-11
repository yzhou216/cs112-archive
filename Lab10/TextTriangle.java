public class TextTriangle {
        public static void main(String[] args) {
                char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
                for(int v = 0; v <= 25; v+=2) {
                        for(int i = v; i <= 25; i++) {
                                System.out.print(alphabet[i]);
                        }
                        System.out.println();
                }
        }
}
