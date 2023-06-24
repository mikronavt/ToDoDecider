package ru.tododecider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.tododecider.model.Task;
import ru.tododecider.model.TaskDecider;

import javax.validation.Valid;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    private final TaskDecider taskDecider;
    @Autowired
    public TaskController(TaskDecider taskDecider){
        this.taskDecider = taskDecider;
    }

    @GetMapping()
    public String index(){
        return "tasks/index";
    }

    @GetMapping("/new")
    public String addNewTask(@ModelAttribute("task") Task task){
        return "tasks/new";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("task") @Valid Task task, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "tasks/new";
        }
        taskDecider.addTask(task);
        return "redirect:/tasks/top";
    }

    @GetMapping("/top")
    public String getTopTask(Model model){
        if(taskDecider.noTasks()) {
            return "redirect:/tasks";
        }
        model.addAttribute("task", taskDecider.getTopTask());
        return "tasks/top";
    }

    @PostMapping("/execute")
    public String executeTopTask(){
        taskDecider.executeTopTask();
        return "redirect:/tasks/top";
    }

    @PostMapping("/cancel")
    public String cancelTopTask(){
        taskDecider.cancelTopTask();
        return "redirect:/tasks/top";
    }

    @PostMapping("/postpone")
    public String postponeTopTask(){
        taskDecider.postponeTopTask();
        return "redirect:/tasks/top";
    }

}
