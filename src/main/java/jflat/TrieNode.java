package jflat;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrieNode {
    // TrieNode[] children;
    Map<Character, TrieNode> children;
    boolean isWord;
    ObservableList<String> words;

    public TrieNode() {
        children = new HashMap<>();
        isWord = false;
        words = FXCollections.observableArrayList();
    }
}
