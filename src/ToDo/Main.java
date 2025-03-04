package ToDo;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaDeTarefas list = new ListaDeTarefas();
        boolean jsonExiste;
        int operação;
        String escolha;

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
            jsonExiste = Objects.equals(list.getExistingTasks(), "") ? false : true;

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
                        list.salvarJson();
                    }
                    else {
                        /*
                            json ja existe, entao a rotina precisa levar em conta a estrutura
                            que ja esta presente no json
                        */
                        int index = list.getIndex();
                        list.add(index + 1);
                        list.salvarJson();
                    }
                    break;
                case 2:
                    // Atualiza uma task
                    break;
                case 3:
                    // Remove uma task
                    break;
                case 4:
                    System.out.println(list.getExistingTasks());
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
            if (!Objects.equals(escolha.toLowerCase(), "sim") || !Objects.equals(escolha.toLowerCase(), "s")) {
                break;
            }
        }
    }
}