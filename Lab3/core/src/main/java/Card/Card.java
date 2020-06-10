package Card;

import observer.EmptyObserver;
import observer.Observers;
import sample.CardController;

public abstract class Card {
    private String name;
    public static Observers observers = new Observers();

    public Card(String name) {
        this.name = name;
    }

    public abstract String getCardName();

    public Card(){};

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public abstract void setEditFields(CardController controller);

    public abstract void setAddFields(CardController controller);
}
