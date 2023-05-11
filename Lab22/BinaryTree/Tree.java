import java.util.Random;
public class Tree {
        private final Random random;
        private TreeNode root;
        public Tree() {
                root = null;
                random = new Random();
        }
        public void add(int value) {
                TreeNode node = new TreeNode(value);
                if(root == null) {
                        root = node;
                        return;
                }
                TreeNode current = root;
                while(current.getLeftNode() != null && current.getRightNode() != null) {
                        if(pickLeft())
                                current = current.getLeftNode();
                        else
                                current = current.getRightNode();
                }
                if(current.getLeftNode() == null)
                        current.setLeftNode(node);
                else
                        current.setRightNode(node);
        }
        public int TreeSum() {
                return TreeSum(root);
        }
        private int TreeSum(TreeNode node) {
                if(node == null)
                        return 0;
                return node.getValue() + TreeSum(node.getLeftNode()) + TreeSum(node.getRightNode());
        }
        public int TreeMin() {
                return TreeMin(root);
        }
        private int TreeMin(TreeNode node) {
                int min = 0;
                if(node == null)
                        return 0;
                else
                        min = node.getValue();
                return Math.min(min, Math.min(TreeMin(node.getLeftNode()), TreeMin(node.getRightNode())));
        }
        private boolean pickLeft() {
                return random.nextBoolean();
        }
}
