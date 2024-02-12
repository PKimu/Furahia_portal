package com.faa;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPass = "editor";
		String encdodedPass = encoder.encode(rawPass);
		System.out.println(encdodedPass);
	}

}
