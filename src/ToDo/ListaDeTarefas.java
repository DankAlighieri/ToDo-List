package ToDo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ListaDeTarefas {
    private List<Task> taskList;
    private int size = 0;
    public ListaDeTarefas() {
        this.taskList = new ArrayList<>();
    }

    public void add (int index) {
        Task newTask = new Task();
        Scanner sc = new Scanner(System.in);
        String descricao;
        System.out.println("Forneça uma breve descrição para essa tarefa:");
        descricao = sc.nextLine();
        newTask.setDESCRICAO(descricao);
        if (index > 0) {
            newTask.setID(++index);
        }
        taskList.add(newTask);
        System.out.println("Tarefa adicionada com sucesso!");
    }

    public void rem(Task task) {
        taskList.remove(task);
    }

    public Task getTask(int index) {
        return taskList.get(index);
    }

    public int getIndex() {
        return this.size;
    }

    public void setIndex(int index) {
        this.size = index;
    }

    public void countTasks(String taskList){
        boolean inObject = false;
        for(char c : taskList.toCharArray()){
            if(c == '{') {
                inObject = true;
            } else if (c == '}' && inObject) {
                inObject = false;
                this.size++;
            }
        }
    }

    public String toJson(boolean jsonExiste) {
        StringBuilder jsonReturn;
        if (!jsonExiste) {
            jsonReturn = new StringBuilder("[\n");
        } else {
            jsonReturn = new StringBuilder("");
        }
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
        String jsonPath = System.getProperty("user.home") + "\\tarefas.json";
        File myJson = new File(jsonPath);
        if (myJson.exists()) {
            try (Scanner sc = new Scanner(myJson)) {
                while(sc.hasNextLine()) {
                    String data = sc.nextLine();
                    existingTasks.append(data).append("\n");
                }
                countTasks(existingTasks.toString());
            } catch (FileNotFoundException e) {
                System.out.println("Algo deu errado!\nErro: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return existingTasks.toString();
    }

    public void removeLastBracket() {
        String jsonPath = System.getProperty("user.home") + "\\tarefas.json";
        char charPraRemover = ']', charPraAdicionar = ',';
        try {
            // Encontra o colchete de fechamento do arquivo json
            String conteudo = new String(Files.readAllBytes(Paths.get(jsonPath)));

            // Substitui por uma virgula entre os objetos json
            int bracketIndex = conteudo.lastIndexOf(charPraRemover);

            if (bracketIndex != -1) {
                String conteudoSemBracket = conteudo.substring(0, bracketIndex) + charPraAdicionar
                        + conteudo.substring(bracketIndex + 1);
                try(FileWriter minhasTasks = new FileWriter(jsonPath)) {
                    minhasTasks.write(conteudoSemBracket);
                    minhasTasks.close();
                }
            }
/*
            // Debug
            File jsonFile = new File(jsonPath);
            Scanner sc = new Scanner(jsonFile);
            while(sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
*/
        } catch (IOException e) {
            System.out.println("Algo deu errado!\nErro: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /*
    * Encontrar uma forma melhor para diferenciar se o arquivo ja existe ou nao para evitar sobrescrever o conteudo do arquivo
    * Bug ao adicionar mais de uma tarefa
    */
    public void salvarJson(boolean jsonExiste) {
        String jsonPath = System.getProperty("user.home") + "\\tarefas.json";
        try {
            if (jsonExiste) {
               removeLastBracket();
            }
            // Abre o arquivo para escrita
            FileWriter jsonFile;
            if (this.taskList.size() > 1) {
                jsonFile = new FileWriter(jsonPath);
            } else {
                jsonFile = new FileWriter(jsonPath, true);
            }
            // Adiciona a tarefa nova ao arquivo
            jsonFile.write(this.toJson(jsonExiste));
            System.out.println("Arquivo salvo com sucesso");
            // Fecha o arquivo
            jsonFile.close();
        } catch(IOException e) {
            System.out.println("Algo deu errado!\nErro: "  + e.getMessage());
            e.printStackTrace();
        }
    }
}
