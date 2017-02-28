package bookhut.repositories;

import bookhut.entities.Book;
import bookhut.repositories.interfaces.BookRepository;

import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImpl implements BookRepository {

    private static BookRepositoryImpl bookRepository;

    private List<Book> books;

    private BookRepositoryImpl() {
        this.books = new ArrayList<>();
    }

    public static BookRepository getInstance() {
        if (bookRepository == null) {
            bookRepository = new BookRepositoryImpl();
        }

        return bookRepository;
    }

    @Override
    public void saveBook(Book book) {
        this.books.add(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return this.books;
    }

    @Override
    public void deleteBookByTitle(String title) {
        for (int i = 0; i < books.size(); i++) {
            if (title.equals(books.get(i).getTitle())) {
                books.remove(i);
                return;
            }
        }
    }

    @Override
    public Book findBookByTitle(String title) {
        Book foundBook = null;

        for (Book book : books) {
            if(title.equals(book.getTitle())){
                foundBook = book;
            }
        }

        return foundBook;
    }
}
