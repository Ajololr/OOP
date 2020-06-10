package Decorator;

import java.util.List;
import java.util.ServiceLoader;
import java.util.stream.Collectors;

public interface DecoratorService {
    Decorator getSerialisationObj();

    static List<DecoratorService> getServices(ModuleLayer layer) {
        return ServiceLoader
                .load(layer, DecoratorService.class)
                .stream()
                .map(ServiceLoader.Provider::get)
                .collect(Collectors.toList());
    }
}
