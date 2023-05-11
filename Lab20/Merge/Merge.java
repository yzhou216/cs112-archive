import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.BufferedReader;    
import java.io.FileReader;    
import java.io.IOException;
public class Merge {
        static ArrayList<Integer> mergeTwo(List<Integer> A, List<Integer> B) {
                int m = A.size();
                int n = B.size();
                ArrayList<Integer> D = new ArrayList<Integer>(m + n);
                int i = 0, j = 0;
                while (i < m && j < n) {
                        if (A.get(i) <= B.get(j))
                                D.add(A.get(i++));
                        else
                                D.add(B.get(j++));
                }
                while (i < m)
                        D.add(A.get(i++));
                while (j < n)
                        D.add(B.get(j++));
                return D;
        }
        public static void main(String[] args) throws IOException {
                BufferedReader bf0 = new BufferedReader(new FileReader(args[0]));
                String text0 = bf0 .readLine();
                String[] tockens0 = text0.split(" ");
                BufferedReader bf1 = new BufferedReader(new FileReader(args[1]));
                String text1 = bf1 .readLine();
                String[] tockens1 = text1.split(" ");
                BufferedReader bf2 = new BufferedReader(new FileReader(args[2]));
                String text2 = bf2 .readLine();
                String[] tockens2 = text2.split(" ");
                Integer[] a = Arrays.stream(Arrays.stream(tockens0).mapToInt(Integer::parseInt).toArray()).boxed().toArray(Integer[]::new);
                Integer[] b = Arrays.stream(Arrays.stream(tockens1).mapToInt(Integer::parseInt).toArray()).boxed().toArray(Integer[]::new);
                Integer[] c = Arrays.stream(Arrays.stream(tockens2).mapToInt(Integer::parseInt).toArray()).boxed().toArray(Integer[]::new);
                List<Integer> A = Arrays.asList(a);
                List<Integer> B = Arrays.asList(b);
                List<Integer> C = Arrays.asList(c);
                ArrayList<Integer> T = mergeTwo(A, B);
                ArrayList<Integer> ans = mergeTwo(T, C);
                for (int i = 0; i < ans.size(); i++)
                        System.out.print(ans.get(i) + " ");
                System.out.println();
        }
}
