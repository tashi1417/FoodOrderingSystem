package com.foodorder.foodorder.entity;



import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "users")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    // @NotEmpty
    @Column(nullable = false)
    private String username;
    @Column(nullable = false, unique = true)
    // @Email(message = "{errors.invalid_email}")
    private String email;
    
    private String password;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(
        name = "user_role",
        joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName= "ID")},
        inverseJoinColumns = {@JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")}
    )

    private List<Role> roles;

    public User(User user){
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.roles = user.getRoles();
    }

    public User(){

    }

     // Builder method
     public static UserBuilder builder() {
        return new UserBuilder();
    }

    // Builder class
    public static class UserBuilder {
        private String username;
        private String email;
        private String password;
        private List<Role> roles;

        private UserBuilder() {}

        public UserBuilder username(String username) {
            this.username = username;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder roles(List<Role> roles) {
            this.roles = roles;
            return this;
        }

        public User build() {
            User user = new User();
            user.setUsername(this.username);
            user.setEmail(this.email);
            user.setPassword(this.password);
            user.setRoles(this.roles);
            return user;
        }
    }



}
