import JSONSerialisation.JSONSerialisation;
import sample.SerializationService;

module JSONPugin {
    requires core;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires javafx.controls;

    exports JSONSerialisation;

    provides SerializationService with JSONSerialisation;
}