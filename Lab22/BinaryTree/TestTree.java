import java.util.Random;
public class TestTree {
        public static void main(String[] args) {
                Random random = new Random();
                Tree tree = new Tree();
                for(int i = 0; i <= 999; i++) {
                        tree.add(random.nextInt(4000) - 2500);
                }
                System.out.println(tree.TreeSum());
                System.out.println(tree.TreeMin());
        }
}
