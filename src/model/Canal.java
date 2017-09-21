package model;

public class Canal {

    public static int autoIncrementoId = 0;

    private int id;
    private String nome;
    private boolean valido;

    public Canal(String nome){
        id = ++autoIncrementoId;
        this.nome = nome;
        this.valido = true;
    }

    public Canal(){
        id = ++autoIncrementoId;
        this.valido = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isValido() {
        return valido;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }
}
