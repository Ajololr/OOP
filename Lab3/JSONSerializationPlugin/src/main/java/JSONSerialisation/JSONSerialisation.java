package JSONSerialisation;

import Card.Card;
import Serialization.Serialization;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import sample.*;

import java.io.File;
import java.util.LinkedList;

public class JSONSerialisation extends Serialization implements SerializationService {
    private final String fileName = "Data.json";

    public String getFileName() {
        return fileName;
    }

    public void saveToFile(LinkedList<Card> cards) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(fileName), cards);
    }

    public LinkedList<Card> loadFromFile() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
//        String json = (new File("Data.json")).toString();
        LinkedList<Card> result = objectMapper.readValue(new File(fileName), new TypeReference<LinkedList<Card>>(){});
        return result;
    }

    public String getSerialisationName() {
        return "JSON";
    }

    public Serialization getSerialisationObj() {
        return new JSONSerialisation();
    }
}