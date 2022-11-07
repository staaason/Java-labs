package Edition;

public class Encyclopedia extends Book{
    @Override
    public String toString() {
        return "Encyclopedia{" +
                "title='" + getTitle() +'\''
                + ", authors='" + getAuthors() + '\'' +
                '}';
    }

    public Encyclopedia(String title, int printings, String authors, double price, int items) {
        super(title, printings, authors, price);
        this.items = items;
    }

    public int getItems() {
        return items;
    }

    public void setItems(int items) {
        this.items = items;
    }

    private int items;
    public Encyclopedia(String title, int n, String authors, double price) {
        super(title, n, authors, price);
    }
}
