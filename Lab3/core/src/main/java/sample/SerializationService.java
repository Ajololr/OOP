package sample;

import Serialization.Serialization;

import java.util.List;
import java.util.ServiceLoader;
import java.util.stream.Collectors;

public interface SerializationService {
    Serialization getSerialisationObj();

    static List<SerializationService> getServices(ModuleLayer layer) {
        return ServiceLoader
                .load(layer, SerializationService.class)
                .stream()
                .map(ServiceLoader.Provider::get)
                .collect(Collectors.toList());
    }
}
