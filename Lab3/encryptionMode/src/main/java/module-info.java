import JSONSerialisation.JSONSerialisation;
import sample.SerializationService;

module Encryption {
    requires core;

    exports encryption;

    provides SerializationService with JSONSerialisation;
}