package bookhut.controllers;

import bookhut.models.bindingModels.LoginModel;
import bookhut.services.UserServiceImpl;
import bookhut.services.interfaces.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signup")
public class SignUpController extends HttpServlet {

    private UserService userService;

    public SignUpController() {
        this.userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/templates/signup.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String signup = req.getParameter("signup");
        if (signup != null) {
            String username = req.getParameter("username");
            String password = req.getParameter("password");

            LoginModel loginModel = new LoginModel(username, password);
            this.userService.createUser(loginModel);

            resp.sendRedirect("/signin");
        }

    }
}
