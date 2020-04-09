package TradeQuarter;

import CardType.CardType;
import QuarterCard.QuarterCard;

public class TradeQuarter extends QuarterCard {
    public TradeQuarter(String name, int cost) {
        super(name, CardType.TRADE, cost);
    }
}
