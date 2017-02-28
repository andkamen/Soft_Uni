package softuni.services;

import softuni.Utils.ModelParser;
import softuni.entities.Article;
import softuni.entities.User;
import softuni.models.bindingModels.ArticleCreateModel;
import softuni.models.viewModels.ArticleContentModel;
import softuni.models.viewModels.ArticleSummaryModel;
import softuni.repositories.interfaces.ArticleRepository;
import softuni.repositories.interfaces.UserRepository;
import softuni.services.interfaces.ArticleService;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Local(ArticleService.class)
public class ArticleServiceImpl implements ArticleService {

    @Inject
    private ModelParser modelParser;

    @Inject
    private UserRepository userRepository;

    @Inject
    private ArticleRepository articleRepository;

    @Override
    public void persist(ArticleCreateModel articleCreateModel, Long authorId) {
        Article newArticle = this.modelParser.getModelMapper().map(articleCreateModel, Article.class);
        User author = this.userRepository.getUserById(authorId);

        newArticle.setAuthor(author);
        this.articleRepository.persist(newArticle);
    }

    @Override
    public List<ArticleSummaryModel> getAllArticles() {
        List<Article> articles = this.articleRepository.getAllArticles();

        List<ArticleSummaryModel> articleViews = new ArrayList<>();

        for (Article article : articles) {
            ArticleSummaryModel articleSummaryModel = this.modelParser.getModelMapper().map(article, ArticleSummaryModel.class);

            String articleContent = article.getContent();
            String summary = articleContent.substring(0, articleContent.length() > 500 ? 500 : articleContent.length());
            articleSummaryModel.setSummary(summary + (articleContent.length() > 500 ? "..." : ""));
            articleViews.add(articleSummaryModel);
        }

        return articleViews;
    }

    @Override
    public ArticleContentModel getArticleById(Long id) {

        Article article = this.articleRepository.getArticleById(id);

        ArticleContentModel articleContentModel = this.modelParser.getModelMapper().map(article, ArticleContentModel.class);

        return articleContentModel;
    }

    @Override
    public void updateArticle(ArticleContentModel articleContentModel) {
        Article article = this.modelParser.getModelMapper().map(articleContentModel, Article.class);

        this.articleRepository.updateArticle(article);
    }

    @Override
    public void deleteArticleById(Long id) {
       this.articleRepository.deleteArticleById(id);
    }
}
