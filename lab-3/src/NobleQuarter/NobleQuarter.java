package NobleQuarter;

import CardType.CardType;
import QuarterCard.QuarterCard;

public class NobleQuarter extends QuarterCard {
    public NobleQuarter(String name, int cost) {
        super(name, CardType.NOBLE, cost);
    }
    public NobleQuarter(){};
}
