package softuni.controller;

import com.mvcFramework.annotations.controller.Controller;
import com.mvcFramework.annotations.request.GetMapping;
import com.mvcFramework.models.Model;
import softuni.services.interfaces.ArticleService;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
@Controller
public class HomeController {

    @Inject
    private ArticleService articleService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("articles", this.articleService.getAllArticles());
        model.addAttribute("title", "Softuni Blog");
        model.addAttribute("view", "home/index.jsp");

        return "WEB-INF/base-layout";
    }
}
