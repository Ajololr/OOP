package sample;

import Card.Card;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.beans.ExceptionListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

public class Controller implements Controlable, XMLFileControl {
    public static ObservableList<TableField> tableDataList = FXCollections.observableArrayList();
    public static int selectedIndex;
    public static boolean isEditing = false;
    @FXML
    VBox vbMenu = new VBox();
    @FXML
    public TableView<TableField> cardsTable;
    @FXML
    public TableColumn<TableField, Object> nameColumn;
    @FXML
    public TableColumn<TableField, Integer> hashCodeColumn;

    @FXML
    public void initialize() {
        nameColumn.setCellValueFactory(data -> new ReadOnlyObjectWrapper<>(data.getValue().getObj()));
        hashCodeColumn.setCellValueFactory(data -> new ReadOnlyObjectWrapper<>(data.getValue().getHshCode()));
        cardsTable.setItems(tableDataList);
    }

    @FXML
    public void saveToFile() throws Exception {
        XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("Data.xml")));
        for (TableField field : cardsTable.getItems()) {
            encoder.writeObject(field.getObj());
        }
        encoder.close();
    }

    @FXML
    public void loadFromFile() throws Exception {
        XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("Data.xml")));
        decoder.setExceptionListener(new ExceptionListener() {
            @Override
            public void exceptionThrown(Exception e) {
                System.out.println("got exception. e=" + e);
                e.printStackTrace();
            }
        });
        tableDataList.clear();
        while (true) {
            try {
                Card tmp = (Card) decoder.readObject();
                tableDataList.add(new TableField(tmp, tmp.hashCode()));
            } catch (ArrayIndexOutOfBoundsException ex) {
                decoder.close();
                break;
            }
        }
    }

    @FXML
    public void addCard() throws Exception{
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("CardForm.fxml"));
        primaryStage.setTitle("Lab 4");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }

    @FXML
    public void editCard() throws Exception{
        selectedIndex = cardsTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex != -1) {
            isEditing = true;
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("CardForm.fxml"));
            primaryStage.setTitle("Lab 4");
            primaryStage.setScene(new Scene(root, 600, 400));
            primaryStage.show();
        }
    }

    @FXML
    public void deleteCard() throws Exception{
        selectedIndex = cardsTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex != -1) cardsTable.getItems().remove(selectedIndex);
    }
}
