package excersice.todo.facades;

import com.fasterxml.jackson.databind.ObjectMapper;
import excersice.todo.entities.Todo;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class TodoFacade implements ITodoFacade{
    private final String  _todoBaseUrl ="https://jsonplaceholder.typicode.com/todos/";
    ObjectMapper _objectMapper = new ObjectMapper();

    public Todo GetTodoById(int id) {
        String url = _todoBaseUrl + id;
        HttpGet request = new HttpGet(url);

        try {
            try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
                try (CloseableHttpResponse response = httpClient.execute(request)) {

                    int statusCode = response.getStatusLine().getStatusCode();
                    if(statusCode != 200) {
                        System.out.println("Failed to get todo with id" + id);
                        return null;
                    }

                    HttpEntity entity = response.getEntity();
                    if (entity != null) {
                        String result = EntityUtils.toString(entity);
                        System.out.println("result is " + result);
                        Todo obj = _objectMapper.readValue(result,Todo.class);
                        return obj;
                    }

                    return null;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to get todo with id" + id + " due to: " + e.getMessage());
        }
        return null;
    }
}
