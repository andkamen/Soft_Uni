package bookhut.controllers;

import bookhut.models.viewModels.ViewBookModel;
import bookhut.services.BookServiceImpl;
import bookhut.services.interfaces.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/shelves")
public class ShelfController extends HttpServlet {

    private BookService bookService;

    public ShelfController() {
        this.bookService = new BookServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ViewBookModel> viewBookModels = this.bookService.getAllBooks();
        req.setAttribute("books", viewBookModels);
        req.getRequestDispatcher("/templates/shelves.jsp").forward(req, resp);
    }

}
