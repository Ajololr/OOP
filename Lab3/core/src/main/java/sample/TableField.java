package sample;

import Card.Card;
import observer.EmptyObserver;

public class TableField {
    private Card obj;
    private int hshCode;

    public TableField(Card obj, int hshCode) {
        this.obj = obj;
        this.hshCode = hshCode;
    }

    public Card getObj() {
        return obj;
    }

    public void setObj(Card obj) {
        this.obj = obj;
    }

    public int getHshCode() {
        return hshCode;
    }

    public void setHshCode(int hshCode) {
        this.hshCode = hshCode;
    }
}
