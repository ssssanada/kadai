package task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import task.entity.Task;
import task.service.TaskService;

@Controller
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("tasks", taskService.findAll());
//		taskService.findAll().forEach(e -> {
//			System.out.println(e.toString());
//		});
		
		return "taskIndex";
	}
	@GetMapping("/taskEdit")
	public String edit(Model model) {
		model.addAttribute("tasks", taskService.findAll());
		
		return "taskEdit";
	}

	  @GetMapping("/taskAdd")
	  public String add(Model model) {
	    model.addAttribute("task", new Task());
	    return "taskAdd";
	  }
	  
	  @PostMapping("/taskPost")
	  public String addTask(@ModelAttribute("task") @Validated Task task, BindingResult result, Model model) {
		  if (result.hasErrors()) {
			  return "taskAdd";
		  } else {
			 taskService.save(task);
			 return "redirect:/";
		  }
	  }
	  
	  
	  @PostMapping("/taskUpdate")
	  public String updateTask(Model model, @RequestParam("id") Long taskId, @RequestParam("status") Boolean isStatus, @RequestParam("page") String pageName) {
		  taskService.update(taskId, isStatus);
		  
		    if ("taskEdit".equals(pageName)) {
		        return "redirect:/taskEdit";
		    } else {
		    	return "redirect:/";
		    }
	  }

		@PostMapping("/editPost")
		public String editTask(@ModelAttribute("task") @Validated Task task, BindingResult result, Model model) {
			  if (result.hasErrors()) {
			  } else {
//				 System.out.println(task);
				 taskService.edit(task);
			  }
			  return "redirect:/taskEdit";
		  }
	
		@PostMapping("/deletePost")
		public String deleteTask(Model model, @RequestParam("id") Long taskId) {
				 taskService.delete(taskId);
				 return "redirect:/taskEdit";
		  }
}