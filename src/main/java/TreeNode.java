/**
 * Created by nallgood on 2/16/17.
 */
public class TreeNode<T> {

    public T toInsert;
    public TreeNode leftNode;
    public TreeNode rightNode;

    public TreeNode(T toInsert) {

        this.toInsert = toInsert;
        this.leftNode = null;
        this.rightNode = null;
    }


    // This works instead of operatorOverloading
    // We essentially create this method to compare the objects of TreeNode
    // But the compareTo actually returns the comparison of
    // The data they are trying to insert

    public int compareTo(TreeNode<T> node) {

        // So here we get an integer result of comparing both
        // Objects

        return ((Comparable) this.toInsert).compareTo(node.toInsert);

    }
}
