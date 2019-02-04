import java.util.Scanner;
import java.io.File;

public class Tester {

    public static void main(String args[]) throws Exception {

        File dictionary = new File("dictionary.txt");
        Scanner fin = new Scanner(dictionary);

        DictPrefixTree dictTree = new DictPrefixTree();
        DictHashTable dictHash = new DictHashTable(100000);


        while(fin.hasNextLine()) {

            String[] line = fin.nextLine().split(",");
            dictTree.insertString(line[0]);
            dictHash.put(line[0], line[1]);
        } //this should have the whole tree created
        fin.close();

        SolverTree decoderRing = new SolverTree("234");

        Queue IHOPETHISWORKS = decoderRing.allPaths();
        IHOPETHISWORKS.printAll();



        //dictTree.printSorted();

    }
}
