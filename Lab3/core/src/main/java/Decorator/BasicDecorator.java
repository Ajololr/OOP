package Decorator;

import Card.Card;

import java.util.LinkedList;

public class BasicDecorator extends Decorator {
    @Override
    public Decorator getSerialisationObj() {
        return new BasicDecorator();
    }

    @Override
    public String getSerialisationName() {
        return "None";
    }

    @Override
    public String getFileName() {
        return serialization.getFileName();
    }

    @Override
    public void saveToFile(LinkedList<Card> cards) throws Exception {
        serialization.saveToFile(cards);
    }

    @Override
    public LinkedList<Card> loadFromFile() throws Exception {
        return serialization.loadFromFile();
    }
}
