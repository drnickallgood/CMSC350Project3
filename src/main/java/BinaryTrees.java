/**
 * Created by nallgood on 2/16/17.
 */
import java.util.*;
import java.io.*;

class BinaryTrees<T extends Comparable<T>> {

    // This will be the starting/root node
    public TreeNode<T> rootNode;

    // Constructor initilizes the tree
    public BinaryTrees(T value) {

        rootNode = new TreeNode<T>(value, null, null);

    }

    public void add(T value) {

        TreeNode<T> node = new TreeNode<T>(value,null,null);
        addNode(rootNode, node);
    }

    // Hidden method to be used internally to add a node to the tree
    private TreeNode<T> addNode(TreeNode<T> lastNode, TreeNode<T> newNode) {

        // We don't have any nodes so let's add one
        if(lastNode == null) {

            lastNode = newNode;

        }
        // If our last value is less than the current nodes value
        // Then stick it on the left side of the tree
        else if((lastNode.value).compareTo(newNode.value) < 0) {

            lastNode.rightNode = addNode(lastNode.rightNode, newNode);
        }
        // The new node value is either the same or greater
        // Requirements specify to allow duplicate entries so we don't have
        // to do much more work
        else {

            lastNode.leftNode = addNode(lastNode.leftNode, newNode);
        }

        return lastNode;

    }
    // -- Printing trees  -- //

    public void printInOrder(TreeNode<T> root) {

        if(root == null) {

            return;
        }
        // Print left tree

        printInOrder(root.leftNode);
        // Actual Data to be printed
        System.out.println(root.value);
        printInOrder(root.rightNode);


    }

    public void printRevOrder(TreeNode<T> root) {

        if(root == null) {

            return;
        }

        printRevOrder(root.rightNode);
        System.out.println(root.value);
        printRevOrder(root.leftNode);
    }

    public TreeNode<T> getNode() {

        return rootNode;
    }


    // Need to create the tree from user Input
    public void buildTreeWithInput(String input) {

        // loop through input and call add to get tree
        // List of strings, split on whitespace
        List<String> parsed = Arrays.asList(input.split("\\s+"));

        // List iterator
        ListIterator<String> parsedIter = parsed.listIterator();

        // Sanity placeholder
        String current;

        // Iterate through the string
        while (parsedIter.hasNext()) {

            // Get element
            current = parsedIter.next();

            // Create new node with the value from the list

        }

    }


    public static void main(String[] args) {

        // Populate the tree
        BinaryTrees<Integer> tree = new BinaryTrees<Integer>(100);
        tree.add(50);
        tree.add(40);
        tree.add(30);
        tree.add(20);
        tree.add(500);
        tree.add(10);
        tree.add(750);

        // Get the root node
        TreeNode rootNode = tree.getNode();

        tree.printInOrder(rootNode);


    }



}
