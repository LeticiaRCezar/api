package api.ds.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.aot.hint.transaction.annotation.Transactional;

import api.ds.models.Task;
import api.ds.models.User;
import api.ds.repositories.TaskRepository;

@Service 

public class TaskService {
    
    @Autowired 
    private TaskRepository taskRepository;
    @Autowired 
    private UserService userService;

    
}
