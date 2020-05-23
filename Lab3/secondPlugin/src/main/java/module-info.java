import sample.IService;
import uno.UnoCard;

module secondPlugin {
    requires core;
    requires javafx.controls;
    exports uno;

    provides IService with UnoCard;
}