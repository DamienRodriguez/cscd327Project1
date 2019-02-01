import java.util.*;

public class DictPrefixTree
{
    private class Node
    {
        Map<Character, Node> children = new TreeMap<>();
        boolean aword = false;
    }

    private Node root;
    public DictPrefixTree()
    {
        this.root = new Node();
    }

    public void insertString(String s) {
        insertString(root, s);
    }

    private void insertString(Node root, String s)
    {
        Node cur = root;
        for (char ch : s.toCharArray())
        {

            Node next = cur.children.get(ch);

            if (next == null)
                cur.children.put(ch, next = new Node());

            cur = next;
        }
        cur.aword = true;
    }

    public void printSorted()
    {
        printSorted(this.root, "");
    }

    private void printSorted(Node n, String s)
    {
        if(n.aword)
            System.out.println(s);

        for(Character ch: n.children.keySet())
            printSorted(n.children.get(ch), s + ch);
    }





    //stuff goes here
}
