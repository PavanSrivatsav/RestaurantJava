package com.pavansrivatsav.util;

import java.time.LocalDateTime;
import java.time.LocalTime;

import com.pavansrivatsav.exception.ValidationException;

public class ValidationUtil {

	public static void isInvalidObject(Object obj, String msg) throws ValidationException {
		if (obj == null) {
			throw new ValidationException(msg);
		}
	}

	public static void isInvalidString(String name, String msg) throws ValidationException {
		if (name == null || "".equals(name.trim()) || name != (String) name) {
			throw new ValidationException(msg);
		}
	}

	public static void isInvalidNumber(Integer number, String msg) throws ValidationException {
		if (number == null || number <= 0 || number != (Integer) number) {
			throw new ValidationException(msg);
		}
	}

	public static void isInvalidTime(LocalTime time, String msg) throws ValidationException {

		if (time == null || "".equals(time) || time != (LocalTime) time) {
			throw new ValidationException(msg);
		}
	}

	public static void isValidDateTime(LocalDateTime time, String msg) throws ValidationException {
		if (time == null || "".equals(time) || time != (LocalDateTime) time) {
			throw new ValidationException(msg);
		}
	}

	public static void isValidBoolean(Boolean bol, String msg) throws ValidationException {
		if (bol == null || "".equals(bol) || bol != (Boolean) bol) {
			throw new ValidationException(msg);
		}
	}
}
