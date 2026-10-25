class PrefixTree {

    HashSet<String> map;

    public PrefixTree() {
        this.map = new HashSet<>();
    }

    public void insert(String word) {
        map.add(word);
    }

    public boolean search(String word) {
        return map.contains(word);
    }

    public boolean startsWith(String prefix) {
        for(String str : map) {
            if(prefix.length() > str.length()) {
                continue;
            }
            if(str.startsWith(prefix)) {
                return true;
            }
        }
        return false;
    }
}
