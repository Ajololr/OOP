package QuarterCard;

import Card.Card;
import CardType.CardType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.CardController;

public abstract class QuarterCard extends Card {
    private int cost;

    public QuarterCard(String name, CardType type, int cost) {
        super(name, type);
        setCost(cost);
    }

    public QuarterCard(){};

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return this.cost;
    }

    public void setFieldsForQuarter(CardController controller) {
        Label nameLbl = new Label("Name:");
        nameLbl.setLayoutX(20);
        nameLbl.setLayoutY(50);
        controller.nameField = new TextField();
        controller.nameField.setLayoutX(60);
        controller.nameField.setLayoutY(50);
        Label costLbl = new Label("Cost:");
        costLbl.setLayoutX(20);
        costLbl.setLayoutY(80);
        controller.costField = new TextField();
        controller.costField.setLayoutX(60);
        controller.costField.setLayoutY(80);
        controller.anchorPane.getChildren().addAll(nameLbl, costLbl, controller.nameField, controller.costField);
    }
}
