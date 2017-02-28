package bookhut.controllers;

import bookhut.models.bindingModels.AddBookModel;
import bookhut.models.viewModels.ViewBookModel;
import bookhut.services.BookServiceImpl;
import bookhut.services.interfaces.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

@WebServlet("/shelves/edit/*")
public class EditBookController extends HttpServlet {

    private BookService bookService;

    public EditBookController() {
        this.bookService = new BookServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] tokens = req.getRequestURI().split("/");
        String title = URLDecoder.decode(tokens[3], "UTF-8");
        ViewBookModel viewBookModel = this.bookService.findBookByTitle(title);

        if (viewBookModel != null) {
            req.setAttribute("book", viewBookModel);
            req.getRequestDispatcher("/templates/editBook.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String edit = req.getParameter("edit");
        if (edit != null) {
            String title = req.getParameter("title");
            String author = req.getParameter("author");
            int pages = Integer.parseInt(req.getParameter("pages"));

            AddBookModel editedBook = new AddBookModel(title, author, pages);
            this.bookService.saveBook(editedBook);

            resp.sendRedirect("/shelves");
        }
    }
}
