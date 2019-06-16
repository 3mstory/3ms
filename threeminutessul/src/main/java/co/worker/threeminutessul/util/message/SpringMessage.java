package co.worker.threeminutessul.util.message;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

public class SpringMessage {
	
	@Autowired 
	private static SessionLocaleResolver localeResolver; 
	
	/*
	public static String getMessage(String code) {
		String result = "";
		result = messageSource.getMessage(code, null, LocaleContextHolder.getLocale());
		return result;
	}*/

}
