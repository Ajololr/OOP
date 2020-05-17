package HeroCard;

import Card.Card;
import CardType.CardType;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.CardController;
import sample.Controller;
import sample.TableField;

public class HeroCard extends Card {
    private int turnValue;
    private String skillDescription;

    public HeroCard(String name, CardType type, int turnValue, String skillDescription) {
        super(name, type);
        setTurnValue(turnValue);
        setSkillDescription(skillDescription);
    }
    public HeroCard(){}

    @Override
    public void setEditFields(CardController controller) {
        controller.setFieldsForHero();
        Button addBtn = new Button("Edit card");
        addBtn.setLayoutX(20);
        addBtn.setLayoutY(360);
        addBtn.setOnAction(e -> {
            if (controller.nameField.getText().trim().isEmpty() || controller.skillField.getText().trim().isEmpty()) return;
            try {
                HeroCard card = new HeroCard(controller.nameField.getText(), controller.typeField.getValue(), Integer.parseInt(controller.turnField.getText()), controller.skillField.getText());
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

    ;

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

    public static void setFields() {

    }
}
