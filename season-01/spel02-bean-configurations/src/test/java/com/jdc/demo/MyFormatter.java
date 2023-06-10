package com.jdc.demo;

import java.text.DecimalFormat;

public class MyFormatter {

	public static String format(int value) {
		var fmt = new DecimalFormat("#,##0");
		return fmt.format(value);
	}
}
