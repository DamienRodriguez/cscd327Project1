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

    private void insertString(Node root, String s) {
        Node cur = root;
        for (char ch : s.toCharArray()) {
            Node next = cur.children.get(ch);
            if (next == null)
                cur.children.put(ch, next = new Node());
            cur = next;
        }
        cur.aword = true;
    }

    





    //stuff goes here
}
