package id.danielniko.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import id.danielniko.model.User;
import id.danielniko.util.DbUtil;

class UserDaoTest {
	
	private static UserDao dao;
	
	@BeforeAll
	static void init() {
		Connection conn = DbUtil.getConnection();
		try {
			// set auto commit false so any operation in this test will be discarded.
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dao = new UserDao(conn);
	}
	
	@AfterAll
	static void teardown() {
		Connection conn = DbUtil.getConnection();
		try {
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void addUserTest() {
		User user = new User();
		user.setUsername("steven");
		user.setPassword("mypass");
		user.setFullName("Steven Gerrard");
		user.setEmail("steven@example.com");
		dao.addUser(user);
		User userFromDb = dao.getUserByUsername("steven");
		assertEquals("mypass", userFromDb.getPassword(), "Password must be equals");
	}
	
	@Test
	void deleteUserTest() {
		dao.deleteUser("danielniko");
		User userFromDb = dao.getUserByUsername("danielniko");
		assertNull(userFromDb.getUsername(), "Username should be null");
	}
	
	@Test
	void updateUserTest() {
		User user = new User();
		user.setUsername("danielniko");
		user.setPassword("secret");
		user.setFullName("Daniel Niko");
		user.setEmail("danielniko@example.com");
		dao.addUser(user);
		user.setPassword("verysecret");
		dao.updateUser(user);
		User userFromDb = dao.getUserByUsername("danielniko");
		assertEquals("verysecret", userFromDb.getPassword(), "Updated password must be equal.");
	}

}
