/**
 * Created by nallgood on 2/16/17.
 */
 public class TreeNode<T extends Comparable> {

    //public K key;
    public T value;
    public TreeNode leftNode;
    public TreeNode rightNode;

    public TreeNode(T value) {

        this.value = value;
        //this.key = key;
    }

    // This works instead of operatorOverloading
    // We essentially create this method to compare the objects of TreeNode
    // But the compareTo actually returns the comparison of
    // The data they are trying to insert

    /*
    @Override
    public String toString() {

        return key + ":" + value + " ";
    }
    */


    public int compareTo(TreeNode<T> node) {

        // So here we get an integer result of comparing both
        // Objects

        return ((Comparable) this.value).compareTo(node.value);

    }

}
