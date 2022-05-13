package com.kevinjanvier.frameworkhttp;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;

@HttpExchange("/todos")
interface TodoClient {
    @GetExchange
    List<Todo> todos();

    @PostExchange
    Todo create(@RequestBody Todo todo);

    @GetExchange("/{todoId}")
    Todo get(@PathVariable("todoId") Long id);
}
