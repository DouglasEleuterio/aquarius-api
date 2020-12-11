package com.aquarius.aquariusapi;

import com.aquarius.aquariusapi.util.DbUtils;
import com.sun.xml.internal.ws.api.ha.StickyFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@SpringBootApplication
public class AquariusApiApplication {

    @Autowired
    private DbUtils dbUtils;

    public static void main(String[] args) {
        SpringApplication.run(AquariusApiApplication.class, args);
    }

    @Component
    public class CommandLineAppStartupRunner implements CommandLineRunner{

        @Override
        public void run (String...args) throws Exception{
            //dbUtils.realizarTesteBancoDeDados();
        }
    }
}
