package NewCard;

//import Card.Card;
import Card.Card;
import sample.CardController;
import sample.IService;

public class NewCard extends Card implements IService {
    private String Name;
    private int Cost;

    @Override
    public Card doJob(){
        System.out.println("New card");
        return null;
    }

    @Override
    public void setEditFields(CardController controller) {

    }

//    @Override
//    public void setEditFields(CardController controller) {
//        System.out.println("1");
//    }
}
