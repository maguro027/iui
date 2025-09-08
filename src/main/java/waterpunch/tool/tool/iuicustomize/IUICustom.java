package waterpunch.tool.tool.iuicustomize;

public class IUICustom {

    private Border border;
    private Array array;

    public IUICustom(Border border, Array array) {
        setBorder(border);
        setArray(array);
    }

    public Border getBorder() {
        return border;
    }

    private void setBorder(Border border) {
        this.border = border;
    }

    public Array getArray() {
        return array;
    }

    private void setArray(Array array) {
        this.array = array;
    }

}
