package QuarterCard;

import Card.Card;
import CardType.CardType;

public abstract class QuarterCard extends Card {
    private int cost;

    public QuarterCard(String name, CardType type, int cost) {
        super(name, type);
        setCost(cost);
    }

    public QuarterCard(){};

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return this.cost;
    }
}
