package com.pavansrivatsav.util;

import java.time.LocalTime;

public class ValidationUtil {

	public static boolean isInvalidString(String name) {
		return name == null || "".equals(name.trim()) || name != (String) name;
	}

	public static boolean isInvalidNumber(Integer number) {
		return number == null || number <= 0 || number != (Integer) number;
	}

	public static boolean isInvalidString(LocalTime time) {
		return time == null || "".equals(time) || time != (LocalTime) time;
	}
}
