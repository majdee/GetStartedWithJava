package excersice.todo.presentation;

import excersice.todo.entities.Todo;
import excersice.todo.facades.ITodoFacade;
import excersice.todo.facades.TodoFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoClient implements ITodoClient {
    private final ITodoFacade _facade;

    @Autowired
    public TodoClient(ITodoFacade todoFacade){
        _facade = todoFacade;
    }

    public Todo GetById(int id) {
        System.out.println("getting todo with id #"+id);
        Todo todo = _facade.GetTodoById(id);
        return todo;
    }
}
