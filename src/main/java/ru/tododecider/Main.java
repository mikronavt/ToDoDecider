package ru.tododecider;

import ru.tododecider.model.Task;
import ru.tododecider.model.TaskDecider;

public class Main {
    public static void main(String[] args) {
        TaskDecider taskDecider = new TaskDecider();
        taskDecider.addTask(new Task("Сходить погулять"));
        System.out.println(taskDecider.getTopTask().getName());
        taskDecider.addTask(new Task("Написать или позвонить маме"));
        System.out.println(taskDecider.getTopTask().getName());
        taskDecider.postponeTopTask();
        System.out.println(taskDecider.getTopTask().getName());
        taskDecider.postponeTopTask();
        System.out.println(taskDecider.getTopTask().getName());
        taskDecider.postponeTopTask();
        System.out.println(taskDecider.getTopTask().getName());
    }
}
