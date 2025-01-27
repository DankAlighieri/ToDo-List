package ToDo;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaDeTarefas list = new ListaDeTarefas();
        boolean continuar = true;
        int operação;

        while(continuar) {
            System.out.println("Olá! Bem-vindo ao Task Now\n\n" +
                    "Selecione a opção desejada:\n\n" +
                    "1. Adicionar uma tarefa\n" +
                    "2. Atualizar uma tarefa\n" +
                    "3. Remover uma tarefa\n" +
                    "4. Listar tarefas\n" +
                    "5. Sair\n");

            operação = sc.nextInt();

            switch (operação) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opção inválida!");
                    continue;
            }


            continuar = false;
        }
    }
}