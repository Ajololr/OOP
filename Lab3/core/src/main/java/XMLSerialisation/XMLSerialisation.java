package XMLSerialisation;

import Card.Card;
import Serialization.Serialization;

import java.beans.ExceptionListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.LinkedList;

public class XMLSerialisation extends Serialization {
    @Override
    public void saveToFile(LinkedList<Card> cards) throws Exception {
        XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("Data.xml")));
        for (Card card : cards) {
            encoder.writeObject(card);
        }
        encoder.close();
    }

    @Override
    public LinkedList<Card> loadFromFile() throws Exception {
        XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("Data.xml")));
        decoder.setExceptionListener(new ExceptionListener() {
            @Override
            public void exceptionThrown(Exception e) {
                System.out.println("got exception. e=" + e);
                e.printStackTrace();
            }
        });
        LinkedList<Card> result = new LinkedList<>();
        while (true) {
            try {
                result.add( (Card) decoder.readObject() );
            } catch (ArrayIndexOutOfBoundsException ex) {
                decoder.close();
                break;
            }
        }
        return result;
    }

    @Override
    public String getSerialisationName() {
        return "XML";
    }
}
