public class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean endOfWord = false;
}

class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for(char ch : word.toCharArray()) {
            int i = ch - 'a';
            if(curr.children[i] == null) {
                curr.children[i] = new TrieNode();
            }
            curr = curr.children[i];
        }
        curr.endOfWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    public boolean dfs(String word, int j, TrieNode root) {
        TrieNode curr = root;

        for(int i = j; i < word.length(); i++) {
            char ch = word.charAt(i);
            int pos = ch - 'a';

            if(ch == '.') {
                // DFS
                for (TrieNode child : curr.children) {
                    if(child != null && dfs(word, i + 1, child)) {
                        return true;
                    }
                }
                return false;

            } else {
                if (curr.children[pos] == null) {
                    return false;
                }
                curr = curr.children[pos];
            }
        }
        return curr.endOfWord;
    }

}
