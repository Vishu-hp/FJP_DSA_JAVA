// Using hashmap

/*
    Time Complexity : O(N * W) [insert : O(W), search : O(W), startsWith : O(W)]
    Space Complexity : O(N * W)

    Where N is the number of queries and W is the average length of words
*/


import java.util.HashMap;

class TrieNode {
    HashMap<Integer, TrieNode> child;
    boolean isEnd;

    TrieNode() {
        child = new HashMap<Integer, TrieNode>();
        isEnd = false;
    }
}

public class Trie {

    public static TrieNode root;

    //Initialize your data structure here

    Trie() {
        root = new TrieNode();
    }


    //Inserts a word into the trie

    public void insert(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); ++i) {
            int index = word.charAt(i) - 'a';

            if (!current.child.containsKey(index)) {
                current.child.put(index, new TrieNode());
            }

            current = current.child.get(index);
        }

        current.isEnd = true;
    }


    //Returns if the word is in the trie

    public boolean search(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); ++i) {
            int index = word.charAt(i) - 'a';

            if (!current.child.containsKey(index)) {
                return false;
            }

            current = current.child.get(index);
        }

        return current.isEnd;
    }


    //Returns if there is any word in the trie that starts with the given prefix

    public boolean startsWith(String prefix) {
        TrieNode current = root;

        for (int i = 0; i < prefix.length(); ++i) {
            int index = prefix.charAt(i) - 'a';

            if (!current.child.containsKey(index)) {
                return false;
            }

            current = current.child.get(index);
        }

        return true;
    }
}


// Using arraylist

/*
    Time Complexity : O(N * W) [insert : O(W), search : O(W), startsWith : O(W)]
    Where N is the number of queries and W is the average length of words

    Space Complexity : O(N * W)
    Where N is the number of words inserted and W is the average length of words.
*/


import java.util.ArrayList;

class TrieNode {
    ArrayList<TrieNode> child;
    boolean isEnd;

    TrieNode() {
        child = new ArrayList<TrieNode>(26);

        for (int i = 0; i < 26; ++i) {
            child.add(null);
        }

        isEnd = false;
    }
}

public class Trie {

    public static TrieNode root;

    //Initialize your data structure here

    Trie() {
        root = new TrieNode();
    }


    //Inserts a word into the trie

    public void insert(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); ++i) {
            int index = word.charAt(i) - 'a';

            if (current.child.get(index) == null) {
                current.child.set(index, new TrieNode());
            }

            current = current.child.get(index);
        }

        current.isEnd = true;
    }


    //Returns if the word is in the trie

    public boolean search(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); ++i) {
            int index = word.charAt(i) - 'a';

            if (current.child.get(index) == null) {
                return false;
            }

            current = current.child.get(index);
        }

        return current.isEnd;
    }


    //Returns if there is any word in the trie that starts with the given prefix

    public boolean startsWith(String prefix) {
        TrieNode current = root;

        for (int i = 0; i < prefix.length(); ++i) {
            int index = prefix.charAt(i) - 'a';

            if (current.child.get(index) == null) {
                return false;
            }

            current = current.child.get(index);
        }

        return true;
    }
}
