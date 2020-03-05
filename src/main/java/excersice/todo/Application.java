package excersice.todo;
import excersice.todo.entities.Todo;
import excersice.todo.presentation.ITodoClient;
import excersice.todo.presentation.TodoClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {
    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = SpringApplication.run(Application.class, args);
        ITodoClient client = applicationContext.getBean(TodoClient.class);

        Todo todo = client.GetById(1);
        if(todo != null) {
            System.out.println(todo.getTitle());
        }
        System.out.println("End of program");
    }
}

