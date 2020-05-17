package CommonQuarter;

import CardType.CardType;
import QuarterCard.QuarterCard;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.CardController;
import sample.Controller;
import sample.TableField;

public class CommonQuarter extends QuarterCard {
    public CommonQuarter(String name, int cost) {
        super(name, CardType.COMMON, cost);
    }
    public CommonQuarter(){}

    @Override
    public void setEditFields(CardController controller) {
        controller.setFieldsForQuarter();
        Button addBtn = new Button("Edit card");
        addBtn.setLayoutX(20);
        addBtn.setLayoutY(110);
        addBtn.setOnAction(e -> {
            if (controller.nameField.getText().trim().isEmpty()) return;
            try {
                CommonQuarter card = new CommonQuarter(controller.nameField.getText(), Integer.parseInt(controller.costField.getText()));
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
