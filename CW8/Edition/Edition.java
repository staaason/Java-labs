package Edition;

public interface Edition {
    public int getPrintings();
    public void setPrintings(int n);
    public String getTitle();
    public void setTitle(String title);
    public String getAuthors();
    public void setAuthors(String authors);
    public double getPrice();
    public void setPrice(double price);
}
