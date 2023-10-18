public class Meeting extends Task {
    private String topic; // тема обсуждения
    private String project; // название проекта, который будут обсуждать
    private String start; // дата и время старта


    public Meeting(int id, String topic, String project, String start) {
        super(id); // наследование от класса Task
        this.topic = topic; // свое поле
        this.project = project; // свое поле
        this.start = start; // свое поле
    }

    @Override
    public boolean matches(String query) {
        if (topic.contains(query)) {
            return true;
        }
        if (project.contains(query)) {
            return true;
        }
        return false;
    }
}
