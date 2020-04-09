package MilitaryQuarter;

import CardType.CardType;
import QuarterCard.QuarterCard;

public class MilitaryQuarter extends QuarterCard {
    public MilitaryQuarter(String name, int cost) {
        super(name, CardType.MILITARY, cost);
    }
}
