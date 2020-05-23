package MilitaryQuarter;

import CardType.CardType;
import CommonQuarter.CommonQuarter;
import QuarterCard.QuarterCard;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.CardController;
import sample.Controller;
import sample.TableField;

public class MilitaryQuarter extends QuarterCard {
    public MilitaryQuarter(String name, int cost) {
        super(name, CardType.MILITARY, cost);
    }
    public MilitaryQuarter(){}

    @Override
    public void setEditFields(CardController controller) {
        setFieldsForQuarter(controller);
        Button addBtn = new Button("Edit card");
        addBtn.setLayoutX(20);
        addBtn.setLayoutY(110);
        addBtn.setOnAction(e -> {
            if (controller.nameField.getText().trim().isEmpty()) return;
            try {
                MilitaryQuarter card = new MilitaryQuarter(controller.nameField.getText(), Integer.parseInt(controller.costField.getText()));
                Controller.tableDataList.set(Controller.selectedIndex, new TableField(card, card.hashCode()));
            } catch (Exception ex) {
                return;
            }
            Stage stage = (Stage) addBtn.getScene().getWindow();
            stage.close();
        });
        controller.anchorPane.getChildren().addAll(addBtn);
        controller.nameField.setText(this.getName());
        controller.costField.setText(String.valueOf(this.getCost()));
    }

    @Override
    public String getCardName() {
        return "Military quarter";
    }

    @Override
    public void setAddFields(CardController controller) {
        setFieldsForQuarter(controller);

        Button addBtn = new Button("Add card");
        addBtn.setLayoutX(20);
        addBtn.setLayoutY(110);
        addBtn.setOnAction(e -> {
            if (controller.nameField.getText().trim().isEmpty()) return;
            try {
                MilitaryQuarter card = new MilitaryQuarter(controller.nameField.getText(), Integer.parseInt(controller.costField.getText()));
                Controller.tableDataList.add(new TableField(card, card.hashCode()));
            } catch (Exception ex) {
                return;
            }
            Stage stage = (Stage) addBtn.getScene().getWindow();
            stage.close();
        });
        controller.anchorPane.getChildren().addAll(addBtn);
    }

}
