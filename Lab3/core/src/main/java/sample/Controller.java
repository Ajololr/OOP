package sample;

import Card.Card;
import Serialization.Serialization;
import XMLSerialisation.XMLSerialisation;
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

import java.awt.event.ActionEvent;
import java.beans.ExceptionListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.LinkedList;

public class Controller implements Controlable {
    public static ObservableList<TableField> tableDataList = FXCollections.observableArrayList();
    public static int selectedIndex;
    public static boolean isEditing = false;
    private Serialization serialization = new XMLSerialisation();
    @FXML
    public MenuBar menyBar;
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
        ToggleGroup toggleGroup = new ToggleGroup();
        Menu main = new Menu("Serialization");
        RadioMenuItem miXML = new RadioMenuItem(serialization.getSerialisationName());
        miXML.setOnAction((ActionEvent) -> {
            serialization = new XMLSerialisation();
        });
        miXML.setSelected(true);
        miXML.setToggleGroup(toggleGroup);
        main.getItems().add(miXML);

        for (Serialization serialization : Main.serializations) {
            RadioMenuItem menuItem = new RadioMenuItem(serialization.getSerialisationName());
            menuItem.setOnAction((ActionEvent) -> {
                this.serialization = serialization;
            });
            menuItem.setToggleGroup(toggleGroup);
            main.getItems().add(menuItem);
        }

        menyBar.getMenus().add(main);
    }

    @FXML
    public void saveToFile() throws Exception {
        LinkedList<Card> cards = new LinkedList<>();
        for (TableField field : cardsTable.getItems()) {
            cards.add(field.getObj());
        }
        serialization.saveToFile(cards);
    }

    @FXML
    public void loadFromFile() throws Exception {
        tableDataList.clear();
        LinkedList<Card> result = serialization.loadFromFile();
        for (Card card : result) {
            tableDataList.add(new TableField(card, card.hashCode()));
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
