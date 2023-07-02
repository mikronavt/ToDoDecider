package ru.tododecider.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Getter
public class Task implements Comparable<Task>{
    @Setter
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
    @Setter
    private int waiting;


//    public Task(String name) {
//
//        this.name = name;
//    }

    public Task() {
        waiting = 0;
        updatePriority();
    }

    public void updatePriority(){
        priority = PriorityLogic.useWaitingInPriority().applyAsInt(waiting);
    }


    @Override
    public int compareTo(Task t) {
        return Integer.compare(this.priority, t.priority);
    }
}
