package Edition;

abstract public class Book implements Edition {
    private int printings;
    private String title;
    private String authors;

    public Book(String title,int printings, String authors, double price) {
        this.printings = printings;
        this.title = title;
        this.authors = authors;
        this.price = price;
    }

    private double price;

    public int getPrintings() {
        return  printings;
    }

    public void setPrintings(int n) {
        this.printings = n;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "printings=" + printings +
                ", title='" + title + '\'' +
                ", authors='" + authors + '\'' +
                ", price=" + price +
                '}';
    }
}
