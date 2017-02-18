import java.awt.event.KeyEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import java.io.*;

/* This class sets up a nicer frame for display */
class NiceFrame extends JFrame {
    static final int WIDTH = 300, HEIGHT = 300;

    public NiceFrame() {
        super("Nice Frame");
        setFrame(WIDTH, HEIGHT);
    }

    public NiceFrame(String title) {
        super(title);
        setFrame(WIDTH, HEIGHT);
    }

    public NiceFrame(String title, int width, int height) {
        super(title);
        setFrame(width, height);
    }

    public void display() {

        setVisible(true);
        pack();
    }

    private void setFrame(int width, int height) {
        setSize(width, height);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

class InputOutputPanel extends JPanel {
    //create input/output components
    private JLabel exprLbl = new JLabel("Original List", JLabel.CENTER);
    private JLabel resultLbl = new JLabel("Sorted List", JLabel.CENTER);
    private JTextField exprTxt = new JTextField("");
    private JTextField resultTxt = new JTextField("");

    // Radio button groups


    public InputOutputPanel(BinaryTreesPanel bPanel) {
        setLayout(new GridLayout(2, 2));
        resultTxt.setBackground(Color.lightGray);
        resultTxt.setEditable(false);
        add(exprLbl);
        add(exprTxt);

        add(resultLbl);
        add(resultTxt);

        // Add Radio Button Groups
    }

    String getExprTxt() {
        return exprTxt.getText();
    }

    void setResultTxt(String result) {
        resultTxt.setText(result);
    }


}

class ButtonsPanel extends JPanel {

    private BinaryTreesPanel bPanel;
    private JButton sortBtn = new JButton("Perform Sort");
    private BinaryTrees bsTree;
    private TreeNode rootNode;
    private CombRadioPanel cPanel = new CombRadioPanel(this);


    public ButtonsPanel(BinaryTreesPanel bPanel) {

        this.bPanel = bPanel;
        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(sortBtn);
        add(cPanel, BorderLayout.SOUTH);

        sortBtn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                //bsTree = new BinaryTrees();
                btnBinaryOprAction();
            }
        }

        );  // END BUTTON

    }

    // Method to get actions of radio buttons

    // Action to call the class to tokenize and parse
    // Input is a string, output will also be a string
    public void btnBinaryOprAction() {

        // Gets input from above panel
        String expr = bPanel.ioPanel.getExprTxt();

        // Going to have to get the actions
        // Getting thse from the radio buttons pannel
        String sortCmd = cPanel.getSortCmd();

        String numCmd = cPanel.getNumCmd();

        // Keeping this relatively crude and simple
        // The sortCmd returns what the radio Button string is
        // String a: Ascending
        // String d: Descending
        // -- Simialr for the Number Type button
        // String i: Integer
        // String f: Fraction

        if(sortCmd.equals("a")) {

            // integer
            if(numCmd.equals("i")) {

                // Print Integers in Ascending order
            }
            else {

                // Print Fractions in Ascending order
            }
        }
        else {      // descending order

            if(numCmd.equals("i")) {

                // Print Integers in descending order
            }
            else {

                // Print Fractions in descending order
            }

        }

        //rootNode = bsTree.buildTreeWithInput(expr);

        //bPanel.ioPanel.setResultTxt(rootNode.inOrderWalk());
    }



}

class SortRadioPanel extends JPanel implements ActionListener {

    private JRadioButton ascRbtn = new JRadioButton("Ascending");
    private JRadioButton descRbtn = new JRadioButton("Descending");
    private CombRadioPanel bPanel;
    private String sortCmd;


    private ButtonGroup bgSort = new ButtonGroup();

    public SortRadioPanel(CombRadioPanel bPanel) {

        // Add to group
        bgSort.add(ascRbtn);
        bgSort.add(descRbtn);
        bgSort.clearSelection();

        this.bPanel = bPanel;

        ascRbtn.setSelected(true);
        ascRbtn.setMnemonic(KeyEvent.VK_B);
        ascRbtn.setActionCommand("a");
        //ascRbtn.addActionListener();

        descRbtn.setMnemonic(KeyEvent.VK_C);
        descRbtn.setActionCommand("d");

        JPanel sortPanel = new JPanel();
        sortPanel.setLayout(new GridLayout(2,1));
        sortPanel.add(ascRbtn);
        sortPanel.add(descRbtn);

        sortPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Sort Order"));

        //setContentPane(sortPanel);
        add(sortPanel);

    }

    /** Listens to the radio buttons. */
    public void actionPerformed(ActionEvent e) {

        // Get Radio Button Actione.getActionCommand();
        //asc = ascending order
        //desc = descending order
        sortCmd = e.getActionCommand();

    }

    // Get teh radio button command
    // Sort COmmand will be either a or d
    public String getCommand() {

        return sortCmd;
    }
}

class NumRadioPanel extends JPanel implements ActionListener {

    private JRadioButton intRbtn = new JRadioButton("Integer");
    private JRadioButton fracRbtn = new JRadioButton("Fraction");
    private CombRadioPanel bPanel;
    private String numCmd;

    private ButtonGroup bgNum = new ButtonGroup();

    public NumRadioPanel(CombRadioPanel bPanel) {

        //Add buttons to button group

        bgNum.add(intRbtn);
        bgNum.add(fracRbtn);
        bgNum.clearSelection();


        this.bPanel = bPanel;

        intRbtn.setSelected(true);
        intRbtn.setMnemonic(KeyEvent.VK_D);
        intRbtn.setActionCommand("i");
        fracRbtn.setMnemonic(KeyEvent.VK_E);
        fracRbtn.setActionCommand("f");

        JPanel numPanel = new JPanel();
        numPanel.setLayout(new GridLayout(2,1));
        numPanel.add(intRbtn);
        numPanel.add(fracRbtn);

        numPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Numeric Type"));

        //setContentPane(numPanel);
        add(numPanel);

    }

    /** Listens to the radio buttons. */
    public void actionPerformed(ActionEvent e) {

        // Get Radio Button Actione.getActionCommand();
        numCmd = e.getActionCommand();
    }

    // Get teh radio button command
    // Number Command will either be string i or f
    public String getCommand() {

        return numCmd;
    }
}

// This is a combination panel that combines both
// The radio button panels above into one, larger panel.
// This was mostly done to allow a nicer alignment of elemnts.
class CombRadioPanel extends JPanel {

    public SortRadioPanel sPanel = new SortRadioPanel(this);
    public NumRadioPanel nPanel = new NumRadioPanel(this);

    public CombRadioPanel(ButtonsPanel bPanel) {

        setLayout(new GridLayout(1,2));
        setBackground(Color.lightGray);
        add(sPanel);
        add(nPanel);

    }

    public String getSortCmd() {

        return sPanel.getCommand();
    }

    public String getNumCmd() {

        return nPanel.getCommand();
    }

}

class BinaryTreesPanel extends JPanel {

    // main panel
    public InputOutputPanel ioPanel = new InputOutputPanel(this);
    public ButtonsPanel btnPanel = new ButtonsPanel(this);
    //public CombRadioPanel cPanel = new CombRadioPanel(this);


    public BinaryTreesPanel() {

        setLayout(new BorderLayout());
        //setLayout(new GridLayout(4,2));
        setBackground(Color.lightGray);
        add(ioPanel, BorderLayout.NORTH);
        add(btnPanel, BorderLayout.CENTER);
        //add(cPanel, BorderLayout.SOUTH);


    }

}


public class mainGui extends NiceFrame {

    public mainGui() {
        super("Binary Search Tree Sort", 500, 500);
        add(new BinaryTreesPanel());
    }


    static public void main(String[] args) {
        mainGui bst = new mainGui();
        bst.display();
    }



}
