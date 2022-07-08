package app.model;

import app.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Создаем класс и реализуем в нем шаблон Singleton, чтобы наш список пользователей
 * был общим для всех сервлетов.
 */
public class Model {

    private static Model instance = new Model();

    /*
    Создаем приватный список пользователей и реализуем два метода:
    один для добавления пользователей, а второй
    для возврата списка имен пользователей.
     */
    private List<User> model;

    public static Model getInstance() {
        return instance;
    }

    private Model() {
        model = new ArrayList<>();
    }

    public void add(User user) {
        model.add(user);
    }

    /*
    Метод получает потоком имена пользователей из листа типа User и заполняет
     ими лист типа String.
     */
    public List<String> list() {
        return model.stream()
                .map(User::getName)
                .collect(Collectors.toList());
    }
}
