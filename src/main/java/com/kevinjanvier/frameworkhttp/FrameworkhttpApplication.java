package com.kevinjanvier.frameworkhttp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import java.util.List;

@SpringBootApplication

public class FrameworkhttpApplication {

    public static void main(String[] args) {
        SpringApplication.run(FrameworkhttpApplication.class, args);
    }

    @Bean
    TodoClient todoClient() {
        WebClient webclient = WebClient.builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .build();
        var factory = HttpServiceProxyFactory.builder(new WebClientAdapter(webclient)).build();
        return factory.createClient(TodoClient.class);
    }

//    @Bean
//    ApplicationRunner applicationRunner(TodoClient todoClient) {
//        return args -> {
//            log.info("--- Response Get Clients --- {}", todoClient.todos());
//            log.info("- || - Get to do by Id {} ", todoClient.get(1L));
//        };
//    }


}


