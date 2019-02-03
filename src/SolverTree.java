import java.util.*;

public class SolverTree
{
    String[] keyPadLetters = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    private class Node {

        private Node c1;
        private Node c2;
        private Node c3;
        private Node c4;

        String letter;

        boolean aword = false;
        
        private Node()
        {
        	letter = null;
        	c1 = null;
        	c2 = null;
        	c3 = null;
        	c4 = null;
        }
        
        private Node(String letter, Node n1, Node n2, Node n3 )
        {
        	this.letter = letter;
        	c1 = n1;
        	c2 = n2;
        	c3 = n3;
        	c4 = null;
        }
        
        private Node(String letter, Node n1, Node n2, Node n3, Node n4)
        {
        	this.letter = letter;
        	c1 = n1;
        	c2 = n2;
        	c3 = n3;
        	c4 = n4;
        }
    }

    private Node root;
    public SolverTree(String s) {

        this.root = null;
        // first root node
        // number 1
        // we would create 3 child nodes a, b, and c, then queue all of those into a queue
        // take second number
        // number 2 (d,e,f)
        // we would dequeue first element, then we would create its child nodes as d,e,f. and then queue them
        // in that order. then continue with b, and create child nodes.
        // nodes would look like the following:

        // a, b, c
        // d e f, d e f, d e f

    }

    private SolverTree.Node actualConstructor(final String s) {

        Queue q = new Queue();
        String copy = s;
        int indexOf;

        do{
            indexOf = Integer.parseInt(copy.charAt(0) + "") - 2;

        }while(q.size() != 0);

        return null;

    }
    
    private Node constructorHelper(String s)
    {
    	
    }
}
