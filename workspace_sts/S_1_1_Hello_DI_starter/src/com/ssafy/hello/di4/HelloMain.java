package com.ssafy.hello.di4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloMain {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/ssafy/hello/di4/applicationContext.xml");
//        HelloMessage helloMessage = (HelloMessage) context.getBean("kor");
        HelloMessage helloMessage = context.getBean("kor", HelloMessageKor.class);
//        HelloMessage helloMessage = context.getBean("eng", HelloMessageEng.class);
        
        String greeting = helloMessage.hello("여러분");
//        String greeting = helloMessage.hello("Everyone");
        
        System.out.println(greeting);
        
        System.out.println("----------------------------------------");
        
        HelloMessage kor1 = context.getBean("kor", HelloMessageKor.class);
        HelloMessage kor2 = context.getBean("kor", HelloMessageKor.class);
        System.out.println(kor1 + " ::::: " + kor2);
        
    }
    
}
