package mongo.rest.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "authorities")
public class Authority {
    @Id
    private String id;
    private String username;
    private String role;

    public Authority() {
    }

    public Authority(String username, String role) {
        this.username = username;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Authority{" +
                "username='" + username + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
