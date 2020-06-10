import sample.BasicService;
import sample.IService;
import sample.SerializationService;

open module core {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    requires java.desktop;
    requires javafx.base;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;

    exports sample;
    exports HeroCard;
    exports QuarterCard;
    exports CommonQuarter;
    exports MilitaryQuarter;
    exports NobleQuarter;
    exports SpiritualQuarter;
    exports UniqueQuarter;
    exports Card;
    exports Serialization;
    exports Decorator;

    uses IService;
    uses SerializationService;
    provides IService with BasicService;
}