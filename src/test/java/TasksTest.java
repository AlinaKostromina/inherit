import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TasksTest {


    // SimpleTask tests
    @Test
    public void shouldReturnTrueTestingSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(1, "Накормить кота");

        Boolean expected = true;
        Boolean actual = simpleTask.matches("Накормить кота");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnFalseTestingSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить маме");

        Boolean expected = false;
        Boolean actual = simpleTask.matches( "Накормить кота");

        Assertions.assertEquals(expected, actual);
    }

    // Epic tests
    @Test
    public void shouldReturnTrueTestingEpic() {
        String[] subtasks = { "Помыть посуду", "Почитать английский", "Полить цветы" };
        Epic epic = new Epic(2, subtasks);
//        epic.getSubtasks(); // проверка массива

        Boolean expected = true;
        Boolean actual = epic.matches("Помыть посуду");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnFalseTestingEpic() {
        String[] subtasks = { "Помыть посуду", "Почитать английский", "Полить цветы" };
        Epic epic = new Epic(2, subtasks);
        epic.getSubtasks();

        Boolean expected = false;
        Boolean actual = epic.matches("Сходить в магазин");

        Assertions.assertEquals(expected, actual);
    }

    // Meeting tests
    @Test
    public void shouldReturnTrueTestingMeetingTopic() {
        Meeting meeting = new Meeting(4, "Современные тенденции", "Мода", "01.11.2023");

        Boolean expected = true;
        Boolean actual = meeting.matches( "Современные тенденции");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnTrueTestingMeetingProject() {
        Meeting meeting = new Meeting(4, "Современные тенденции", "Мода", "01.11.2023");

        Boolean expected = true;
        Boolean actual = meeting.matches( "Мода");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnFalseTestingMeetingTopic() {
        Meeting meeting = new Meeting(4, "Современные тенденции", "Мода", "01.11.2023");

        Boolean expected = false;
        Boolean actual = meeting.matches( "Геополитика современности");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnFalseTestingMeetingProject() {
        Meeting meeting = new Meeting(4, "Современные тенденции", "Мода", "01.11.2023");

        Boolean expected = false;
        Boolean actual = meeting.matches( "Искусство");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCheckMatchesInEpicClass() {
        String[] subtasks = { "Почитать", "Порисовать", "Поиграть" };
        Epic epic = new Epic(45, subtasks);

        Boolean expected = false;
        Boolean actual = epic.matches("Петь");

        Assertions.assertEquals(expected, actual);
    }

}
