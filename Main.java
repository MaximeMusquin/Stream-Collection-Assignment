public class Main {
    public static void main(String[] args) {

        //creation of the Library and adding books to it:
        Library lb = new Library();
        lb.populateLibrary();

        // Exercise 3:

        System.out.println("Exercise 3 : Searching The library :\n");
        System.out.println("1. searchByAuthor : we will Search for J.K. Rowling :\n");
        lb.searchByAuthor("J.K. Rowling").forEach(System.out::println);
        System.out.println("\n" +
                "2. searchByYear : Let's find every books published in 1949 : \n");
        lb.searchByYear(1949).forEach(System.out::println);
        System.out.println("\n" +
                "3. searchByTitle : We look for the book : Brave New World :\n");
        lb.searchByTitle("Brave New World").forEach(System.out::println);
        System.out.println("\n" +
                "4. searchByGenre: Every books from the Thriller genre :");
        lb.searchByGenre("Thriller").forEach(System.out::println);


        //Exercise 4:

        System.out.println("What is the average price of the book : \n"+ lb.averageBookPrice()+"\n");
        System.out.println("The most expensive book is : \n"+ lb.mostExpensiveBook()+ "\n");
        System.out.println("The cheapest book is : \n"+ lb.oldestBook()+"\n");
        System.out.println("The books which came out in the last 20 years : \n" + lb.recentBooks(20)+ "\n");


        //Exercise 5:
        System.out.println("Unordered library :");
        lb.printLibrary();
        System.out.println("\nSorted by title library :");
        lb.printBooksSortedByTitle();
        System.out.println("\nSorted by Author library :");
        lb.printBooksSortedByAuthor();
        System.out.println("\n Sorted by Year of publication library :");
        lb.printBooksSortedByPublicationYear();
    }
}
