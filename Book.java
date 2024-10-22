public class Book {
    public String title;
    public String author;
    public int yearOfPublication;
    public double price;
    public String genre;

    public Book(String title, String author, int yearOfPublication, double price, String genre) {
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
        this.price = price;
        this.genre = genre;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public int getYearOfPublication() { return yearOfPublication; }
    public void setYearOfPublication(int yearOfPublication) { this.yearOfPublication = yearOfPublication; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }



    @Override
    public String toString() {
        return title + "," +
                "   author : " + author +
                "   yearOfPublication :" + yearOfPublication +
                "   price : " + price +
                "   genre : " + genre +"\n";
    }
}