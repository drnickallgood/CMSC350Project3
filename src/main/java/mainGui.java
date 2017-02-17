import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by nallgood on 2/11/17.
 */
public class mainGui{

    // Default Constructor




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
        while(parsedIter.hasNext()) {

            // Get element
            current = parsedIter.next();

            // Create new node with the value from the list

        }

    }


}
