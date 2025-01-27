package ToDo;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ListaDeTarefas list = new ListaDeTarefas();
        Task task1 = new Task();
        task1.setDESCRICAO("Task 1 de teste");
        task1.setSTATUS('C');
        task1.setFinalizadoEm(LocalDate.now());

        Task task2 = new Task();
        task2.setDESCRICAO("Task 2 de teste");

        Task task3 = new Task();
        task3.setDESCRICAO("Task 3 de teste");

        list.add(task1);
        list.add(task2);
        list.add(task3);
        System.out.println(list.toJson());
    }
}