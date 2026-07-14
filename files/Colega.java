
public class Colega {

    private int id;
    private String nome;
    private String diaLimpeza;

    public Colega() {
    }

    public Colega(String nome, String diaLimpeza) {
        this.nome = nome;
        this.diaLimpeza = diaLimpeza;
    }

    public Colega(int id, String nome, String diaLimpeza) {
    this.id = id;
    this.nome = nome;
    this.diaLimpeza = diaLimpeza;
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

    public String getDiaLimpeza() {
        return diaLimpeza;
    }

    public void setDiaLimpeza(String diaLimpeza) {
        this.diaLimpeza = diaLimpeza;
    }

    @Override
    public String toString() {
        return "#" + id + " - " + nome + " -> limpa em " + diaLimpeza;
    }
}
