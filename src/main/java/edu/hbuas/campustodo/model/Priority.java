package edu.hbuas.campustodo.model;

/**
 * 任务优先级，从高到低依次为 {@link #HIGH}、{@link #MEDIUM}、{@link #LOW}。
 * 新建任务时若未指定优先级，默认使用 {@link #MEDIUM}。
 */
public enum Priority {
    HIGH,
    MEDIUM,
    LOW
}
