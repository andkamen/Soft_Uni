package softuni.models.viewModels;

public class LoggedUserDataModel {

    private Long id;

    private String email;

    private String name;

    public LoggedUserDataModel() {
    }

    public LoggedUserDataModel(Long id, String email, String name) {
        this.setId(id);
        this.setEmail(email);
        this.setName(name);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
