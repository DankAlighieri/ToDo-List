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

    public void setID(int ID);
    @Override
    public String toString();
}