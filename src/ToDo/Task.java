package ToDo;

import java.time.LocalDate;

public class Task implements ITask {
    final private int ID;
    private static int SEQUENCIAL = 0;
    private String DESCRICAO;
    /*
    * (T)o do;
    * (D)oing;
    * (F)inished;
    */
    private char STATUS;
    final private LocalDate criadoEm;
    private LocalDate finalizadoEm;

    public Task(){
        this.ID = ++SEQUENCIAL;
        this.criadoEm = LocalDate.now();
        this.STATUS = 'N';
    }

    public String getDESCRICAO() {
        return DESCRICAO;
    }

    public void setDESCRICAO(String DESCRICAO) {
        this.DESCRICAO = DESCRICAO;
    }

    public char getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(char STATUS) {
        this.STATUS = STATUS;
    }

    public LocalDate getFinalizadoEm() {
        return finalizadoEm;
    }

    public void setFinalizadoEm(LocalDate finalizadoEm) {
        this.finalizadoEm = finalizadoEm;
    }

    public LocalDate getCriadoEm() {
        return criadoEm;
    }

    public int getID() {
        return ID;
    }

    @Override
    public String toString() {
        String jsonToString = "{\n" +
                "\"id\" : \"" + this.ID + "\",\n" +
                "\"descricao\" : \"" + this.DESCRICAO + "\",\n" +
                "\"status\" : \"" + this.STATUS + "\",\n" +
                "\"criadoEm\" : \"" + this.criadoEm + "\",\n" +
                "\"finalizadoEm\" : \"" + this.finalizadoEm + "\"\n" +
                "}";
        return jsonToString;
    }
}
