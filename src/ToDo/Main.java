package ToDo;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void adicionarTarefa(ListaDeTarefas lista) {
        Task newTask = new Task();
        Scanner sc = new Scanner(System.in);
        String descricao;
        System.out.println("Forneça uma breve descrição para essa tarefa:");
        descricao = sc.nextLine();
        newTask.setDESCRICAO(descricao);
        lista.add(newTask);
        System.out.println("Tarefa adicionada com sucesso!");
    }

    public static void salvarJson(ListaDeTarefas lista){
        try {
        FileWriter jsonFile = new FileWriter("C:\\Users\\jacks\\OneDrive\\Desktop\\tarefas.json");
        jsonFile.write(lista.toJson());
        System.out.println("Arquivo salvo com sucesso");
        jsonFile.close();
        } catch(IOException e) {
            System.out.println("Algo deu errado!");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaDeTarefas list = new ListaDeTarefas();
        boolean continuar = true;
        int operação;
        String escolha;

        while(continuar) {
            System.out.println("Olá! Bem-vindo ao Task Now\n\n" +
                    "Selecione a opção desejada:\n\n" +
                    "1. Adicionar uma tarefa\n" +
                    "2. Atualizar uma tarefa\n" +
                    "3. Remover uma tarefa\n" +
                    "4. Listar tarefas\n" +
                    "5. Sair\n"
            );

            operação = sc.nextInt();

            switch (operação) {
                case 1:
                    /*
                    * Criar uma nova task
                    * Adicionar as informações dessa Task
                    * Adicioná-la a lista de tarefas
                    * Salvar as tarefas em um arquivo .json
                    */
                    adicionarTarefa(list);
                    salvarJson(list);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println(list.toJson());
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opção inválida!");
                    continue;
            }

            sc.nextLine();
            System.out.println("Deseja continuar?" +
                    "(S)im");
            escolha = sc.nextLine();
            if (
                    Objects.equals(escolha.toLowerCase(), "sim") || Objects.equals(escolha.toLowerCase(), "s")) {
                continuar = true;
            } else {
                continuar = false;
            }
        }
    }
}