package Card;

import CardType.CardType;
import sample.CardController;

public abstract class Card {
    private String name;
    private CardType type;

    public Card(String name, CardType type) {
        setName(name);
        setType(type);
    }

    public Card(){};

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setType(CardType type) {
        this.type = type;
    }

    public CardType getType() {
        return this.type;
    }

    public abstract void setEditFields(CardController controller);
}
