package User;

public class User {
    public String name;
    public int password;
    public String role;

    public User(String name, int password, String role) {
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public int getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return role + ' ' + name;
    }
}
