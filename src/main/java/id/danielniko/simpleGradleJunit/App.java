package id.danielniko.simpleGradleJunit;

import id.danielniko.dao.UserDao;
import id.danielniko.model.User;

public class App {

    public static void main(String[] args) {
    	UserDao dao = new UserDao();
    	// Add new user
    	User user = new User();
    	user.setUsername("luiz");
    	user.setPassword("secret");
    	user.setFullName("Luiz Suarez");
    	user.setEmail("luiz@example.com");
    	// Update user
    	dao.addUser(user);
    	user.setPassword("verysecret");
    	dao.updateUser(user);
    	System.out.println(dao.getAllUsers());
    	
    }
    
}
