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

        /*
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
        System.out.println("---");
        tree.printRevOrder(rootNode);

        */

        //String testFrac = "3/4";
       // String test2Frac = "2/3";

        String badFrac = "1/2/3";
        String manyFrac = "1/2 3/4 5/8 3/2 4/9 7/16 5/32 1/8";
        Fraction myFrac = null;

        // Create list from string of fracs
        List<String> splitter = Arrays.asList(manyFrac.split("\\s+"));
        Queue<Fraction> fracQ = new LinkedList<Fraction>();

        // Comparing Fractions
        //Fraction myFrac1 = new Fraction(testFrac);
        //Fraction myFrac2 = new Fraction(test2Frac);


        /* Comparison test
        if(myFrac1.compareTo(myFrac2) > 0) {

            System.out.println(myFrac1 + " Is Bigger");
        }
        else {

            System.out.println(myFrac2 + " Is Bigger");
        }
        */


        /* -- Bad Fraction Test
        try {

             myFrac = new Fraction(badFrac);
        }
        catch (NumberFormatException e) {

            System.out.println("Non Numeric Input");
        }
        */

        /*
        for(String frac : splitter) {

            // Crete single fraction object
            //System.out.println(frac);
            try {

                myFrac = new Fraction(frac);
            }
            catch(NumberFormatException e) {

                System.out.println("Non Numeric Input");
            }

            // add created fractions to fraction list
            fracList.add(myFrac);
        }

        // Print list of fractions
        for(Fraction f : fracList) {

            System.out.println(f.toString());
        }

    */


        // Create Binary Tree of fractions - test
        //BinaryTrees<Fraction> ftree = new BinaryTrees<Fraction>(new Fraction());

       // TreeNode rootNode = ftree.getNode();
        //ftree.printInOrder(rootNode);
        //System.out.println("---");
        //ftree.printRevOrder(rootNode);


        for(String frac : splitter) {

            // Crete single fraction object
            //System.out.println(frac);
            try {

                myFrac = new Fraction(frac);
            }
            catch(NumberFormatException e) {

                System.out.println("Non Numeric Input");
            }

            // Add new fractions to the queue
            fracQ.add(myFrac);

        }

        // Start with the first element we put into the queue
        // Remove it from the head, making the next the head of the quee
        BinaryTrees<Fraction> ftree = new BinaryTrees<Fraction>(fracQ.poll());

        // SInce we made the queue using a linked list, we follow
        // the exact order we put them in.
        for(Fraction frac : fracQ) {

            ftree.add(frac);

        }

        TreeNode rootNode = ftree.getNode();

        ftree.printInOrder(rootNode);
        System.out.println("---");
        ftree.printRevOrder(rootNode);


    }



}
