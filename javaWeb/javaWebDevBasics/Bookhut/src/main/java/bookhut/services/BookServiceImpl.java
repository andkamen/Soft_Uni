package bookhut.services;

import bookhut.entities.Book;
import bookhut.models.bindingModels.AddBookModel;
import bookhut.models.viewModels.ViewBookModel;
import bookhut.repositories.BookRepositoryImpl;
import bookhut.repositories.interfaces.BookRepository;
import bookhut.services.interfaces.BookService;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    private ModelMapper modelMapper;

    public BookServiceImpl() {
        this.bookRepository = BookRepositoryImpl.getInstance();
        this.modelMapper = new ModelMapper();
    }

    @Override
    public void saveBook(AddBookModel addBookModel) {
        Book newBook = this.modelMapper.map(addBookModel, Book.class);
        this.bookRepository.saveBook(newBook);
    }

    @Override
    public List<ViewBookModel> getAllBooks() {
        List<ViewBookModel> bookModels = new ArrayList<>();

        for (Book book : this.bookRepository.getAllBooks()) {
            ViewBookModel newBook = this.modelMapper.map(book, ViewBookModel.class);
            bookModels.add(newBook);
        }

        return bookModels;
    }

    @Override
    public ViewBookModel findBookByTitle(String title) {

        Book book = this.bookRepository.findBookByTitle(title);

        ViewBookModel foundBook = this.modelMapper.map(book, ViewBookModel.class);

        return foundBook;
    }

    @Override
    public void deleteBookByTitle(String title) {
        this.bookRepository.deleteBookByTitle(title);
    }
}
