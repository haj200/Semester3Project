package beans;

public class User {
	
	private String username;
    private String typeUser;

    public User(String username, String typeUser) {
        this.username = username;
        this.typeUser = typeUser;
    }

    public String getUsername() {
        return username;
    }

    public String getTypeUser() {
        return typeUser;
    }

    

}
