package com.poly.lab8.springstarterproject;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.time.Duration;
import java.util.Locale;

@Configuration
public class MessageConfig implements WebMvcConfigurer {
    @Bean("messageSource")
    public MessageSource getMessageSource() {
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename("classpath:i18n/layout"); //location path of basename i18n
        ms.setDefaultEncoding("UTF-8"); //to write vietnamese character easilier
        return ms;
    }
    @Bean("localeResolver")
    public LocaleResolver getLocaleResolver() {
        CookieLocaleResolver localeResolver = new CookieLocaleResolver();
        localeResolver.setCookiePath("/"); //cookie will apply for all the website
        localeResolver.setCookieMaxAge(Duration.ofDays(30)); //cookie will be exist during 30 days
        localeResolver.setDefaultLocale(new Locale("vi")); // set default language is Vietnamese
        return localeResolver;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();//is a tool to change language/region
        interceptor.setParamName("lang");//set name param is lang, such as lang?vi to change Vietnamese
        registry.addInterceptor(interceptor);
        // registry with Spring to allow this interceptor interfer(can thiệp) to process languagues
    }
}
