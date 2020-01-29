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
        	letter = "";
        	c1 = null;
        	c2 = null;
        	c3 = null;
        	c4 = null;
        }
        
        private Node(String s)
        {
        	letter = s;
        	c1 = null;
        	c2 = null;
        	c3 = null;
        	c4 = null;
        	aword = true;
        }
    }

    private Node root;
    private int numLevels;
    public SolverTree(String s) {

        this.root = new Node();
        // first root node
        // number 1
        // we would create 3 child nodes a, b, and c, then queue all of those into a queue
        //        // take second number
        //        // number 2 (d,e,f)
        //        // we would dequeue first element, then we would create its child nodes as d,e,f. and then queue them
        //        // in that order. then continue with b, and create child nodes.
        //        // nodes would look like the following:
        //
        //        // a, b, c
        // d e f, d e f, d e f
        Queue temp = new Queue();
        temp.enqueue(this.root);
        constructorHelper(s, temp, 0);
    }
    
    private void constructorHelper(String s, Queue wack, int level)
    {
    	if(!(s.isEmpty()))
    	{
    		for(int x = 0; x < (int)(Math.pow(4,level)); x++)
    		{
    			Node temp = (SolverTree.Node)wack.dequeue();
    			if(temp != null)
    			{
    				String set = keyPadLetters[Integer.parseInt(s.substring(0,1)) - 2];
    				if(set.length() == 3)
    				{
    					temp.c1 = new Node(set.substring(0,1));
    					temp.c2 = new Node(set.substring(1,2));
    					temp.c3 = new Node(set.substring(2));
    					temp.c4 = new Node();
    				}
    				else
    				{
    					temp.c1 = new Node(set.substring(0,1));
    					temp.c2 = new Node(set.substring(1,2));
    					temp.c3 = new Node(set.substring(2,3));
    					temp.c4 = new Node(set.substring(3));
    				}
    				wack.enqueue(temp.c1);
    				wack.enqueue(temp.c2);
    				wack.enqueue(temp.c3);
    				wack.enqueue(temp.c4);
    			}//end Node creation/queueing
    		}//end for loop
    		constructorHelper(s.substring(1), wack, level + 1);
    	}//end null string if statement
        else
            this.numLevels = level;
    }//end constructorHelper

    public Queue allPaths()
    {
        Queue temp = new Queue();
        allPaths(temp, 0, "", this.root);

        return temp;
    }

    private void allPaths(Queue q, int level, String s, Node root) {

        if(root != null) {

            allPaths(q, level++, s + root.letter, root.c1);
            allPaths(q, level++, s + root.letter, root.c2);
            allPaths(q, level++, s + root.letter, root.c3);
            allPaths(q, level++, s + root.letter, root.c4);

        } else {

            if(level == numLevels && s.length() == numLevels)
                q.enqueue(s);
        }
    }

    public Queue solver(Queue q, DictHashTable d, DictPrefixTree t)
    {
        Queue words = new Queue();
        while (q.size() > 0)
        {
            String s = (String) q.dequeue();

            if (d.contains(s) && t.findWord(s))
                words.enqueue(s);
        }

        return words;
    }
}
