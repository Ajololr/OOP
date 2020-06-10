package Decorator;

import Card.Card;
import Serialization.Serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.LinkedList;
import java.util.zip.*;

public class SerialisationWithZip extends Decorator {
    private final String fileName = "Compressed.zip";

    @Override
    public String getSerialisationName() {
        return "XML with ZIP";
    }

    @Override
    public String getFileName() {
        return fileName;
    }

    @Override
    public void saveToFile(LinkedList<Card> cards) throws Exception {
        serialization.saveToFile(cards);

        String sourceFile = serialization.getFileName();
        FileOutputStream fos = new FileOutputStream(fileName);
        ZipOutputStream zipOut = new ZipOutputStream(fos);
        File fileToZip = new File(sourceFile);
        FileInputStream fis = new FileInputStream(fileToZip);
        ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
        zipOut.putNextEntry(zipEntry);
        byte[] bytes = new byte[1024];
        int length;
        while((length = fis.read(bytes)) >= 0) {
            zipOut.write(bytes, 0, length);
        }
        zipOut.close();
        fis.close();
        fos.close();
    }

    @Override
    public LinkedList<Card> loadFromFile() throws Exception {
        byte[] buffer = new byte[1024];
        ZipInputStream zis = new ZipInputStream(new FileInputStream(fileName));
        ZipEntry zipEntry = zis.getNextEntry();
        while (zipEntry != null) {
            File newFile = new File(zipEntry.getName());
            FileOutputStream fos = new FileOutputStream(newFile);
            int len;
            while ((len = zis.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
            }
            fos.close();
            zipEntry = zis.getNextEntry();
        }
        zis.closeEntry();
        zis.close();

        return  serialization.loadFromFile();
    }

    public SerialisationWithZip(Serialization serialization) {
        this.serialization = serialization;
    }

    public SerialisationWithZip() {
    }


    @Override
    public Decorator getSerialisationObj() {
        return new SerialisationWithZip();
    }
}
