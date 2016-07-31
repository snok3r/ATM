package com;

import com.atm.IATM;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

        IATM atm = context.getBean("myATM", IATM.class);

        ((ClassPathXmlApplicationContext) context).close();
    }
}