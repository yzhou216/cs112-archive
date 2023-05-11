import java.util.Comparator;
public class Node implements Comparator<Node> {
        private char input;
        private int count;
        private String compressedSymbol;
        private Node left;
        private Node right;
        /* toString to print the binary tree with its children */
        public String toString() {
                return "Node -> [char: " + input + ", frequency: " + count + ", symbol: " + compressedSymbol + "]";
        }
        public int compare(Node node0, Node node1) {
                return node0.count - node1.count;
        }
        public char getInput() {
                return input;
        }
        public void setInput(char input) {
                this.input = input;
        }
        public int getCount() {
                return count;
        }
        public void setCount(int count) {
                this.count = count;
        }
        public String getCompressedSymbol() {
                return compressedSymbol;
        }
        public void setCompressedSymbol(String compressedSymbol) {
                this.compressedSymbol = compressedSymbol;
        }
        public Node getLeft() {
                return left;
        }
        public void setLeft(Node left) {
                this.left = left;
        }
        public Node getRight() {
                return right;
        }
        public void setRight(Node right) {
                this.right = right;
        }
}
