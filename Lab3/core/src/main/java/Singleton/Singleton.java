package Singleton;

public class Singleton {
    private static Singleton instance;
    private Singleton(){}
    public static Singleton getInstance(){ // #3
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}