package ToDo;

import java.time.LocalDate;

public interface ITask {
    public String getDESCRICAO();

    public void setDESCRICAO(String DESCRICAO);

    public char getSTATUS();

    public void setSTATUS(char STATUS);

    public LocalDate getFinalizadoEm();

    public void setFinalizadoEm(LocalDate finalizadoEm);

    public LocalDate getCriadoEm();

    public int getID();

    @Override
    public String toString();
}