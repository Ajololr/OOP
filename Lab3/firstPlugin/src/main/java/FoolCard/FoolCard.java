package FoolCard;

import Card.Card;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.CardController;
import sample.Controller;
import sample.IService;
import sample.TableField;

import java.io.Serializable;

public class FoolCard extends Card implements IService, Serializable {
    public FoolCardType type;
    public String foolCardValue;

    public FoolCard(String name, FoolCardType type, String foolCardValue) {
        super();
        setType(type);
        this.foolCardValue = foolCardValue;
    }

    public String getCardName() {
        return "Fool card";
    }

    public FoolCard(){}

    public String getFoolCardValue() {
        return foolCardValue;
    }

    public void setFoolCardValue(String foolCardValue) {
        this.foolCardValue = foolCardValue;
    }

    public void setType(FoolCardType type) {
        this.type = type;
    }

    public FoolCardType getType() {
        return this.type;
    }

    @Override
    public void setEditFields(CardController controller) {
        Label foolValueLbl = new Label("Value:");
        foolValueLbl.setLayoutX(20);
        foolValueLbl.setLayoutY(100);
        TextField foolValueEdit = new TextField(this.foolCardValue);
        foolValueEdit.setLayoutX(60);
        foolValueEdit.setLayoutY(100);
        Label typeLbl = new Label("Type:");
        typeLbl.setLayoutX(20);
        typeLbl.setLayoutY(150);
        ComboBox<FoolCardType> typeField = new ComboBox<>();
        ObservableList<FoolCardType> typeList = FXCollections.observableArrayList(FoolCardType.BUBA,FoolCardType.CHIRVA,FoolCardType.KRESTY,FoolCardType.PIKA);
        typeField.setItems(typeList);
        typeField.setValue(this.getType());
        typeField.setLayoutX(60);
        typeField.setLayoutY(150);
        controller.anchorPane.getChildren().addAll(foolValueLbl, foolValueEdit, typeField, typeLbl);

        foolValueEdit.setText(this.foolCardValue);
        Button addBtn = new Button("Edit card");
        addBtn.setLayoutX(20);
        addBtn.setLayoutY(360);
        addBtn.setOnAction(e -> {
            try {
                FoolCard card = new FoolCard("", typeField.getValue(), foolValueEdit.getText());
                Controller.tableDataList.set(Controller.selectedIndex, new TableField(card, card.hashCode()));
            } catch (Exception ex) {
                return;
            }
            Stage stage = (Stage) addBtn.getScene().getWindow();
            stage.close();
        });
        controller.anchorPane.getChildren().add(addBtn);
        typeField.setValue(this.getType());
    }

    public void setAddFields(CardController controller) {
        Label foolValueLbl = new Label("Value:");
        foolValueLbl.setLayoutX(20);
        foolValueLbl.setLayoutY(100);
        TextField foolValueEdit = new TextField();
        foolValueEdit.setLayoutX(60);
        foolValueEdit.setLayoutY(100);
        Label typeLbl = new Label("Type:");
        typeLbl.setLayoutX(20);
        typeLbl.setLayoutY(150);
        ComboBox<FoolCardType> typeField = new ComboBox<>();
        ObservableList<FoolCardType> typeList = FXCollections.observableArrayList(FoolCardType.BUBA,FoolCardType.CHIRVA,FoolCardType.KRESTY,FoolCardType.PIKA);
        typeField.setItems(typeList);
        typeField.setValue(FoolCardType.CHIRVA);
        typeField.setLayoutX(60);
        typeField.setLayoutY(150);
        controller.anchorPane.getChildren().addAll(foolValueLbl, foolValueEdit, typeField, typeLbl);

        Button addBtn = new Button("Add card");
        addBtn.setLayoutX(20);
        addBtn.setLayoutY(360);
        addBtn.setOnAction(e -> {
            try {
                FoolCard card = new FoolCard("", typeField.getValue(), foolValueEdit.getText());
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
        return new FoolCard();
    }
}
