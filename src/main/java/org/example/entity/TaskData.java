package org.example.entity;

import java.util.HashSet;
import java.util.Set;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = new HashSet<>(annsTasks);
        this.bobsTasks = new HashSet<>(bobsTasks);
        this.carolsTasks = new HashSet<>(carolsTasks);
        this.unassignedTasks = new HashSet<>(unassignedTasks);
    }

    public Set<Task> getTasks(String name) {
        return switch (name.toLowerCase()) {
            case "ann" -> new HashSet<>(annsTasks);
            case "bob" -> new HashSet<>(bobsTasks);
            case "carol" -> new HashSet<>(carolsTasks);
            case "all" -> getUnion(annsTasks, bobsTasks, carolsTasks, unassignedTasks);
            default -> new HashSet<>();
        };
    }

    public Set<Task> getUnion(Set<Task>... sets) {
        Set<Task> unionSet = new HashSet<>();
        for (Set<Task> set : sets) {
            unionSet.addAll(set);
        }
        return unionSet;
    }

    public Set<Task> getIntersection(Set<Task> set1, Set<Task> set2) {
        Set<Task> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        return intersection;
    }

    public Set<Task> getDifferences(Set<Task> set1, Set<Task> set2) {
        Set<Task> difference = new HashSet<>(set1);
        difference.removeAll(set2);
        return difference;
    }
}
