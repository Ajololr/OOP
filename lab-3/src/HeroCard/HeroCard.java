package HeroCard;

import Card.Card;
import CardType.CardType;

public class HeroCard extends Card {
    private int termValue;
    private String skillDescription;

    public HeroCard(String name, CardType type, int termValue, String skillDescription) {
        super(name, type);
        setTermValue(termValue);
        setSkillDescription(skillDescription);
    }

    public void setTermValue(int termValue) {
        this.termValue = termValue;
    }

    public int getTermValue() {
        return this.termValue;
    }

    public String getSkillDescription() {
        return skillDescription;
    }

    public void setSkillDescription(String skillDescription) {
        this.skillDescription = skillDescription;
    }
}
