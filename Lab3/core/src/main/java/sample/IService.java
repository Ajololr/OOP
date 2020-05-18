package sample;

import Card.Card;

import java.util.List;
import java.util.ServiceLoader;
import java.util.stream.Collectors;

public interface IService {
    Card doJob();

    static List<IService> getServices(ModuleLayer layer) {
        return ServiceLoader
                .load(layer, IService.class)
                .stream()
                .map(ServiceLoader.Provider::get)
                .collect(Collectors.toList());
    }
}