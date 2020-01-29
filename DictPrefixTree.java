import java.util.*;

//Created by Damien Rodriguez, with Partner Ryan Bucherl

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


    //Used From Tony's Homework 4 sample code
    public void printSorted()
    {
        printSorted(this.root, "");
    }

    //Used From Tony's Homework 4 sample code
    private void printSorted(Node n, String s)
    {
        if(n.aword)
            System.out.println(s);

        for(Character ch: n.children.keySet())
            printSorted(n.children.get(ch), s + ch);
    }





    //Used From Tony's Homework 4 sample code
    public boolean findWord(String s)
    {

        Node word = findWord(root,s);

        if(word == null)
            return false;
        else
            return true;
    }


    //Used From Tony's Homework 4 sample code
    private Node findWord(Node node, String s)
    {

        if(s != null)
        {

            String rest = s.substring(1);
            char ch = s.charAt(0);

            Node child = node.children.get(ch);

            if(s.length() == 1 && child != null)
                return child;

            if(child == null)
                return null;

            else
                return findWord(child, rest);
        }
        return null;
    }
}
