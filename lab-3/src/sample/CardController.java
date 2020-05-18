package sample;

import CardType.CardType;
import CommonQuarter.CommonQuarter;
import Creator.Creator;
import HeroCard.HeroCard;
import MilitaryQuarter.MilitaryQuarter;
import NobleQuarter.NobleQuarter;
import SpiritualQuarter.SpiritualQuarter;
import TradeQuarter.TradeQuarter;
import UniqueQuarter.UniqueQuarter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import java.util.HashMap;
import java.util.Map;
import javafx.stage.Stage;

public class CardController {
    public Map<String, Creator> creatorTable = new HashMap<>();
    public TextField nameField, costField, turnField;
    public TextArea skillField, descField;
    public ComboBox<CardType> typeField;

    @FXML
    public ComboBox<String> cardSelector;

    @FXML
    public AnchorPane anchorPane;

    public void setFieldsForHero() {
        Label nameLbl = new Label("Name:");
        nameLbl.setLayoutX(20);
        nameLbl.setLayoutY(50);
        nameField = new TextField();
        nameField.setLayoutX(60);
        nameField.setLayoutY(50);
        Label typeLbl = new Label("Type:");
        typeLbl.setLayoutX(20);
        typeLbl.setLayoutY(80);
        typeField = new ComboBox<>();
        ObservableList<CardType> typeList = FXCollections.observableArrayList(CardType.COMMON, CardType.MILITARY, CardType.NOBLE, CardType.SPIRITUAL, CardType.TRADE);
        typeField.setItems(typeList);
        typeField.setValue(CardType.COMMON);
        typeField.setLayoutX(60);
        typeField.setLayoutY(80);
        Label turnLbl = new Label("Turn:");
        turnLbl.setLayoutX(20);
        turnLbl.setLayoutY(110);
        turnField = new TextField();
        turnField.setLayoutX(60);
        turnField.setLayoutY(110);
        Label termLbl = new Label("Skill:");
        termLbl.setLayoutX(20);
        termLbl.setLayoutY(140);
        skillField = new TextArea();
        skillField.setLayoutX(60);
        skillField.setLayoutY(140);
        anchorPane.getChildren().addAll(nameLbl, termLbl, turnLbl, typeLbl, nameField, skillField, turnField, typeField);
    }

    public void setFieldsForQuarter() {
        Label nameLbl = new Label("Name:");
        nameLbl.setLayoutX(20);
        nameLbl.setLayoutY(50);
        nameField = new TextField();
        nameField.setLayoutX(60);
        nameField.setLayoutY(50);
        Label costLbl = new Label("Cost:");
        costLbl.setLayoutX(20);
        costLbl.setLayoutY(80);
        costField = new TextField();
        costField.setLayoutX(60);
        costField.setLayoutY(80);
        anchorPane.getChildren().addAll(nameLbl, costLbl, nameField, costField);
    }

    @FXML
    public void initialize() throws ClassNotFoundException {
        if (!Controller.isEditing) {
            creatorTable.put("Hero card", () -> {
                this.setFieldsForHero();
                Button addBtn = new Button("Add card");
                addBtn.setLayoutX(20);
                addBtn.setLayoutY(360);
                addBtn.setOnAction(e -> {
                    if (nameField.getText().trim().isEmpty() || skillField.getText().trim().isEmpty()) return;
                    try {
                        HeroCard card = new HeroCard(nameField.getText(), typeField.getValue(), Integer.parseInt(turnField.getText()), skillField.getText());
                        Controller.tableDataList.add(new TableField(card, card.hashCode()));
                    } catch (Exception ex) {
                        return;
                    }
                    Stage stage = (Stage) addBtn.getScene().getWindow();
                    stage.close();
                });
                anchorPane.getChildren().add(addBtn);
            });
            creatorTable.put("Common quarter", () -> {
                setFieldsForQuarter();
                Button addBtn = new Button("Add card");
                addBtn.setLayoutX(20);
                addBtn.setLayoutY(110);
                addBtn.setOnAction(e -> {
                    if (nameField.getText().trim().isEmpty()) return;
                    try {
                        CommonQuarter card = new CommonQuarter(nameField.getText(), Integer.parseInt(costField.getText()));
                        Controller.tableDataList.add(new TableField(card, card.hashCode()));
                    } catch (Exception ex) {
                        return;
                    }
                    Stage stage = (Stage) addBtn.getScene().getWindow();
                    stage.close();
                });
                anchorPane.getChildren().addAll(addBtn);
            });
            creatorTable.put("Military quarter", () -> {
                setFieldsForQuarter();
                Button addBtn = new Button("Add card");
                addBtn.setLayoutX(20);
                addBtn.setLayoutY(110);
                addBtn.setOnAction(e -> {
                    if (nameField.getText().trim().isEmpty()) return;
                    try {
                        MilitaryQuarter card = new MilitaryQuarter(nameField.getText(), Integer.parseInt(costField.getText()));
                        Controller.tableDataList.add(new TableField(card, card.hashCode()));
                    } catch (Exception ex) {
                        return;
                    }
                    Stage stage = (Stage) addBtn.getScene().getWindow();
                    stage.close();
                });
                anchorPane.getChildren().addAll(addBtn);
            });
            creatorTable.put("Noble quarter", () -> {
                setFieldsForQuarter();
                Button addBtn = new Button("Add card");
                addBtn.setLayoutX(20);
                addBtn.setLayoutY(110);
                addBtn.setOnAction(e -> {
                    if (nameField.getText().trim().isEmpty()) return;
                    try {
                        NobleQuarter card = new NobleQuarter(nameField.getText(), Integer.parseInt(costField.getText()));
                        Controller.tableDataList.add(new TableField(card, card.hashCode()));
                    } catch (Exception ex) {
                        return;
                    }
                    Stage stage = (Stage) addBtn.getScene().getWindow();
                    stage.close();
                });
                anchorPane.getChildren().addAll(addBtn);
            });
            creatorTable.put("Spiritual quarter", () -> {
                setFieldsForQuarter();
                Button addBtn = new Button("Add card");
                addBtn.setLayoutX(20);
                addBtn.setLayoutY(110);
                addBtn.setOnAction(e -> {
                    if (nameField.getText().trim().isEmpty()) return;
                    try {
                        SpiritualQuarter card = new SpiritualQuarter(nameField.getText(), Integer.parseInt(costField.getText()));
                        Controller.tableDataList.add(new TableField(card, card.hashCode()));
                    } catch (Exception ex) {
                        return;
                    }
                    Stage stage = (Stage) addBtn.getScene().getWindow();
                    stage.close();
                });
                anchorPane.getChildren().addAll(addBtn);
            });
            creatorTable.put("Trade quarter", () -> {
                setFieldsForQuarter();
                Button addBtn = new Button("Add card");
                addBtn.setLayoutX(20);
                addBtn.setLayoutY(110);
                addBtn.setOnAction(e -> {
                    if (nameField.getText().trim().isEmpty()) return;
                    try {
                        TradeQuarter card = new TradeQuarter(nameField.getText(), Integer.parseInt(costField.getText()));
                        Controller.tableDataList.add(new TableField(card, card.hashCode()));
                    } catch (Exception ex) {
                        return;
                    }
                    Stage stage = (Stage) addBtn.getScene().getWindow();
                    stage.close();
                });
                anchorPane.getChildren().addAll(addBtn);
            });
            creatorTable.put("Unique quarter", () -> {
                setFieldsForQuarter();
                Label descLbl = new Label("Description:");
                descLbl.setLayoutX(20);
                descLbl.setLayoutY(110);
                descField = new TextArea();
                descField.setLayoutX(100);
                descField.setLayoutY(110);
                Button addBtn = new Button("Add card");
                addBtn.setLayoutX(20);
                addBtn.setLayoutY(300);
                addBtn.setOnAction(e -> {
                    if (nameField.getText().trim().isEmpty() || descField.getText().trim().isEmpty()) return;
                    try {
                        UniqueQuarter card = new UniqueQuarter(nameField.getText(), Integer.parseInt(costField.getText()), descField.getText());
                        Controller.tableDataList.add(new TableField(card, card.hashCode()));
                    } catch (Exception ex) {
                        return;
                    }
                    Stage stage = (Stage) addBtn.getScene().getWindow();
                    stage.close();
                });
                anchorPane.getChildren().addAll(addBtn, descField, descLbl);
            });
            ObservableList<String> classList = FXCollections.observableArrayList("Hero card", "Common quarter", "Military quarter", "Noble quarter", "Spiritual quarter", "Trade quarter", "Unique quarter");
            cardSelector.setItems(classList);
            cardSelector.setValue("Select card");
        } else {
            anchorPane.getChildren().clear();
            Controller.tableDataList.get(Controller.selectedIndex).getObj().setEditFields(this);
            Controller.isEditing = false;
        }
    }

    @FXML
    public void cardSelect() {
        anchorPane.getChildren().clear();
        creatorTable.get(cardSelector.getValue()).createCard();
    }
}
