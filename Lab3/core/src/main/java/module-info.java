import sample.BasicService;
import sample.IService;
import Card.Card;

open module core {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    requires java.desktop;
    requires javafx.base;

    exports sample;
    exports HeroCard;
    exports QuarterCard;
    exports CommonQuarter;
    exports MilitaryQuarter;
    exports NobleQuarter;
    exports SpiritualQuarter;
    exports UniqueQuarter;
    exports Card;

    uses IService;
    provides IService with BasicService;
}