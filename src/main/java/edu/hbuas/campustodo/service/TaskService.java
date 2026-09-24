package edu.hbuas.campustodo.service;

import edu.hbuas.campustodo.model.Priority;
import edu.hbuas.campustodo.model.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * 任务应用服务。学生将在功能分支中逐步扩展该类。
 */
public class TaskService {
    private final List<Task> tasks = new ArrayList<>();
    private long nextId = 1;

    /**
     * 新增任务，优先级默认为 {@link Priority#MEDIUM}。
     */
    public Task addTask(String title) {
        return addTask(title, Priority.MEDIUM);
    }

    /**
     * 新增指定优先级的任务。
     */
    public Task addTask(String title, Priority priority) {
        Task task = new Task(nextId++, title, priority);
        tasks.add(task);
        return task;
    }

    public List<Task> listAll() {
        return List.copyOf(tasks);
    }

    public Task completeTask(long id) {
        Task task = tasks.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("任务编号不存在: " + id));
        if (task.isCompleted()) {
            throw new IllegalStateException("任务已完成，不能重复完成: " + id);
        }
        task.complete();
        return task;
    }

    /**
     * 按优先级筛选任务；无匹配任务时返回空列表。
     */
    public List<Task> filterByPriority(Priority priority) {
        if (priority == null) {
            throw new IllegalArgumentException("筛选优先级不能为空");
        }
        return tasks.stream()
                .filter(task -> task.getPriority() == priority)
                .toList();
    }
}
