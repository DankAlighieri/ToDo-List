package ToDo;

import java.util.ArrayList;
import java.util.List;

public class ListaDeTarefas {
    private List<Task> taskList;
    public ListaDeTarefas() {
        this.taskList = new ArrayList<>();
    }

    public void add (Task task) {
        taskList.add(task);
    }

    public void rem(Task task) {
        taskList.remove(task);
    }

    public Task getTask(int index) {
        return taskList.get(index);
    }

    public String toJson() {
        StringBuilder jsonReturn = new StringBuilder("[\n");

        for (int t = 0; t < taskList.size(); t++) {
            jsonReturn.append(taskList.get(t).toString());
            if(t < taskList.size() - 1) {
                jsonReturn.append(",\n");
            }
        }
        jsonReturn.append("\n]");
        return jsonReturn.toString();
    }
}
