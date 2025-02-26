package ToDo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
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

    public String getExistingTasks(){
        StringBuilder existingTasks = new StringBuilder("");
        String userHomeFolder = System.getProperty("user.home");
        String desktopPath = userHomeFolder + "\\Desktop\\tarefas.json";
        File myJson = new File(desktopPath);
        if (myJson.exists()) {
            try (Scanner sc = new Scanner(myJson)) {
                while(sc.hasNextLine()) {
                    String data = sc.nextLine();
                    existingTasks.append(data).append("\n");
                }
            } catch (FileNotFoundException e) {
                System.out.println("Algo deu errado!\nErro: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return existingTasks.toString();
    }

    public void salvarJson(){
        String userHomeFolder = System.getProperty("user.home");
        String desktopPath = userHomeFolder + "\\Desktop\\tarefas.json";
        try {
            FileWriter jsonFile = new FileWriter(desktopPath, true);
            jsonFile.write(this.toJson());
            System.out.println("Arquivo salvo com sucesso");
            jsonFile.close();
        } catch(IOException e) {
            System.out.println("Algo deu errado!\nErro: "  + e.getMessage());
            e.printStackTrace();
        }
    }
}
