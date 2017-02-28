package softuni.services.interfaces;

import softuni.models.bindingModels.ArticleCreateModel;
import softuni.models.viewModels.ArticleContentModel;
import softuni.models.viewModels.ArticleSummaryModel;

import java.util.List;

public interface ArticleService {

    void persist(ArticleCreateModel articleCreateModel, Long authorId );

    List<ArticleSummaryModel> getAllArticles();

    ArticleContentModel getArticleById(Long id);

    void updateArticle(ArticleContentModel articleContentModel);

    void deleteArticleById(Long id);

}
