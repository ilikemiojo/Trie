public class Main {
    public static void main(String[] args) {
        Trie myTrie = new Trie();

        myTrie.insert("a");
        myTrie.insert("ama");
        myTrie.insert("amar");
        myTrie.insert("ame");
        myTrie.insert("amei");
        myTrie.insert("ameixa");
        myTrie.insert("oi");
        myTrie.insert("oito");
        myTrie.insert("eu");
        myTrie.insert("ele");
        myTrie.insert("ela");
        myTrie.insert("eles");
        myTrie.insert("elas");

        /*

        // TESTE DO INSERT E SEARCH

        String output[] = {"Not present in trie", "Present in trie"};

        if (myTrie.search("amar")) { System.out.println("amar --- " + output[1]); }
        else { System.out.println("amar --- " + output[0]); }

        if (myTrie.search("amante")) { System.out.println("amante --- " + output[1]); }
        else { System.out.println("amante --- " + output[0]); }

        if (myTrie.search("oito")) { System.out.println("oito --- " + output[1]); }
        else { System.out.println("oito --- " + output[0]); }

        if (myTrie.search("opa")) { System.out.println("opa --- " + output[1]); }
        else { System.out.println("opa --- " + output[0]); }

         */

        // TESTE DO AUTOCOMPLETE

        for (String word: myTrie.autocomplete("am")) {
            System.out.println("\n" + word);
        }

        for (String word: myTrie.autocomplete("am", 4)) {
            System.out.println("\n" + word);
        }

        /*

        // TESTE DO REMOVE

        myTrie.remove("ame");
        myTrie.remove("ameixa");

        for (String word: myTrie.autocomplete("")) {
            System.out.println("\n" + word);
        }

         */
    }
}
