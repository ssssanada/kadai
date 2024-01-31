package task.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;



import jakarta.validation.constraints.NotBlank;


public class Task {
	private Long id;
	
	@NotBlank(message="タスク名を記述して下さい")
	private String task;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate due;
	
	private boolean status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public LocalDate getDue() {
		return due;
	}

	public void setDue(LocalDate due) {
		this.due = due;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", task=" + task + ", date=" + due + ", status=" + status + "]";
	}
}