package softuni.models.viewModels;

import softuni.entities.User;

//Used to view the article from the home page. Cuts out the stuff beyond 500 chars
public class ArticleSummaryModel {

    private Long id;

    private String title;

    private String summary;

    private User author;

    public ArticleSummaryModel() {
    }

    public ArticleSummaryModel(Long id, String title, String summary, User author) {
        this.setId(id);
        this.setTitle(title);
        this.setSummary(summary);
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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
