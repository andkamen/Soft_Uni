package softuni.repositories.interfaces;

import softuni.entities.Article;

import java.util.List;

public interface ArticleRepository {
    void persist(Article article);

    Article getArticleById(Long id);

    List<Article> getAllArticles();

    void updateArticle(Article article);

    void deleteArticleById(Long id);
}
