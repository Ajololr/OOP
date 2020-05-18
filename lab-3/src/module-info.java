import sample.BasicService;
import sample.IService;

module lab {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    requires java.desktop;
    exports sample;
    exports HeroCard;
    exports QuarterCard;
    exports CommonQuarter;
    exports MilitaryQuarter;
    exports NobleQuarter;
    exports SpiritualQuarter;
    exports UniqueQuarter;

    uses IService;
    provides IService with BasicService;
}