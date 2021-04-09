package id.danielniko.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

class DbUtilTest {
	
	@Test 
    void getPropertyTest() {
    	String driver = DbUtil.getProperty("driver");
    	assertEquals("com.mysql.cj.jdbc.Driver", driver, "Db driver should match");
    }

    @Test 
    void getConnectionTest() {
    	Connection dbConnection = DbUtil.getConnection();
        assertNotNull(dbConnection, "connection should be successfull.");

    }
}
