package UniqueQuarter;

import CardType.CardType;
import QuarterCard.QuarterCard;

public class UniqueQuarter extends QuarterCard {
    private String description;

    public UniqueQuarter(String name, int cost, String description) {
        super(name, CardType.UNIQUE, cost);
        this.description = description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
