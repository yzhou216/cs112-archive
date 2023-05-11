import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class SortTest {
        private static boolean isSorted(int arr[], int length) {
                if (length == 1 || length == 0)
                        return true;
                return arr[length - 1] >= arr[length - 2] && isSorted(arr, length - 1);
        }
        public static void main(String[] args) throws IOException {
                BufferedReader bf = new BufferedReader(new FileReader("sort.txt"));
                String text = bf .readLine();
                String[] tockens = text.split(" ");
                int[] values = new int[tockens.length];
                for(int i = 0; i <= values.length-1; i++)
                        values[i] = Integer.parseInt(tockens[i]);
                if(values.length == 10000 && isSorted(values, values.length)) {
                        System.out.println("PASS");
                } else {
                        if(!(values.length == 10000)) {
                                System.err.println("FAIL: incorrect element count");
                        }
                        if(!isSorted(values, values.length)) {
                                System.err.println("FAIL: incorrect sort");
                        }
                }
        }
}
