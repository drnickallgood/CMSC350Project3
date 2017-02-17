/**
 * Created by nallgood on 2/16/17.
 */
 public class TreeNode<T extends Comparable<T>> {

    public T value;
    public TreeNode<T> leftNode;
    public TreeNode<T>  rightNode;


    public TreeNode(T value, TreeNode left, TreeNode right) {

        this.leftNode = left;
        this.rightNode = right;
        this.value = value;

    }


    // This works instead of operatorOverloading
    // We essentially create this method to compare the objects of TreeNode
    // But the compareTo actually returns the comparison of
    // The data they are trying to insert

    public int compareTo(TreeNode node) {

        // So here we get an integer result of comparing both
        // Objects

        return ((Comparable) this.value).compareTo(node.value);

    }
}
