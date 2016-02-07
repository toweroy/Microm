package com.toweroy.microm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Task item POJO
 */
public class TaskItem {
    private Date inserted;
    private Date updated;
    private String name;
    private String description;
    private List<TaskTag> tags;
    private int timeSpent;

    public TaskItem(TaskItemBuilder builder) {
        this.inserted = builder.inserted;
        this.updated = builder.updated;
        this.name = builder.name;
        this.description = builder.description;
        this.tags = builder.tags;
        this.timeSpent = builder.timeSpent;
    }

    public Date getInserted() {
        return inserted;
    }

    public Date getUpdated() {
        return updated;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<TaskTag> getTags() {
        return tags;
    }

    public int getTimeSpent() {
        return timeSpent;
    }

    public static class TaskItemBuilder {
        private Date inserted;
        private Date updated;
        private String name;
        private String description;
        private List<TaskTag> tags;
        private int timeSpent;

        public TaskItemBuilder(Date inserted, String name, String description, int timeSpent) {
            this.inserted = inserted;
            this.updated = inserted;
            this.name = name;
            this.description = description;
            this.tags = new ArrayList<>();
            this.timeSpent = timeSpent;
        }

        public TaskItemBuilder updated(Date updated) {
            this.updated = updated;
            return this;
        }

        public TaskItemBuilder tags(List<TaskTag> tags) {
            this.tags = tags;
            return this;
        }

        public TaskItemBuilder tags(TaskTag ...tags) {
            this.tags = Arrays.asList(tags);
            return this;
        }

        public TaskItem build() {
            return new TaskItem(this);
        }
    }
}
