package sample;

public class TableField {
    private Object obj;
    private int hshCode;

    public TableField(Object obj, int hshCode) {
        this.obj = obj;
        this.hshCode = hshCode;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public int getHshCode() {
        return hshCode;
    }

    public void setHshCode(int hshCode) {
        this.hshCode = hshCode;
    }
}
