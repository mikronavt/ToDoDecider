package ru.tododecider;

import java.time.LocalDateTime;
import java.util.List;

public class Task implements Comparable<Task>{
    private String name;
    private String description;
    private int importance; //or enum?
    private int complexity; //or enum?
    private LocalDateTime dateUntil;
    private LocalDateTime dateSince;
    private int postponed;
    private String theme; //or enum?
    private String comments;
    private List<Task> subTasks;
    private int randomIndex;
    private int priority;

    public void updatePriority(){
        priority = 0;
    }


    @Override
    public int compareTo(Task t) {
        return this.priority - t.priority;
    }
}
