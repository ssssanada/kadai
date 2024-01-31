package task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import task.entity.Task;
import task.mapper.TaskMapper;

@Service
public class TaskService {
	@Autowired
	private TaskMapper taskMapper;
	
	@Transactional
	public List<Task> findAll(){
		return taskMapper.findAll();
	}
	
	  @Transactional
	  public Task findOne(Long id) {
	    return taskMapper.findOne(id);
	  }
	  
	  @Transactional
	  public void save(Task item) {
		  taskMapper.save(item);
	  }

	  @Transactional
	  public void update(Long id, Boolean status) {
		  Task task = findOne(id);
		  task.setStatus(status);
		  taskMapper.update(task);
	  }

	  @Transactional
	  public void edit(Task item) {
		  taskMapper.edit(item);
	  }
	  
	  
	  @Transactional
	  public void delete(Long id) {
		  taskMapper.delete(id);
	  }
}
