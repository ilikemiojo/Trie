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
            if (Integer.parseInt(args[2]) > 1) {
                System.out.println("Primeiros " + args[2] + " resultados encontrados começando com '" + args[1] + "':\n");
            } else if (Integer.parseInt(args[2]) == 1) {
                System.out.println("Primeiro resultado encontrado começando com '" + args[1] + "':\n");
            }

            for (String word: myTrie.autocomplete(args[1], Integer.parseInt(args[2]))) {
                System.out.println(word + "\n");
            }

        } else {
            System.out.println("Todos os resultados encontrados começando com '" + args[1] + "':\n");

            for (String word: myTrie.autocomplete(args[1])) {
                System.out.println(word + "\n");
            }
        }
    }
}
