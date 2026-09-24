package edu.hbuas.campustodo.model;

import java.util.Objects;

/**
 * 校园待办任务。
 */
public class Task {
    private final long id;
    private final String title;
    private final Priority priority;
    private boolean completed;

    /**
     * 创建一个默认优先级（{@link Priority#MEDIUM}）的任务。
     */
    public Task(long id, String title) {
        this(id, title, Priority.MEDIUM);
    }

    /**
     * 创建一个指定优先级的任务。
     */
    public Task(long id, String title, Priority priority) {
        if (id <= 0) {
            throw new IllegalArgumentException("任务编号必须为正数");
        }
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("任务标题不能为空");
        }
        if (priority == null) {
            throw new IllegalArgumentException("任务优先级不能为空");
        }
        this.id = id;
        this.title = title.trim();
        this.priority = priority;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Priority getPriority() {
        return priority;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void complete() {
        completed = true;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Task task)) {
            return false;
        }
        return id == task.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
