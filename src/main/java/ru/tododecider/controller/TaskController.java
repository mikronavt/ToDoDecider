package ru.tododecider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    public TaskController(){

    }

    @GetMapping()
    public String index(){
        return "tasks/index";
    }
}
