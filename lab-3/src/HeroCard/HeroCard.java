package HeroCard;

import Card.Card;
import CardType.CardType;

public class HeroCard extends Card {
    private int turnValue;
    private String skillDescription;

    public HeroCard(String name, CardType type, int turnValue, String skillDescription) {
        super(name, type);
        setTurnValue(turnValue);
        setSkillDescription(skillDescription);
    }
    public HeroCard(){};

    public void setTurnValue(int termValue) {
        this.turnValue = termValue;
    }

    public int getTurnValue() {
        return this.turnValue;
    }

    public String getSkillDescription() {
        return skillDescription;
    }

    public void setSkillDescription(String skillDescription) {
        this.skillDescription = skillDescription;
    }

    public static void setFields() {

    }
}
