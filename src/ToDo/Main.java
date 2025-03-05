package ToDo;

import java.io.File;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaDeTarefas list = new ListaDeTarefas();
        boolean jsonExiste;
        int operação;
        String escolha, jsonPath;
        jsonPath = System.getProperty("user.home") + "\\tarefas.json";
        File jsonFile = new File(jsonPath);

        while(true) {
            System.out.println("Olá! Bem-vindo ao Task Now\n\n" +
                    "Selecione a opção desejada:\n\n" +
                    "1. Adicionar uma tarefa\n" +
                    "2. Atualizar uma tarefa\n" +
                    "3. Remover uma tarefa\n" +
                    "4. Listar tarefas\n"
            );

            operação = sc.nextInt();

            // Verifica se o arquivo json ja existe
            jsonExiste = jsonFile.exists();

            switch (operação) {
                case 1:
                    /*
                    * Criar uma nova task
                    * Adicionar as informações dessa Task
                    * Adicioná-la a lista de tarefas
                    * Salvar as tarefas em um arquivo .json
                    */
                    if(!jsonExiste) {
                        list.add(0);
                    }
                    else {
                        /*
                            json ja existe, entao a rotina precisa levar em conta a estrutura
                            que ja esta presente no json
                        */
                        int index = list.getIndex();
                        list.add(index + 1);
                        list.setIndex(0);
                    }
                    list.salvarJson(jsonExiste);
                    break;
                case 2:
                    // Atualiza uma task
                    break;
                case 3:
                    // Remove uma task
                    break;
                case 4:
                    if (jsonExiste) {
                        System.out.println(list.getExistingTasks());
                    } else {
                        System.out.println("Nenhuma tarefa encontrada!");
                    }
                    break;
                default:
                    System.out.println("Opção inválida!");
                    continue;
            }

            // Consumindo o caractere do enter
            sc.nextLine();
            // Verificando se o usuario deseja continuar a utilizar o programa
            System.out.println("Deseja continuar?" +
                    "(S)im");
            escolha = sc.nextLine();
            if (!Objects.equals(escolha.toLowerCase(), "sim") && !Objects.equals(escolha.toLowerCase(), "s")) {
                System.out.println("Parando o programa...");
                break;
            }
        }
    }
}