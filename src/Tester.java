import java.util.Scanner;
import java.io.File;

public class Tester {

    public static void main(String args[]) throws Exception {

        File dictionary = new File("dictionary.txt");
        Scanner fin = new Scanner(dictionary);
        Scanner fin2 = new Scanner(dictionary);

        DictPrefixTree dictTree = new DictPrefixTree();
        DictHashTable dictHash = new DictHashTable(100000);


        while(fin.hasNextLine()) {

            String[] line = fin.nextLine().split(",");
            dictTree.insertString(line[0]);
        } //this should have the whole tree created
        fin.close();

        while(fin2.hasNextLine()){

            String[] line = fin2.nextLine().split(",");
            dictHash.put(line[0], line[1]);
        }
        fin2.close();

        System.out.println(dictHash);



        //dictTree.printSorted();

    }
}
