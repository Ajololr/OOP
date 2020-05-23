import sample.IService;

module firstPlugin {
    requires core;
    requires javafx.controls;
    exports JSONSerialisation;

    provides IService with JSONSerialisation.FoolCard;
}