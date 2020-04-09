package sample;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class Controller {

    public ObservableList<TableField> tableDataList = FXCollections.observableArrayList();
    @FXML
    public TableView<TableField> cardsTable;
    @FXML
    public TableColumn<TableField,Object> nameColumn;
    @FXML
    public TableColumn<TableField, Integer> hashCodeColumn;

    @FXML
    private void initialize() {
        nameColumn.setCellValueFactory(data -> new ReadOnlyObjectWrapper<>(data.getValue().getObj()));
        hashCodeColumn.setCellValueFactory(data -> new ReadOnlyObjectWrapper<>(data.getValue().getHshCode()));
        cardsTable.setItems(tableDataList);
    }

    @FXML
    public void saveToFile() throws Exception{
    }

    @FXML
    public void loadFromFile() throws Exception{
    }

    @FXML
    public void addCard() throws Exception{
        Object obj = new Object();
        tableDataList.add(new TableField(obj, obj.hashCode()));
    }

    @FXML
    public void editCard() throws Exception{
    }

    @FXML
    public void deleteCard() throws Exception{
    }
}
