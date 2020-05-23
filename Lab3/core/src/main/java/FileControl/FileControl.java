package FileControl;

import Card.Card;

import java.util.LinkedList;

public interface FileControl {
    void saveToFile(LinkedList<Card> cards) throws Exception;
    LinkedList<Card> loadFromFile() throws Exception;
    String getSerialisationName();
}
