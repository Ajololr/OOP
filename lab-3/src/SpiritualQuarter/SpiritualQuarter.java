package SpiritualQuarter;

import CardType.CardType;
import CommonQuarter.CommonQuarter;
import QuarterCard.QuarterCard;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.CardController;
import sample.Controller;
import sample.TableField;

public class SpiritualQuarter extends QuarterCard {
    public SpiritualQuarter(String name, int cost) {
        super(name, CardType.SPIRITUAL, cost);
    }
    public SpiritualQuarter(){}

    @Override
    public void setEditFields(CardController controller) {
        controller.setFieldsForQuarter();
        Button addBtn = new Button("Edit card");
        addBtn.setLayoutX(20);
        addBtn.setLayoutY(110);
        addBtn.setOnAction(e -> {
            if (controller.nameField.getText().trim().isEmpty()) return;
            try {
                SpiritualQuarter card = new SpiritualQuarter(controller.nameField.getText(), Integer.parseInt(controller.costField.getText()));
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

    ;
}
