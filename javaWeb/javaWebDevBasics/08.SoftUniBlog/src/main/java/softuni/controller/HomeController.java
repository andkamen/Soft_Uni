package softuni.controller;

import com.mvcFramework.annotations.controller.Controller;
import com.mvcFramework.annotations.request.GetMapping;
import com.mvcFramework.models.Model;
import softuni.services.interfaces.ArticleService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.math.BigInteger;

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
        new BigInteger("0").pow(2);
        return "WEB-INF/base-layout";
    }
}
