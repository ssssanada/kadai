package task.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import task.entity.Task;

@Mapper
public interface TaskMapper {
	  List<Task> findAll();

	  Task findOne(Long id);

	  void save(Task task);

	  void update(Task task);
	  
	  void edit(Task task);

	  void delete(Long id);
}
