package bookhut.controllers;

import bookhut.models.bindingModels.AddBookModel;
import bookhut.services.BookServiceImpl;
import bookhut.services.interfaces.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddBookController extends HttpServlet {

    private BookService bookService;

    public AddBookController() {
        this.bookService = new BookServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/templates/addBook.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String add = req.getParameter("add");
        if (add != null) {
            String title = req.getParameter("title");
            String author = req.getParameter("author");
            int pages = Integer.parseInt(req.getParameter("pages"));

            AddBookModel newBook = new AddBookModel(title, author, pages);
            this.bookService.saveBook(newBook);
            req.getRequestDispatcher("/templates/addBook.jsp").forward(req, resp);
        }
    }
}
