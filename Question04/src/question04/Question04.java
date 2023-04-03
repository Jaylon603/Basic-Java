/*
 * Jaylon Norris
 * 10/11/2021
 * Balanced Search Tree
 */
package question04;

import java.util.*;

/**
 *
 * @author Jaylon
 */
class Node {

    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class BinaryTree {

    Node root;

    /* This function traverse the skewed binary tree and
       stores its nodes pointers in vector nodes[] */
    void storeBSTNodes(Node root, Vector<Node> nodes) {
        // Base case
        if (root == null) {
            return;
        }

        // Store nodes in Inorder (which is sorted
        // order for BST)
        storeBSTNodes(root.left, nodes);
        nodes.add(root);
        storeBSTNodes(root.right, nodes);
    }

    /* Recursive function to construct binary tree */
    Node buildTreeUtil(Vector<Node> nodes, int start,
            int end) {
        // base case
        if (start > end) {
            return null;
        }

        /* Get the middle element and make it root */
        int mid = (start + end) / 2;
        Node node = nodes.get(mid);

        /* Using index in Inorder traversal, construct
           left and right subtress */
        node.left = buildTreeUtil(nodes, start, mid - 1);
        node.right = buildTreeUtil(nodes, mid + 1, end);

        return node;
    }

    // This functions converts an unbalanced BST to
    // a balanced BST
    Node buildTree(Node root) {
        // Store nodes of given BST in sorted order
        Vector<Node> nodes = new Vector<Node>();
        storeBSTNodes(root, nodes);

        // Constructs BST from nodes[]
        int n = nodes.size();
        return buildTreeUtil(nodes, 0, n - 1);
    }

    //Calculate inOrder
    void inOrder(Node node) {
        //Inorder (Left, Root, Right)
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        
        inOrder(node.right);
    }
}
    public class Question04 {

        /**
         * @param args the command line arguments
         */
        public static void main(String[] args) {
            // 17,12,22,10,14,20,27
           
            BinaryTree tree = new BinaryTree();
            tree.root = new Node(17);
            tree.root.left = new Node(12);
            tree.root.left.left = new Node(22);
            tree.root.left.left.left = new Node(10);
            tree.root.left.left.left.left = new Node(14);
            tree.root.left.left.left.left.left = new Node(20);
            tree.root.left.left.left.left.left.left = new Node(27);

            tree.root = tree.buildTree(tree.root);
            System.out.print("inOrder traversal of balanced BST is :");
            tree.inOrder(tree.root);
        }

    }
