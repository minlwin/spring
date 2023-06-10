package com.jdc.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.unbescape.uri.UriEscape;

@SpringBootTest
class ThymeleafUtilsApplicationTests {

	@Test
	void contextLoads() {
		var uri = "http://localhost:8080/demo;#fragment=10/test?param=120";
		System.out.println("escapeUriPath");
		System.out.println(UriEscape.escapeUriPath(uri));
		System.out.println("escapeUriPathSegment");
		System.out.println(UriEscape.escapeUriPathSegment(uri));
		System.out.println("escapeUriFragmentId");
		System.out.println(UriEscape.escapeUriFragmentId(uri));
		System.out.println("escapeUriQueryParam");
		System.out.println(UriEscape.escapeUriQueryParam(uri));
	}

}
