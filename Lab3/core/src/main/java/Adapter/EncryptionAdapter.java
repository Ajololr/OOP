package Adapter;

import Card.Card;
import Decorator.Decorator;
import Encryption.Encryption;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.LinkedList;

public class EncryptionAdapter extends Adapter {
    private Encryption encryption = Encryption.getInstance();

    @Override
    public String getFileName() {
        return serialization.getFileName();
    }

    @Override
    public void saveToFile(LinkedList<Card> cards) throws Exception {
        serialization.saveToFile(cards);
        File file = new File(serialization.getFileName());
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] data = fileInputStream.readAllBytes();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        byte[] res = encryption.Encrypt(data);
        fileOutputStream.write(res);

        fileInputStream.close();
        fileOutputStream.close();
    }

    @Override
    public LinkedList<Card> loadFromFile() throws Exception {
        File file = new File(serialization.getFileName());
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] data = fileInputStream.readAllBytes();
        byte[] res = encryption.Decrypt(data);
        fileInputStream.close();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(res);
        fileOutputStream.close();

        return serialization.loadFromFile();
    }

    public EncryptionAdapter() {

    }

    @Override
    public Decorator getSerialisationObj() {
        return null;
    }

    @Override
    public String getSerialisationName() {
        return null;
    }
}
