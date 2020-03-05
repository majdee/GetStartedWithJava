package excersice.todo.presentation;

import excersice.todo.entities.Todo;

public interface ITodoClient {
    Todo GetById(int id);
}
