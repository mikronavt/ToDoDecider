package ru.tododecider.model;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class Task implements Comparable<Task>{
    private String name;
    private String description;
    private int importance; //or enum?
    private int complexity; //or enum?
    private LocalDateTime dateUntil;
    private LocalDateTime dateSince;
    private LocalDateTime lockedByTime; // если указанное время не наступила, задача скипается автоматически
    private int postponed;
    private String theme; //or enum?
    private String comments;
    private Task topTask;
    private List<Task> subTasks;
    private int randomIndex;
    private Task lockedBy;// добавить логику что если задача заблокирована, то вместо нее автоматом выплывает локер
    private int priority;

    public Task(String name) {
        this.name = name;
    }

    public void updatePriority(){
        priority = 0;
    }


    @Override
    public int compareTo(Task t) {
        return Integer.compare(this.priority, t.priority);
    }
}
