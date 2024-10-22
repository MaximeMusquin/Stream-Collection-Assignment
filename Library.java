import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;

public class Library {
    private List<Book> books = new ArrayList<>();

    // Constructor to initialize the library
    public Library() {
        books = new ArrayList<>();
    }

    // Method to add books to the library
    public void addBook(Book book) {
        books.add(book);
    }

    // Method to display all books in the library
    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void populateLibrary() {
        books.add(new Book("1984", "George Orwell", 1949, 12.99, "Dystopian"));
        books.add(new Book("Brave New World", "Aldous Huxley", 1932, 13.99, "Science Fiction"));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee", 1960, 10.99, "Classic"));
        books.add(new Book("The Catcher in the Rye", "J.D. Salinger", 1951, 9.99, "Classic"));
        books.add(new Book("The Road", "Cormac McCarthy", 2006, 14.99, "Post-apocalyptic"));
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, 10.49, "Classic"));
        books.add(new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", 1997, 11.99, "Fantasy"));
        books.add(new Book("Harry Potter and the Chamber of Secrets", "J.K. Rowling", 1998, 12.99, "Fantasy"));
        books.add(new Book("The Hobbit", "J.R.R. Tolkien", 1937, 13.99, "Fantasy"));
        books.add(new Book("The Fellowship of the Ring", "J.R.R. Tolkien", 1954, 14.99, "Fantasy"));
        books.add(new Book("The Da Vinci Code", "Dan Brown", 2003, 16.99, "Thriller"));
        books.add(new Book("Angels & Demons", "Dan Brown", 2000, 15.99, "Thriller"));
        books.add(new Book("Inferno", "Dan Brown", 2013, 17.99, "Thriller"));
        books.add(new Book("Moby Dick", "Herman Melville", 1851, 9.49, "Classic"));
        books.add(new Book("Pride and Prejudice", "Jane Austen", 1813, 8.99, "Romance"));
        books.add(new Book("The Shining", "Stephen King", 1977, 15.99, "Horror"));
        books.add(new Book("Dracula", "Bram Stoker", 1897, 7.99, "Gothic"));
        books.add(new Book("Frankenstein", "Mary Shelley", 1818, 8.49, "Gothic"));
        books.add(new Book("The Hunger Games", "Suzanne Collins", 2008, 13.49, "Dystopian"));
        books.add(new Book("The Handmaid's Tale", "Margaret Atwood", 1985, 11.49, "Dystopian"));
    }

    // Search functions : To compare we use the .equalsIgnoreCase String methods, to avoid cases errors.
    public List<Book> searchByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    public List<Book> searchByYear(int year) {
        return books.stream()
                .filter(book -> book.getYearOfPublication() == year)
                .collect(Collectors.toList());
    }

    public List<Book> searchByTitle(String title) {
        return books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }

    public List<Book> searchByGenre(String genre) {
        return books.stream()
                .filter(book -> book.getGenre().equalsIgnoreCase(genre))
                .collect(Collectors.toList());
    }

    //Exercise 4:

    public double averageBookPrice() {
        return books.stream()
                .mapToDouble(Book::getPrice)  // we only keep the price in the stream, otherwise we cannot use .average
                .average()
                .orElse(0.0); //mandatory because .average give an "optional double"
    }

    public java.util.Optional<Book> mostExpensiveBook() {   //we have to use java.util.Optional as return type
        return books.stream()                               // to return one book, and not a list like previous functions
                .max(Comparator.comparingDouble(Book::getPrice));// since this functions must return 1 book only
    }

    public java.util.Optional<Book> cheapestBook() {
        return books.stream()
                .min(Comparator.comparingDouble(Book::getPrice));
    }

    public java.util.Optional<Book> oldestBook() {
        return books.stream()
                .min(Comparator.comparingInt(Book::getYearOfPublication));
    }


    public List<Book> recentBooks(int years) {
        int currentYear = 2024;
        return books.stream()
                .filter(book -> book.getYearOfPublication() >= (currentYear - years))  // Filter books published in the last 'years'
                .collect(Collectors.toList());
    }

    //Exercise 5:

    // Stream are immutable, so for this exercise, we only create temporary stream in order to print them

    public void printLibrary(){
        books.stream()
                .forEach(System.out::println);
    }
    public void printBooksSortedByTitle() {
        books.stream()
                .sorted(Comparator.comparing(Book::getTitle))
                .forEach(System.out::println);
    }

    public void printBooksSortedByAuthor() {
        books.stream()
                .sorted(Comparator.comparing(Book::getAuthor))
                .forEach(System.out::println);
    }

    public void printBooksSortedByPublicationYear() {
        books.stream()
                .sorted(Comparator.comparingInt(Book::getYearOfPublication))
                .forEach(System.out::println);

    }
}

