package softuni.controller;

import com.mvcFramework.annotations.controller.Controller;
import com.mvcFramework.annotations.parameters.ModelAttribute;
import com.mvcFramework.annotations.parameters.PathVariable;
import com.mvcFramework.annotations.request.GetMapping;
import com.mvcFramework.annotations.request.PostMapping;
import com.mvcFramework.models.Model;
import softuni.Utils.Constants;
import softuni.models.bindingModels.ArticleCreateModel;
import softuni.models.viewModels.ArticleContentModel;
import softuni.models.viewModels.LoggedUserDataModel;
import softuni.services.interfaces.ArticleService;
import softuni.services.interfaces.UserService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Controller
public class ArticleController {

    @Inject
    private ArticleService articleService;

    @Inject
    private UserService userService;

    @GetMapping("/articles/create")
    public String getCreateArticleView(Model model, HttpSession session) {

        if (session.getAttribute(Constants.LOGGED_IN_USER) == null) {
            return "redirect:/";
        }

        model.addAttribute("title", "Create Article");
        model.addAttribute("view", "article/create.jsp");

        return "WEB-INF/base-layout";
    }

    @PostMapping("/articles/create")
    public String createArticle(@ModelAttribute ArticleCreateModel articleCreateModel, Model model, HttpSession session) {

        if (session.getAttribute(Constants.LOGGED_IN_USER) == null) {
            return "redirect:/";
        }

        List<String> errors = new ArrayList<>();

        String title = articleCreateModel.getTitle();
        String content = articleCreateModel.getContent();

        validateTitle(errors, title);
        validateContent(errors, content);

        if (errors.size() == 0) {
            LoggedUserDataModel loggedUser = (LoggedUserDataModel) session.getAttribute(Constants.LOGGED_IN_USER);
            this.articleService.persist(articleCreateModel, loggedUser.getId());
            System.out.printf("");
            return "redirect:/";
        } else {
            model.addAttribute("errors", errors);
            model.addAttribute("title", "Create Article");
            model.addAttribute("view", "article/create.jsp");

            return "WEB-INF/base-layout";
        }
    }

    @GetMapping("/articles/delete/{id}")
    public String getDeleteEntireArticleView(@PathVariable("id") String path, Model model, HttpSession session) {
        if (session.getAttribute(Constants.LOGGED_IN_USER) == null) {
            return "redirect:/";
        }

        ArticleContentModel articleContentModel = this.articleService.getArticleById(Long.parseLong(path));

        model.addAttribute("article", articleContentModel);
        model.addAttribute("title", "Article");
        model.addAttribute("view", "article/delete.jsp");

        return "WEB-INF/base-layout";
    }


    @PostMapping("/articles/delete/{id}")
    public String deleteArticle(@PathVariable("id") String path, Model model, HttpSession session) {
        if (session.getAttribute(Constants.LOGGED_IN_USER) == null) {
            return "redirect:/";
        }

        List<String> errors = new ArrayList<>();

        ArticleContentModel articleContentModel = this.articleService.getArticleById(Long.parseLong(path));
        LoggedUserDataModel loggedUser = (LoggedUserDataModel) session.getAttribute(Constants.LOGGED_IN_USER);

        if (!articleContentModel.getAuthor().getId().equals(loggedUser.getId())) {
            errors.add("You can't delete an article that you didn't write");
        }

        if (errors.size() == 0) {
            this.articleService.deleteArticleById(Long.parseLong(path));

            return "redirect:/";
        } else {
            model.addAttribute("errors", errors);
            model.addAttribute("article", articleContentModel);
            model.addAttribute("title", "Article");
            model.addAttribute("view", "article/delete.jsp");

            return "WEB-INF/base-layout";
        }
    }

    @GetMapping("/articles/edit/{id}")
    public String getEditEntireArticleView(@PathVariable("id") String path, Model model, HttpSession session) {
        if (session.getAttribute(Constants.LOGGED_IN_USER) == null) {
            return "redirect:/";
        }

        ArticleContentModel articleContentModel = this.articleService.getArticleById(Long.parseLong(path));

        model.addAttribute("article", articleContentModel);
        model.addAttribute("title", "Article");
        model.addAttribute("view", "article/edit.jsp");

        return "WEB-INF/base-layout";
    }

    @PostMapping("/articles/edit/{id}")
    public String editEntireArticle(@PathVariable("id") String path, @ModelAttribute ArticleCreateModel articleCreateModel, Model model, HttpSession session) {

        if (session.getAttribute(Constants.LOGGED_IN_USER) == null) {
            return "redirect:/";
        }

        List<String> errors = new ArrayList<>();
        ArticleContentModel articleToUpdate = this.articleService.getArticleById(Long.parseLong(path));

        String title = articleCreateModel.getTitle();
        String content = articleCreateModel.getContent();

        validateTitle(errors, title);
        validateContent(errors, content);

        LoggedUserDataModel loggedUser = (LoggedUserDataModel) session.getAttribute(Constants.LOGGED_IN_USER);

        if (!articleToUpdate.getAuthor().getId().equals(loggedUser.getId())) {
            errors.add("You can't edit an article that you didn't write");
        }

        if (errors.size() == 0) {
            articleToUpdate.setContent(content);
            articleToUpdate.setTitle(title);

            this.articleService.updateArticle(articleToUpdate);

            return "redirect:/articles/" + path;
        } else {

            model.addAttribute("errors", errors);
            model.addAttribute("article", articleToUpdate);
            model.addAttribute("title", "Edit Article");
            model.addAttribute("view", "article/edit.jsp");

            return "WEB-INF/base-layout";
        }
    }

    @GetMapping("/articles/{id}")
    public String getEntireArticleView(@PathVariable("id") String path, Model model) {

       ArticleContentModel articleContentModel = this.articleService.getArticleById(Long.parseLong(path));

        model.addAttribute("article", articleContentModel);
        model.addAttribute("title", "Article");
        model.addAttribute("view", "article/details.jsp");

        return "WEB-INF/base-layout";
    }


    private void validateContent(List<String> errors, String content) {
        if (content == null) {
            errors.add("Content field must not be empty");
        } else if (content.length() < 50) {
            errors.add("Content must be at least 50 characters long");
        }
    }

    private void validateTitle(List<String> errors, String title) {
        if (title == null) {
            errors.add("Title field must not be empty");
        } else if (title.length() < 30) {
            errors.add("Title must be at least 30 characters long");
        }
    }
}
