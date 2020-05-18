package fool.cards;

import Card.Card;
import sample.CardController;
import sample.IService;

public class FoolCard extends Card implements IService {
    @Override
    public Card doJob() {
        return null;
    }

    @Override
    public void setEditFields(CardController controller) {

    }
}
