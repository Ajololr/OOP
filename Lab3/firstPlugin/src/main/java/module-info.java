import sample.IService;

module firstPlugin {
    requires core;
    requires javafx.controls;
    exports FoolCard;

    provides IService with FoolCard.FoolCard;
}