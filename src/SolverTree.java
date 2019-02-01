import java.util.*;

public class SolverTree
{
    private class Node
    {
        Map<Character, Node> child1 = new TreeMap<>();
        Map<Character, Node> child2 = new TreeMap<>();
        Map<Character, Node> child3 = new TreeMap<>();
        Map<Character, Node> child4 = new TreeMap<>();

        boolean aword = false;
    }
}
