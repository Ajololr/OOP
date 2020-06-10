package sample;

import Card.Card;
import Decorator.*;
import Serialization.Serialization;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import observer.EmptyObserver;

import java.lang.module.Configuration;
import java.lang.module.ModuleDescriptor;
import java.lang.module.ModuleFinder;
import java.lang.module.ModuleReference;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main extends Application {
    public static LinkedList<Card> cards = new LinkedList<>();
    public static LinkedList<Serialization> serializations = new LinkedList<>();
    public static LinkedList<Decorator> mods = new LinkedList<>();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("sample.fxml"));
        primaryStage.setTitle("Lab 6");
        primaryStage.setScene(new Scene(root, 450, 500));
        primaryStage.show();
    }

    private static void importSerialization(String[] args) {
        Path pluginsDir = Paths.get("D:\\University\\4 semester\\OOP\\Lab3\\core\\src\\main\\serializations");

        ModuleFinder pluginsFinder = ModuleFinder.of(pluginsDir);

        List<String> plugins = pluginsFinder
                .findAll()
                .stream()
                .map(ModuleReference::descriptor)
                .map(ModuleDescriptor::name)
                .collect(Collectors.toList());

        Configuration pluginsConfiguration = ModuleLayer
                .boot()
                .configuration()
                .resolve(pluginsFinder, ModuleFinder.of(), plugins);

        ModuleLayer layer = ModuleLayer
                .boot()
                .defineModulesWithOneLoader(pluginsConfiguration, ClassLoader.getSystemClassLoader());

        List<SerializationService> serializationServices = SerializationService.getServices(layer);
        for (SerializationService service : serializationServices) {
            serializations.add(service.getSerialisationObj());
        }
    }

    private static void importCards(String[] args) {
        Path pluginsDir = Paths.get("D:\\University\\4 semester\\OOP\\Lab3\\core\\src\\main\\plugins");

        ModuleFinder pluginsFinder = ModuleFinder.of(pluginsDir);

        List<String> plugins = pluginsFinder
                .findAll()
                .stream()
                .map(ModuleReference::descriptor)
                .map(ModuleDescriptor::name)
                .collect(Collectors.toList());

        Configuration pluginsConfiguration = ModuleLayer
                .boot()
                .configuration()
                .resolve(pluginsFinder, ModuleFinder.of(), plugins);

        ModuleLayer layer = ModuleLayer
                .boot()
                .defineModulesWithOneLoader(pluginsConfiguration, ClassLoader.getSystemClassLoader());


        List<IService> services = IService.getServices(layer);
        for (IService service : services) {
            cards.add(service.doJob());
        }
    }

    private static void importMods(String[] args) {
        Path pluginsDir = Paths.get("D:\\University\\4 semester\\OOP\\Lab3\\core\\src\\main\\mods");

        ModuleFinder pluginsFinder = ModuleFinder.of(pluginsDir);

        List<String> plugins = pluginsFinder
                .findAll()
                .stream()
                .map(ModuleReference::descriptor)
                .map(ModuleDescriptor::name)
                .collect(Collectors.toList());

        Configuration pluginsConfiguration = ModuleLayer
                .boot()
                .configuration()
                .resolve(pluginsFinder, ModuleFinder.of(), plugins);

        ModuleLayer layer = ModuleLayer
                .boot()
                .defineModulesWithOneLoader(pluginsConfiguration, ClassLoader.getSystemClassLoader());

        List<DecoratorService> decoratorServices = DecoratorService.getServices(layer);
        for (DecoratorService service : decoratorServices) {
            mods.add(service.getSerialisationObj());
        }

    }

    public static void main(String[] args) {
        importCards(args);
        importSerialization(args);
//        importMods(args);
        Card.observers.add(new EmptyObserver() {
            @Override
            public void objectCreated(Object obj) {
                System.out.println("Card created: " + obj);
            }

            @Override
            public void objectModified(Object obj) {
                System.out.println("Card changed: " + obj);
            }
        });
        launch(args);
    }
}
