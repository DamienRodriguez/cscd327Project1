import java.util.Scanner;
import java.io.File;

public class Tester
{
    public static void main(String args[]) throws Exception
    {
        File dictionary = new File("dictionary.txt");
        Scanner fin = new Scanner(dictionary);

        DictPrefixTree dictTree = new DictPrefixTree();

        while(fin.hasNextLine())
        {
            String[] line = fin.nextLine().split(",");
            dictTree.insertString(line[0]);
        } //this should have the whole tree created

       // dictTree.printSorted();       //uncomment this line to see that we successfully created our dictionary Tree
    }
}
