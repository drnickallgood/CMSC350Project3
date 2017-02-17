/**
 * Created by nallgood on 2/16/17.
 */
public class BinaryTrees<T extends Comparable> {

    // Default Constructor

    // This will be the starting/root node
    public TreeNode rootNode;
    private T gottenNode;


    // Need to create the tree from user Input
    public void initTree() {


    }

    // -- Printing trees  -- //

    // This traversed the tree structure in order by
    // starting with the first root node
    // it then calls a helper method to print things
    // in the actual order.
    public void traverseInOrder() {

        traverseInOrderHelper(rootNode);
        //System.out.println("");
    }

    public void traverseInOrderHelper(TreeNode lastRoot) {

        if(lastRoot == null) {

            return;
        }
        traverseInOrderHelper(lastRoot.leftNode);
        //System.out.println(rootNode.value+", ");
        traverseInOrderHelper(lastRoot.rightNode);

    }

    // Keeping this as generic as we can so we can pass
    // multiple types to it in the future
    public void add(T toAdd) {

        TreeNode node = new TreeNode<T>(toAdd);

        // Check root
        if (rootNode == null) {

            rootNode = node;
        }

        addHelper(rootNode, node);
    }


    // Since we cannot do operator overloading like we can in
    // C++, we need to extends the comparable class so we can
    // Directly compare objects correct.


    // Helper function above that is recursive
    // This is so we can focus on only being recursive and adding
    // the node while the above method takes care of single items
    private void addHelper(TreeNode lastRoot, TreeNode node) {

        // Currently using int's here so we need to see
        // which is bigger
        // Uses the compareTo custom method above.

        if(lastRoot.compareTo(node) > 0) {

            if(lastRoot.leftNode == null) {

                // We currently don't have a left node for the root
                // so let's add it and return
                lastRoot.leftNode = node;
            }
            else {

                // Otherwise we recursively call this function
                // again to continue adding to the tree.
                addHelper(lastRoot.leftNode, node);
            }

        }
        else {  // Let us check the right side now

            if(lastRoot.rightNode == null) {

                lastRoot.rightNode = node;
            }
            else {

                // Recursively call this function
                // for the right side of the node.
                addHelper(lastRoot.rightNode, node);
            }

        }

    }



}
