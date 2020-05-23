package HeroCard;

import Card.Card;
import CardType.CardType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.CardController;
import sample.Controller;
import sample.TableField;

public class HeroCard extends Card {
    private int turnValue;
    private String skillDescription;
    private CardType type;

    public HeroCard(String name, CardType type, int turnValue, String skillDescription) {
        super(name);
        setType(type);
        setTurnValue(turnValue);
        setSkillDescription(skillDescription);
    }
    public HeroCard(){}

    @Override
    public void setEditFields(CardController controller) {
        setFieldsForHero(controller);
        Button addBtn = new Button("Edit card");
        addBtn.setLayoutX(20);
        addBtn.setLayoutY(360);
        addBtn.setOnAction(e -> {
            if (controller.nameField.getText().trim().isEmpty() || controller.skillField.getText().trim().isEmpty()) return;
            try {
                HeroCard card = new HeroCard(controller.nameField.getText(),(CardType) controller.typeField.getValue(), Integer.parseInt(controller.turnField.getText()), controller.skillField.getText());
                Controller.tableDataList.set(Controller.selectedIndex, new TableField(card, card.hashCode()));
            } catch (Exception ex) {
                return;
            }
            Stage stage = (Stage) addBtn.getScene().getWindow();
            stage.close();
        });
        controller.anchorPane.getChildren().add(addBtn);
        controller.nameField.setText(this.getName());
        controller.skillField.setText(this.getSkillDescription());
        controller.turnField.setText(String.valueOf(this.getTurnValue()));
        controller.typeField.setValue(this.getType());
    }

    public void setType(CardType type) {
        this.type = type;
    }

    public CardType getType() {
        return this.type;
    }

    @Override
    public String getCardName() {
        return "Hero card";
    }

    private void setFieldsForHero(CardController controller) {
        Label nameLbl = new Label("Name:");
        nameLbl.setLayoutX(20);
        nameLbl.setLayoutY(50);
        controller.nameField = new TextField();
        controller.nameField.setLayoutX(60);
        controller.nameField.setLayoutY(50);
        Label typeLbl = new Label("Type:");
        typeLbl.setLayoutX(20);
        typeLbl.setLayoutY(80);
        ComboBox<CardType> typeField = new ComboBox<>();
        ObservableList<CardType> typeList = FXCollections.observableArrayList(CardType.COMMON, CardType.MILITARY, CardType.NOBLE, CardType.SPIRITUAL, CardType.TRADE);
        typeField.setItems(typeList);
        typeField.setValue(CardType.COMMON);
        typeField.setLayoutX(60);
        typeField.setLayoutY(80);
        Label turnLbl = new Label("Turn:");
        turnLbl.setLayoutX(20);
        turnLbl.setLayoutY(110);
        controller.turnField = new TextField();
        controller.turnField.setLayoutX(60);
        controller.turnField.setLayoutY(110);
        Label termLbl = new Label("Skill:");
        termLbl.setLayoutX(20);
        termLbl.setLayoutY(140);
        controller.skillField = new TextArea();
        controller.skillField.setLayoutX(60);
        controller.skillField.setLayoutY(140);
        controller.anchorPane.getChildren().addAll(nameLbl, termLbl, turnLbl, typeLbl, controller.nameField, controller.skillField, controller.turnField, typeField);
    }


    @Override
    public void setAddFields(CardController controller) {
        setFieldsForHero(controller);

        Button addBtn = new Button("Add card");
        addBtn.setLayoutX(20);
        addBtn.setLayoutY(360);
        addBtn.setOnAction(e -> {
            if (controller.nameField.getText().trim().isEmpty() || controller.skillField.getText().trim().isEmpty()) return;
            try {
                HeroCard card = new HeroCard(controller.nameField.getText(), (CardType) controller.typeField.getValue(), Integer.parseInt(controller.turnField.getText()), controller.skillField.getText());
                Controller.tableDataList.add(new TableField(card, card.hashCode()));
            } catch (Exception ex) {
                return;
            }
            Stage stage = (Stage) addBtn.getScene().getWindow();
            stage.close();
        });
        controller.anchorPane.getChildren().add(addBtn);
    }

    public void setTurnValue(int termValue) {
        this.turnValue = termValue;
    }

    public int getTurnValue() {
        return this.turnValue;
    }

    public String getSkillDescription() {
        return skillDescription;
    }

    public void setSkillDescription(String skillDescription) {
        this.skillDescription = skillDescription;
    }
}
