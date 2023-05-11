public class TreeNode {
        private int value;
        private TreeNode left, right;
        public TreeNode(int value) {
                this.value = value;
                left = null;
                right = null;
        }
        public int getValue() {
                return value;
        }
        public TreeNode getLeftNode() {
                return left;
        }
        public TreeNode getRightNode() {
                return right;
        }
        public void setLeftNode(TreeNode node) {
                this.left = node;
        }
        public void setRightNode(TreeNode node) {
                this.right = node;
        }
}
