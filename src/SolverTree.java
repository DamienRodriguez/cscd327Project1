import java.util.*;

public class SolverTree
{
    String numPad2 = "abc";
    String numPad3 = "def";
    String numPad4 = "ghi";
    String numPad5 = "jkl";
    String numPad6 = "mno";
    String numPad7 = "pqrs";
    String numPad8 = "tuv";
    String numPad9 = "wxyz";



    private class Node
    {
        private Node c1;
        private Node c2;
        private Node c3;
        private Node c4;

        boolean aword = false;
    }

    private Node root;
    public SolverTree(String s)
    {
        this.root = null;
        // first root node
        // number 1
        // we would create 3 child nodes a, b, and c, then queue all of those into a queue
        // take second number
        // number 2 (d,e,f)
        // we would dequeue first element, then we would create its child nodes as d,e,f. and then queue them
        // in that order. then continue with b, and create child nodes.
        // nodes would look like the following: aa, ab, ac

        //root
        // a, b, c
        // d e f, d e f, d e f

    }
}
