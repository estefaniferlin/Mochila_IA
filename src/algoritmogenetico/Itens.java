package algoritmogenetico;

/**
 *
 * @author 20202PF.CC0011
 */
public class Itens {
    
    private String nome;
    private Double peso;
    private Double beneficio;
    
    public Itens (String nome, Double peso, Double beneficio) {
        this.nome = nome;
        this.peso = peso;
        this.beneficio = beneficio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(Double beneficio) {
        this.beneficio = beneficio;
    }
   
}
