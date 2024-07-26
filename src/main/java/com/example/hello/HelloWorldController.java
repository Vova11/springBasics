package com.example.hello;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWorldController {
    private MessageSource messageSource;

    public HelloWorldController(MessageSource messageSource){
        this.messageSource = messageSource;
    }

    @GetMapping("/hello-world")
    public String helloWorld() {
        return "hello world";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        HelloWorldBean message = new HelloWorldBean("Hello world");
        return message;
    }

    @GetMapping("/hello-world-bean/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        return  new HelloWorldBean(String.format("Hello world, %s",name));
    }

    @GetMapping("/hello-world-internationalization")
    public String helloWorldInternationalized() {
        Locale locale = LocaleContextHolder.getLocale();
        Object[] args = {"Good","John"};
        return  messageSource.getMessage("good.morning.message", args, "Default", locale);
    }
    
}
