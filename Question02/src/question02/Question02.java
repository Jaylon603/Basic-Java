package question02;

import java.util.*;

/*
 * Jaylon Norris
 * 10/11/2021
 * Program to Find the Maximum Depth or Height of a Treein Java.
 */

/**
 *
 * @author Jaylon
 */
public class Question02 {

   static class Node {

        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    Node root;

    /*
       Find out the height of the tree
     */
    int maxDepth(Node node) {
        if (node == null) {
            return 0;
        } else {
            /* compute the depth of each subtree */
            int lDepth = maxDepth(node.left);
            int rDepth = maxDepth(node.right);

            /* use the larger one */
            if (lDepth > rDepth) {
                return (lDepth + 1);
            } else {
                return (rDepth + 1);
            }
        }
    }

    /* Driver program to test above functions */
    public static void main(String[] args) {
        Question02 tree = new Question02();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        //    tree.root.left.left = new Node(4);
        //    tree.root.left.right = new Node(5);

        System.out.println("Height of tree is : "
                + tree.maxDepth(tree.root));
    }
}
