package com.dotenv;

import io.github.cdimascio.dotenv.Dotenv;

public class DotEnvDemo {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load();

        // Access environment variables
        String dbUrl = dotenv.get("DB_URL");
        String dbUsername = dotenv.get("DB_USERNAME");
        String dbPassword = dotenv.get("DB_PASSWORD");

        System.out.println("Database URL: " + dbUrl);
        System.out.println("Username: " + dbUsername);
        System.out.println("Password: " + dbPassword);
	}
	
	
}
