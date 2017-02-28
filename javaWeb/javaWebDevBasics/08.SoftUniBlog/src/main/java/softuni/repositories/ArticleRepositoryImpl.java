package softuni.repositories;


import softuni.entities.Article;
import softuni.repositories.interfaces.ArticleRepository;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
@Local(ArticleRepository.class)
public class ArticleRepositoryImpl implements ArticleRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void persist(Article article) {
        this.entityManager.persist(article);
    }

    @Override
    public Article getArticleById(Long id) {
        Query query = this.entityManager.createQuery("SELECT a FROM Article AS a WHERE a.id = :id");
        query.setParameter("id", id);
        List<Article> articles = query.getResultList();

        return articles.isEmpty() ? null : articles.get(0);
    }

    @Override
    public List<Article> getAllArticles() {
        Query query = this.entityManager.createQuery("SELECT a FROM Article AS a");

        List<Article> articles = query.getResultList();
        return articles;
    }

    @Override
    public void updateArticle(Article article) {
        Query query = this.entityManager.createQuery(
                "UPDATE Article AS a SET a.content =:content, a.title =:title WHERE a.id =:id");

        query.setParameter("content",article.getContent());
        query.setParameter("title",article.getTitle());
        query.setParameter("id",article.getId());

        query.executeUpdate();
    }

    @Override
    public void deleteArticleById(Long id) {

        Query query = this.entityManager.createQuery("DELETE Article as a where a.id=:id");
        query.setParameter("id",id);

        query.executeUpdate();

    }
}
