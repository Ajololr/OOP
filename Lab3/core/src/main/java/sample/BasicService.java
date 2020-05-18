package sample;

import Card.Card;

public class BasicService implements IService {
    @Override
    public Card doJob() {
        System.out.println("Basic service");
        return null;
    }
}