import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Trie {

    // ATTRIBUTES
    private TrieNode root;

    // CONSTRUCTOR

    public Trie() {
        this.root = new TrieNode();
    }

    // METHODS

    public void insert(String word) {
        TrieNode currentNode = this.root;

        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            TrieNode nextNode;

            if (currentNode.getChildren().containsKey(currentChar)) {
                nextNode = currentNode.getChildren().get(currentChar);
            } else {
                nextNode = new TrieNode();
                currentNode.getChildren().put(currentChar, nextNode);
            }

            currentNode = nextNode;
        }

        currentNode.setWord(true);
        currentNode.setText(word);
    }

    public boolean remove(String word) {
        if (search(word)) {
            TrieNode removeBelowThisNode = root;
            TrieNode currentNode = root;
            TrieNode wordNode = goToNode(word);
            int deleteFromThisChar = 0;

            wordNode.setWord(false);
            wordNode.setText("");

            if (wordNode.getChildren().isEmpty()) {
                for (int i = 0; i < word.length(); i++) {
                    char currentChar = word.charAt(i);

                    if (currentNode.isWord()) {
                        removeBelowThisNode = currentNode;
                        deleteFromThisChar = (i);
                    }

                    currentNode = currentNode.getChildren().get(currentChar);
                }

                deleteNodes(removeBelowThisNode, word, deleteFromThisChar);

                return true;
            }

            return true;
        }

        return false;
    }

    public void deleteNodes(TrieNode startingNode, String word, int startingChar) {
        Stack<TrieNode> nodeStack = new Stack<>();
        TrieNode currentNode = startingNode;
        int nodeToDeletePosition = (word.length() - 1);

        for (int i = startingChar; i < (word.length() - 1); i++) {
            char currentChar = word.charAt(i);
            nodeStack.push(currentNode);
            currentNode = currentNode.getChildren().get(currentChar);
        }

        while (!nodeStack.empty()) {
            currentNode = nodeStack.pop();
            currentNode.getChildren().remove(word.charAt(nodeToDeletePosition));
            nodeToDeletePosition--;
        }
    }

    public boolean search(String word) {
        TrieNode currentNode = root;

        for (int i = 0; i < word.length(); i++) {
            Character currentChar = word.charAt(i);
            TrieNode currentCharNode = currentNode.getChildren().get(currentChar);

            if (currentCharNode == null) {
                return false;
            }

            currentNode = currentCharNode;
        }

        return currentNode.isWord();
    }

    public List<String> autocomplete(String prefix) {
        TrieNode prefixNode = goToNode(prefix);
        List<String> results;

        results = getWords(prefixNode);

        return results;
    }

    public TrieNode goToNode(String string) {
        TrieNode currentNode = root;

        for (int i = 0; i < string.length(); i++) {
            Character currentChar = string.charAt(i);
            TrieNode currentCharNode = currentNode.getChildren().get(currentChar);

            if (currentCharNode == null) {
                return null;
            }

            currentNode = currentCharNode;
        }

        return currentNode;
    }

    public List<String> getWords(TrieNode node) {
        List<String> results = new ArrayList<>();

        if (node.isWord()) {
            results.add(node.getText());
        }

        if (!node.getChildren().isEmpty()) {
            for (TrieNode child: node.getChildren().values()) {
                results.addAll(getWords(child));
            }
        }

        return results;
    }
}
