package tanjim;

import java.io.Serializable;

class User implements Serializable{
    private static final long serialVersionUID = 1L;
    private String name, username, password;
    User(String name, String uname, String pw)
    {
        this.name = name;
        this.username = uname;
        this.password = pw;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

        
        
        

