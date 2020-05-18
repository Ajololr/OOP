package TradeQuarter;

import CardType.CardType;
import CommonQuarter.CommonQuarter;
import QuarterCard.QuarterCard;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.CardController;
import sample.Controller;
import sample.TableField;

public class TradeQuarter extends QuarterCard {
    public TradeQuarter(String name, int cost) {
        super(name, CardType.TRADE, cost);
    }
    public TradeQuarter(){}

    @Override
    public void setEditFields(CardController controller) {
        setFieldsForQuarter(controller);
        Button addBtn = new Button("Edit card");
        addBtn.setLayoutX(20);
        addBtn.setLayoutY(110);
        addBtn.setOnAction(e -> {
            if (controller.nameField.getText().trim().isEmpty()) return;
            try {
                TradeQuarter card = new TradeQuarter(controller.nameField.getText(), Integer.parseInt(controller.costField.getText()));
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
    public void setAddFields(CardController controller) {
        setFieldsForQuarter(controller);

        Button addBtn = new Button("Add card");
        addBtn.setLayoutX(20);
        addBtn.setLayoutY(110);
        addBtn.setOnAction(e -> {
            if (controller.nameField.getText().trim().isEmpty()) return;
            try {
                TradeQuarter card = new TradeQuarter(controller.nameField.getText(), Integer.parseInt(controller.costField.getText()));
                Controller.tableDataList.add(new TableField(card, card.hashCode()));
            } catch (Exception ex) {
                return;
            }
            Stage stage = (Stage) addBtn.getScene().getWindow();
            stage.close();
        });
        controller.anchorPane.getChildren().addAll(addBtn);
    }

    ;
}
