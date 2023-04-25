import org.w3c.dom.Node;

import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Sohan Gaitonde
 * @version: 4/21/23
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        // TODO: Complete the search function
        // if the number is found return true else return false
        if(isfound(this.getRoot(), val)) {
            return true;
        }
        return false;
    }

    public boolean isfound(BSTNode n, int val) {
        // if the value is in this node return true
        if(n.getVal() == val) {
            return true;
        }
        // else if the value of this node is larger than what you are looking for go left
        if(n.getVal() > val) {
            // if there is something in the left node, recursivley call this method with that node
            if(n.getLeft() != null) {
                return isfound(n.getLeft(), val);
            }
            // if there is nothing in that node the number cant be in the tree so return false
            return false;
        }
        // very similar to previous if statement except if it looks at if the node is less than the value
        else if(n.getVal() < val){
            if(n.getRight() != null) {
                return isfound(n.getRight(), val);
            }
            return false;
        }
        return false;
    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        // TODO: Complete inorder traversal
        // calls a helper recursive method and returns the result
        ArrayList<BSTNode> arr = new ArrayList<>();
        return sortInorder(arr, this.getRoot());
    }

    public ArrayList<BSTNode> sortInorder(ArrayList<BSTNode> arr, BSTNode n) {
        // if the node is real, recursivley run the code on the left then add the node to the arraylist and then run it on the right
        if (n != null) {
            sortInorder(arr, n.getLeft());
            arr.add(n);
            sortInorder(arr, n.getRight());
        }
        return arr;
    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        // TODO: Complete preorder traversal
        // calls a helper recursive method and returns the result
        ArrayList<BSTNode> arr = new ArrayList<>();
        return sortPreorder(arr, this.getRoot());
    }

    private ArrayList<BSTNode> sortPreorder(ArrayList<BSTNode> arr, BSTNode node) {
        // if the node is real, add the node to the arraylist, then run it on the left and then run it on the right
        if (node != null) {
            arr.add(node);
            sortPreorder(arr, node.getLeft());
            sortPreorder(arr, node.getRight());
        }
        return arr;
    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        // calls a helper recursive method and returns the result
        ArrayList<BSTNode> arr = new ArrayList<>();
        return sortPostorder(arr, this.getRoot());
    }

    private ArrayList<BSTNode> sortPostorder(ArrayList<BSTNode> arr, BSTNode node) {
        // if the node is real, run it on the left, then run it on the right and then add the node to the arraylist
        if (node != null) {
            sortPostorder(arr, node.getLeft());
            sortPostorder(arr, node.getRight());
            arr.add(node);
        }
        return arr;
    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        // TODO: Complete insert
        // calls a recursive method that inserts the value given
        insertHelper(this.getRoot(), val);
    }
    private BSTNode insertHelper(BSTNode n, int value) {
        // if there is node here create a new node here with the value
        if (n == null) {
            return new BSTNode(value);
        }
        // if the value is less than this node go left and run the method again
        else if (value < n.getVal()) {
            n.setLeft(insertHelper(n.getLeft(), value));
        }
        // if the value is less than this node go right and run the method again
        else if (value > n.getVal()) {
            n.setRight(insertHelper(n.getRight(), value));
        }
        return n;
    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
