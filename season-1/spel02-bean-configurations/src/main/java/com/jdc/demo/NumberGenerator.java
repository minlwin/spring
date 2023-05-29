package com.jdc.demo;

import java.util.concurrent.ThreadLocalRandom;

public class NumberGenerator {

	public static int generate() {
		return ThreadLocalRandom.current().nextInt(100);
	}
}
