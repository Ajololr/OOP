package Card;

import CardType.CardType;

public abstract class Card {
    private String name;
    private CardType type;

    public Card(String name, CardType type) {
        setName(name);
        setType(type);
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected String getName() {
        return this.name;
    }

    protected void setType(CardType type) {
        this.type = type;
    }

    protected CardType getType() {
        return this.type;
    }
}
