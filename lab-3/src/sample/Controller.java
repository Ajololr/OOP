package sample;

import Card.Card;
import CommonQuarter.CommonQuarter;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

public class Controller {
    public static ObservableList<TableField> tableDataList = FXCollections.observableArrayList();
    public static int selectedIndex;
    public static boolean isEditing = false;
    @FXML
    private TableView<TableField> cardsTable;
    @FXML
    private TableColumn<TableField, Object> nameColumn;
    @FXML
    private TableColumn<TableField, Integer> hashCodeColumn;

    @FXML
    private void initialize() {
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
        Parent root = FXMLLoader.load(getClass().getResource("CardForm.fxml"));
        primaryStage.setTitle("Lab3");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }

    @FXML
    public void editCard() throws Exception{
        selectedIndex = cardsTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex != -1) {
            isEditing = true;
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("CardForm.fxml"));
            primaryStage.setTitle("Lab3");
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
