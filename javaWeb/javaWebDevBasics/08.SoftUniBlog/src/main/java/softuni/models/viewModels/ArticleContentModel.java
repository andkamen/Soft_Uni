package softuni.models.viewModels;

import softuni.entities.User;

//used to view entire article content.
public class ArticleContentModel {
    private Long id;

    private String title;

    private String content;

    private User author;

    public ArticleContentModel() {
    }

    public ArticleContentModel(Long id, String title, String content, User author) {
        this.setId(id);
        this.setTitle(title);
        this.setContent(content);
        this.setAuthor(author);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
