package UniqueQuarter;

import CardType.CardType;
import QuarterCard.QuarterCard;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import sample.CardController;
import sample.Controller;
import sample.TableField;

public class UniqueQuarter extends QuarterCard {
    private String description;

    public UniqueQuarter(String name, int cost, String description) {
        super(name, CardType.UNIQUE, cost);
        this.description = description;
    }

    @Override
    public String getCardName() {
        return "Unique quarter";
    }

    public UniqueQuarter(){}

    @Override
    public void setEditFields(CardController controller) {
        setFieldsForQuarter(controller);
        Label descLbl = new Label("Description:");
        descLbl.setLayoutX(20);
        descLbl.setLayoutY(110);
        controller.descField = new TextArea();
        controller.descField.setLayoutX(100);
        controller.descField.setLayoutY(110);
        Button addBtn = new Button("Add card");
        addBtn.setLayoutX(20);
        addBtn.setLayoutY(300);
        addBtn.setOnAction(e -> {
            if (controller.nameField.getText().trim().isEmpty() || controller.descField.getText().trim().isEmpty()) return;
            try {
                UniqueQuarter card = new UniqueQuarter(controller.nameField.getText(), Integer.parseInt(controller.costField.getText()), controller.descField.getText());
                Controller.tableDataList.set(Controller.selectedIndex, new TableField(card, card.hashCode()));
            } catch (Exception ex) {
                return;
            }
            Stage stage = (Stage) addBtn.getScene().getWindow();
            stage.close();
        });
        controller.anchorPane.getChildren().addAll(addBtn, controller.descField, descLbl);
        controller.nameField.setText(this.getName());
        controller.costField.setText(String.valueOf(this.getCost()));
        controller.descField.setText(this.getDescription());
    }

    @Override
    public void setAddFields(CardController controller) {
        setFieldsForQuarter(controller);

        Label descLbl = new Label("Description:");
        descLbl.setLayoutX(20);
        descLbl.setLayoutY(110);
        controller.descField = new TextArea();
        controller.descField.setLayoutX(100);
        controller.descField.setLayoutY(110);
        Button addBtn = new Button("Add card");
        addBtn.setLayoutX(20);
        addBtn.setLayoutY(300);
        addBtn.setOnAction(e -> {
            if (controller.nameField.getText().trim().isEmpty() || controller.descField.getText().trim().isEmpty()) return;
            try {
                UniqueQuarter card = new UniqueQuarter(controller.nameField.getText(), Integer.parseInt(controller.costField.getText()), controller.descField.getText());
                Controller.tableDataList.add(new TableField(card, card.hashCode()));
            } catch (Exception ex) {
                return;
            }
            Stage stage = (Stage) addBtn.getScene().getWindow();
            stage.close();
        });
        controller.anchorPane.getChildren().addAll(addBtn, controller.descField, descLbl);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
