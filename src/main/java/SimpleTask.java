public class SimpleTask extends Task {
    private String title;

    public SimpleTask(int id, String title) {
        super(id); // наследование от класса Task
        this.title = title; // свое поле
    }

    @Override
    public boolean matches(String query) {
        if (title.contains(query)) {
            return true;
        } else {
            return false;
        }
    }
}
