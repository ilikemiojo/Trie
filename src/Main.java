import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Trie myTrie = new Trie();

        try {
            Scanner scanner = new Scanner(new File(args[0]));

            while (scanner.hasNextLine()) {
                myTrie.insert(scanner.nextLine());
            }

            scanner.close();
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }

        if (args.length == 3) {
            myTrie.autocomplete(args[1], Integer.parseInt(args[2]));
        } else {
            myTrie.autocomplete(args[1]);
        }
    }
}
