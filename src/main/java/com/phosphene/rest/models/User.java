package com.phosphene.rest.models;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.NamedQuery;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.ManyToMany;
import javax.persistence.FetchType; 
import javax.persistence.CascadeType; 
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "rv_user") 
public class User extends AbstractPersistable<Long> {

    private static final long serialVersionUID = 42L;
    
    @Column(unique = true) private String email;
    @Column
        @JsonIgnore
        private String password;
    @JsonIgnore
        @ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
        private List<Role> roles = new ArrayList<Role>();

    public User() {
    }

    public User(Long id) {
        this.setId(id);
    }
        
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

}
