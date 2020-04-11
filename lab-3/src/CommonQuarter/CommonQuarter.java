package CommonQuarter;

import CardType.CardType;
import QuarterCard.QuarterCard;

public class CommonQuarter extends QuarterCard {
    public CommonQuarter(String name, int cost) {
        super(name, CardType.COMMON, cost);
    }
    public CommonQuarter(){};
}
