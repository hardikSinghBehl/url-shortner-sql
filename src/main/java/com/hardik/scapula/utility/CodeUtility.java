package com.hardik.scapula.utility;

import net.bytebuddy.utility.RandomString;

public class CodeUtility {

	public static String generate(final String originalUrlValue) {
		return RandomString.make(8).toLowerCase();
	}

}
