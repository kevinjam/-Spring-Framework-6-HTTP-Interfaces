package com.kevinjanvier.frameworkhttp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@Slf4j
public class TodoController {

    @Autowired
    private TodoClient client;

    @GetMapping(value = "/todos")
    public ResponseEntity<List<Todo>> getTodos(){
       return ResponseEntity.ok(client.todos());
    }
}
