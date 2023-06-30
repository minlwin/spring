package com.jdc.demo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderTest {

	public static void main(String[] args) {
		
		var encoder = new BCryptPasswordEncoder();
		
		System.out.println(encoder.encode("Admin"));
		System.out.println(encoder.encode("Admin"));
		System.out.println(encoder.encode("Admin"));
		System.out.println(encoder.encode("Member"));
		
		System.out.println(encoder.matches("Admin", "$2a$10$oXE.lfp2mdzcYBdyZdyHkOI4yK4RvsEVEvm1r9xij8GissVsOpj7S"));
	}
}
