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

    @FXML
    public void initialize() {
        if (!Controller.isEditing) {
            creatorTable.put("Hero card", () -> {
                (new HeroCard()).setAddFields(this);
            });
            creatorTable.put("Common quarter", () -> {
                (new CommonQuarter()).setAddFields(this);
            });
            creatorTable.put("Military quarter", () -> {
                (new MilitaryQuarter()).setAddFields(this);
            });
            creatorTable.put("Noble quarter", () -> {
                (new NobleQuarter()).setAddFields(this);
            });
            creatorTable.put("Spiritual quarter", () -> {
                (new SpiritualQuarter()).setAddFields(this);
            });
            creatorTable.put("Trade quarter", () -> {
                (new TradeQuarter()).setAddFields(this);
            });
            creatorTable.put("Unique quarter", () -> {
                (new UniqueQuarter()).setAddFields(this);
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
