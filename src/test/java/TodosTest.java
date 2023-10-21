import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask, epic, meeting };
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    // новые добавленные тесты на проверку метода поиска
    @Test
    public void shouldCheckAndFindMatchesOfSeveralTasks() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = { "Позвонить родителям", "Заказать доставку", "Поесть" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask, epic };
        Task[] actual = todos.search("Позвонить родителям");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldCheckAndFindMatchesOfOneTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Убраться");

        String[] subtasks = { "Позвонить родителям", "Заказать доставку", "Поесть" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask };
        Task[] actual = todos.search("Убраться");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldCheckAndFindZeroMatches() {
        SimpleTask simpleTask = new SimpleTask(5, "Убраться");

        String[] subtasks = { "Позвонить родителям", "Заказать доставку", "Поесть" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { };
        Task[] actual = todos.search("Написать письмо");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddOneTaskOfSimpleTaskType() {
        SimpleTask simpleTask = new SimpleTask(46, "Записаться к врачу");

        Todos todos = new Todos();

        todos.add(simpleTask);

        Task[] expected = { simpleTask };
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddOneTaskOfEpicType() {
        String[] subtasks = { "Написать", "Поговорить", "Сходить" };
        Epic epic = new Epic(55, subtasks);

        Todos todos = new Todos();

        todos.add(epic);

        Task[] expected = { epic };
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddOneTaskOfMeetingType() {
        Meeting meeting = new Meeting(
                54,
                "Новые решения в digital",
                "Конференция Digital Brand Day",
                "11.11.2023"
        );

        Todos todos = new Todos();

        todos.add(meeting);

        Task[] expected = { meeting };
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    // SimpleTask search tests
    @Test
    public void shouldFindOneTaskIfSearchSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(3, "Полить кактус");

        String[] subtasks = { "Тетрадь", "Ручка", "Карандаш" };
        Epic epic = new Epic(43, subtasks);

        Meeting meeting = new Meeting(
                90,
                "Выкатка на прод",
                "Приложение АльфаБанка",
                "04.12.2023"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        todos.search("Полить кактус");

        Task[] expected = { simpleTask };
        Task[] actual = todos.search("Полить кактус");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindOneTaskIfSearchEpic() {
        SimpleTask simpleTask = new SimpleTask(3, "Полить кактус");

        String[] subtasks = { "Тетрадь", "Ручка", "Карандаш" };
        Epic epic = new Epic(43, subtasks);

        Meeting meeting = new Meeting(
                90,
                "Выкатка на прод",
                "Приложение АльфаБанка",
                "04.12.2023"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        todos.search("Тетрадь");

        Task[] expected = { epic };
        Task[] actual = todos.search("Тетрадь");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindOneTaskIfSearchMeeting() {
        SimpleTask simpleTask = new SimpleTask(3, "Полить кактус");

        String[] subtasks = { "Тетрадь", "Ручка", "Карандаш" };
        Epic epic = new Epic(43, subtasks);

        Meeting meeting = new Meeting(
                90,
                "Выкатка на прод",
                "Приложение АльфаБанка",
                "04.12.2023"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        todos.search("Выкатка на прод");

        Task[] expected = { meeting };
        Task[] actual = todos.search("Выкатка на прод");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldCheckMatchesInTodos() {
        SimpleTask simpleTask = new SimpleTask(3, "Полить кактус");

        String[] subtasks = { "Тетрадь", "Ручка", "Карандаш" };
        Epic epic = new Epic(43, subtasks);

        Meeting meeting = new Meeting(
                90,
                "Выкатка на прод",
                "Приложение АльфаБанка",
                "04.12.2023"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        todos.matches("Поесть");

        Boolean expected = false;
        Boolean actual = todos.matches("Поесть");;
        Assertions.assertEquals(expected, actual);
    }
}
