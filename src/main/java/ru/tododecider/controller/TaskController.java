package ru.tododecider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
        return "redirect:/tasks";
    }

    @GetMapping("/top")
    public String getTopTask(Model model){
        model.addAttribute("task", taskDecider.getTopTask());
        return "tasks/top";
    }


}
