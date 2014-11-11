package com.phosphene.rest.view;


public class Session {

    private String email;
    private String password;
    private Long user;
    private String id;


    public Session() {
        super();
    }

    public Session(String email, String id) {
        this.email = email;
        this.id = id;
    }
    
    public Session(Long user, String id) {
        this.user = user;
        this.id = id;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
   
    public void setUser(Long user) {
        this.user = user;

    }

    public Long getUser() {
        return user;
    }
}
