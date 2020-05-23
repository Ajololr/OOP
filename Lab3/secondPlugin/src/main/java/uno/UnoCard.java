package uno;

import Card.Card;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.CardController;
import sample.Controller;
import sample.IService;
import sample.TableField;

public class UnoCard extends Card implements IService {
    public UnoCardColor type;
    public String unoCardValue;

    public UnoCard(String name, UnoCardColor type, String unoCardValue) {
        super();
        setType(type);
        this.unoCardValue = unoCardValue;
    }

    public String getCardName() {
        return "Uno card";
    }

    public UnoCard(){}

    public void setType(UnoCardColor type) {
        this.type = type;
    }

    public UnoCardColor gettType() {
        return this.type;
    }

    @Override
    public void setEditFields(CardController controller) {
        Label unoValueLbl = new Label("Value:");
        unoValueLbl.setLayoutX(20);
        unoValueLbl.setLayoutY(100);
        TextField unoValueEdit = new TextField(this.unoCardValue);
        unoValueEdit.setLayoutX(60);
        unoValueEdit.setLayoutY(100);
        Label typeLbl = new Label("Type:");
        typeLbl.setLayoutX(20);
        typeLbl.setLayoutY(150);
        ComboBox<UnoCardColor> typeField = new ComboBox<>();
        ObservableList<UnoCardColor> typeList = FXCollections.observableArrayList(UnoCardColor.RED,UnoCardColor.YELLOW,UnoCardColor.GREEN,UnoCardColor.BLUE,UnoCardColor.BLACK);
        typeField.setItems(typeList);
        typeField.setValue(this.gettType());
        typeField.setLayoutX(60);
        typeField.setLayoutY(150);
        controller.anchorPane.getChildren().addAll(unoValueLbl, unoValueEdit, typeField, typeLbl);

        unoValueEdit.setText(this.unoCardValue);
        Button addBtn = new Button("Edit card");
        addBtn.setLayoutX(20);
        addBtn.setLayoutY(360);
        addBtn.setOnAction(e -> {
            try {
                UnoCard card = new UnoCard("", typeField.getValue(), unoValueEdit.getText());
                Controller.tableDataList.set(Controller.selectedIndex, new TableField(card, card.hashCode()));
            } catch (Exception ex) {
                return;
            }
            Stage stage = (Stage) addBtn.getScene().getWindow();
            stage.close();
        });
        controller.anchorPane.getChildren().add(addBtn);
        typeField.setValue(this.gettType());
    }

    public void setAddFields(CardController controller) {
        Label unoValueLbl = new Label("Value:");
        unoValueLbl.setLayoutX(20);
        unoValueLbl.setLayoutY(100);
        TextField unoValueEdit = new TextField();
        unoValueEdit.setLayoutX(60);
        unoValueEdit.setLayoutY(100);
        Label typeLbl = new Label("Type:");
        typeLbl.setLayoutX(20);
        typeLbl.setLayoutY(150);
        ComboBox<UnoCardColor> typeField = new ComboBox<>();
        ObservableList<UnoCardColor> typeList = FXCollections.observableArrayList(UnoCardColor.RED,UnoCardColor.YELLOW,UnoCardColor.GREEN,UnoCardColor.BLUE,UnoCardColor.BLACK);
        typeField.setItems(typeList);
        typeField.setValue(UnoCardColor.RED);
        typeField.setLayoutX(60);
        typeField.setLayoutY(150);
        controller.anchorPane.getChildren().addAll(unoValueLbl, unoValueEdit, typeField, typeLbl);

        Button addBtn = new Button("Add card");
        addBtn.setLayoutX(20);
        addBtn.setLayoutY(360);
        addBtn.setOnAction(e -> {
            try {
                UnoCard card = new UnoCard("", typeField.getValue(), unoValueEdit.getText());
                Controller.tableDataList.add(new TableField(card, card.hashCode()));
            } catch (Exception ex) {
                return;
            }
            Stage stage = (Stage) addBtn.getScene().getWindow();
            stage.close();
        });
        controller.anchorPane.getChildren().add(addBtn);
    }

    @Override
    public Card doJob() {
        return new UnoCard();
    }
}
