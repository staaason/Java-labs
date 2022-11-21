package Edition;

public class Dictionary extends Book{
    @Override
    public String toString() {
        return "Dictionary{" +
                "lang1='" + lang1 + '\'' +
                ", lang2='" + lang2 + '\'' +
                ", authors=" + getAuthors() + '\'' +
                ", lang2='" + getTitle() + '\'' +
                '}';
    }

    public Dictionary(String title, int printings, String authors, double price, String lang1, String lang2, int items) {
        super(title, printings, authors, price);
        this.lang1 = lang1;
        this.lang2 = lang2;
        this.items = items;
    }

    private String lang1;
    private String lang2;

    public String getLang1() {
        return lang1;
    }

    public void setLang1(String lang1) {
        this.lang1 = lang1;
    }

    public String getLang2() {
        return lang2;
    }

    public void setLang2(String lang2) {
        this.lang2 = lang2;
    }

    public int getItems() {
        return items;
    }

    public void setItems(int items) {
        this.items = items;
    }

    private int items;

    public Dictionary( String title, int n, String authors, double price) {
        super(title, n, authors, price);
    }

}
