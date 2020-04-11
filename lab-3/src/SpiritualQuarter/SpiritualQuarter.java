package SpiritualQuarter;

import CardType.CardType;
import QuarterCard.QuarterCard;

public class SpiritualQuarter extends QuarterCard {
    public SpiritualQuarter(String name, int cost) {
        super(name, CardType.SPIRITUAL, cost);
    }
    public SpiritualQuarter(){};
}
