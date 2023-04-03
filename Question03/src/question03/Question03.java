/*
 * Jaylon Norris
 * 10/15/2021
 * AVL tree prints post order traversal
 */
package question03;

/**
 *
 * @author JENORRIS
 */
public class Question03 {

    
    public static void main(String[] args) {
        // Create and test AVL tree
        Tree tree = new Tree();
        tree.insert(7);
        tree.insert(18);
        tree.insert(3);
        tree.insert(22);
        tree.insert(4);
        tree.insert(24);
        tree.insert(29);
        tree.insert(10);
        tree.insert(2);
        tree.insert(89);
        System.out.println("Height of tree is: " + tree.getHeight(tree.root));
        System.out.print("Post order traversal is: ");
        printPost(tree.root);
        

    }

    static class Tree {

        Node root;
        //No argument
        Tree() {
            this.root = null;
        }

        Tree(Node root) {
            this.root = root;
        }
        //Add nodes to tree depending on size of value and height
        void insert(int x) {
            Node num = new Node(x);
            if (this.root == null) {
                this.root = num;
            } else if (this.root.value > num.value) {
                Tree leftSubTree = new Tree(this.root.left);
                leftSubTree.insert(x);
                this.root.left = leftSubTree.root;
            } else if (this.root.value < num.value) {
                Tree rightSubTree = new Tree(this.root.right);
                rightSubTree.insert(x);
                this.root.right = rightSubTree.root;
            }
        }
         //find the height of the tree
    int getHeight(Node node)
    {
        if (node == null){
            return 0;
        }else
        {
            //Find the height of both subtrees           
            int leftHeight = getHeight(node.left);
            int rightHeight = getHeight(node.right);
  
            //Add to greater counter
            if (leftHeight > rightHeight)
                return (leftHeight + 1);
             else
                return (rightHeight + 1);
        }
    }
    }

    static class Node {

        int value;
        Node left;
        Node right;

        //Assign to new node data
        Node(int data) {
            //Children are null
            value = data;
            left = null;
            right = null;
        }
    }

    static void printPost(Node root) {
        if (root.left != null) {
            printPost(root.left);
            
        }
        if (root.right != null){
            printPost(root.right);
            
        }
        System.out.print(" " + root.value);

    }

    /**
     * @param args the command line arguments
     */
}
