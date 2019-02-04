import java.util.Scanner;
import java.io.File;

public class Tester {

    public static void main(String args[]) throws Exception {

        File dictionary = new File("dictionary.txt");

        Scanner fin = new Scanner(dictionary);
        Scanner kb = new Scanner(System.in);

        DictPrefixTree dictTree = new DictPrefixTree();
        DictHashTable dictHash = new DictHashTable(100000);


        while(fin.hasNextLine()) {

            String[] line = fin.nextLine().split(",");
            dictTree.insertString(line[0]);
            dictHash.put(line[0], line[1]);
        } //this should have the whole tree created
        fin.close();

        boolean end = false;
        while(!end)
        {
            System.out.println("Please enter your keypad combination (Please use no spaces, or any other characters except 2-9) or enter 0 by itself to quit.");
            String answer = kb.nextLine();

            if(Integer.parseInt(answer.charAt(0) + "") == 0)
            {
                end = true;
                System.out.println("Thank you! Have a good day!");
            }
            else {
                SolverTree decoderRing = new SolverTree(answer);

                Queue q = decoderRing.allPaths();
                Queue words = new Queue();

                while (q.size() > 0) {
                    String s = (String) q.dequeue();

                    if (dictHash.contains(s) && dictTree.findWord(s))
                        words.enqueue(s);
                }

                words.printAll();
            }
        }

    }
}
