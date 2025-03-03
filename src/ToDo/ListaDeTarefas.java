package ToDo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ListaDeTarefas {
    private List<Task> taskList;
    public ListaDeTarefas() {
        this.taskList = new ArrayList<>();
    }

    public void add () {
        Task newTask = new Task();
        Scanner sc = new Scanner(System.in);
        String descricao;
        System.out.println("Forneça uma breve descrição para essa tarefa:");
        descricao = sc.nextLine();
        newTask.setDESCRICAO(descricao);
        taskList.add(newTask);
        System.out.println("Tarefa adicionada com sucesso!");
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

    public String getTasks() {
        StringBuilder tasks = new StringBuilder("");
        String userHomeFolder = System.getProperty("user.home");
        String desktopPath = userHomeFolder + "\\Desktop\\tarefas.json";

        try(Scanner sc = new Scanner("desktopPath")) {
            while(sc.hasNextLine()) {
                tasks.append(sc.nextLine());
            }
        } catch (InputMismatchException e) {
            System.out.println("Erro: " + e.getMessage());
            e.printStackTrace();
        }

        return tasks.toString();
    }


}
