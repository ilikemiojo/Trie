import java.util.HashMap;

public class TrieNode {

    // ATTRIBUTES
    private boolean isWord;
    private HashMap<Character, TrieNode> children = new HashMap<>();
    private String text;

    // GETTERS AND SETTERS

    public boolean isWord() {
        return isWord;
    }

    public void setWord(boolean word) {
        isWord = word;
    }

    public HashMap<Character, TrieNode> getChildren() {
        return children;
    }

    public void setChildren(HashMap<Character, TrieNode> children) {
        this.children = children;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
