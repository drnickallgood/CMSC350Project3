/**
 * Created by nallgood on 2/16/17.
 */
import javax.swing.*;
import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

class BinaryTrees<T extends Comparable<T>> {

    // This will be the starting/root node
    public TreeNode<T> rootNode;

    StringBuilder revString = new StringBuilder();
    StringBuilder inOrderString = new StringBuilder();
    private T value;

    // Constructor initilizes the tree
    public BinaryTrees(T value) {

        // This is the root node and gets add
        //rootNode = new TreeNode<T>(null, null, value);
        //rootNode = new TreeNode(value);
        this.value = value;

        //Initialize the root node
        rootNode = new TreeNode<T>(value);

    }

    // This sets up the root node and adds a node too it
    public void add(T value) {


        TreeNode<T> node = new TreeNode<T>(value);
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

    public String printInOrder(TreeNode root) {

        if(root == null) {

            return null;
        }
        // Print left tree

        printInOrder(root.leftNode);
        // Actual Data to be printed
        //System.out.println(root.value);
        inOrderString.append(root.value+" ");
        printInOrder(root.rightNode);

        return inOrderString.toString();

    }

    public String printRevOrder(TreeNode root) {

        if(root == null) {

            return null;
        }

        printRevOrder(root.rightNode);
        //System.out.println(root.value);

        //Instead of printing to cli we build up a string
        revString.append(root.value+" ");
        printRevOrder(root.leftNode);

        // Convert from string builder object back to string
        return revString.toString();
    }

    public TreeNode getNode() {

        return rootNode;
    }



    public static void main(String[] args) {

       // String numInput = "12 -1 4 300 1000";

        String numInput = "44 10 444 2 11";
        //String numInput = "5 2 4 1 9";
        //String numInput = "50 20 40 10 90";
      // String numInput = "44 33 -5 55 94 -3 40";
        //String numInput = "1000 1 55555 999 300 250 1150";
        // DOES NOT WORK
        //String numInput = "98 99 7 96 -55 9999 -9999 124 598 -1 -45";

        Queue<String> numQ = new LinkedList<String>();
        List<String> numSplit = Arrays.asList(numInput.split("\\s+"));

        for(String i : numSplit) {

            numQ.add(i);
        }

        BinaryTrees<String> tree = new BinaryTrees<String>(numQ.poll());

        // Get the root node
        TreeNode newNode = tree.getNode();

        for(String i : numQ) {

            tree.add(i);
            //newNode = tree.getNode();
            //tree.newAdd(newNode, i);
        }

       System.out.println(tree.printInOrder(newNode));
        //System.out.println(tree.printRevOrder(newNode));


    }


}
