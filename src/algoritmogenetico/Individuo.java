package algoritmogenetico;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 20202PF.CC0011
 */
public class Individuo implements Comparable<Individuo>{
    
    private List pesos = new ArrayList();
    private List beneficios = new ArrayList();
    private Double limitePeso;
    private Double notaAvaliacao;
    private Double pesoUsado;
    private int geracao;
    private List cromossomo = new ArrayList();
    
    public Individuo(List pesos, List beneficios, Double limitePeso){
        this.pesos = pesos;
        this.beneficios = beneficios;
        this.limitePeso = limitePeso;
        this.notaAvaliacao = 0.0;
        this.pesoUsado = 0.0;
        this.geracao = 0;
        
        for(int i=0; i < this.pesos.size(); i++){
            if(java.lang.Math.random() < 0.5)
                this.cromossomo.add("0");
            else
                this.cromossomo.add("1");
        }
    }
    
    public void avaliacao(){
        Double nota = 0.0;
        Double somaPesos = 0.0;
        for(int i=0; i<cromossomo.size(); i++){
            if(this.cromossomo.get(i).equals("1")){
                nota += (Double) this.beneficios.get(i);
                somaPesos += (Double) this.pesos.get(i);
            }
        }
        
        if(somaPesos > this.limitePeso){
            nota = 1.0;
        }
        
        this.notaAvaliacao = nota;
        this.pesoUsado = somaPesos;
    }
    
    public List crossover (Individuo outroIndividuo){
        int corte = (int) Math.round(Math.random() * this.cromossomo.size());
        
        List filho1 = new ArrayList<>();
        
        filho1.addAll(this.cromossomo.subList(0, corte));
        filho1.addAll(outroIndividuo.getCromossomo().subList(corte, this.cromossomo.size()));
        
        
        List filho2 = new ArrayList();
        filho2.addAll(this.cromossomo.subList(corte, this.cromossomo.size()));
        filho2.addAll(outroIndividuo.getCromossomo().subList(0, corte));
        
        List<Individuo> filhos = new ArrayList();
        filhos.add(new Individuo(this.pesos, this.beneficios, this.limitePeso));
        filhos.add(new Individuo(this.pesos, this.beneficios, this.limitePeso));
        
        filhos.get(0).setCromossomo(filho1);
        filhos.get(0).setGeracao(this.geracao+1);
        filhos.get(1).setCromossomo(filho2);
        filhos.get(1).setGeracao(this.geracao+1);
        
        return filhos;
    }
    
    public Individuo mutacao (Double taxaMutacao){
        for(int i=0; i<this.cromossomo.size(); i++){
            if(Math.random() < taxaMutacao){
                if(this.cromossomo.get(i).equals("0")){
                    this.cromossomo.set(i, "1");
                }else{
                    this.cromossomo.set(i, "0");
                }
            }
        }
        return this;
    }

    public List getPesos() {
        return pesos;
    }

    public void setPesos(List pesos) {
        this.pesos = pesos;
    }

    public List getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(List beneficios) {
        this.beneficios = beneficios;
    }

    public Double getLimitePeso() {
        return limitePeso;
    }

    public void setLimitePeso(Double limitePeso) {
        this.limitePeso = limitePeso;
    }

    public Double getNotaAvaliacao() {
        return notaAvaliacao;
    }

    public void setNotaAvaliacao(Double notaAvaliacao) {
        this.notaAvaliacao = notaAvaliacao;
    }

    public Double getPesoUsado() {
        return pesoUsado;
    }

    public void setPesoUsado(Double pesoUsado) {
        this.pesoUsado = pesoUsado;
    }

    public int getGeracao() {
        return geracao;
    }

    public void setGeracao(int geracao) {
        this.geracao = geracao;
    }

    public List getCromossomo() {
        return cromossomo;
    }

    public void setCromossomo(List cromossomo) {
        this.cromossomo = cromossomo;
    }

    @Override
    public int compareTo(Individuo o) {
        if(this.notaAvaliacao > o.getNotaAvaliacao()){
            return -1;
        }
        if(this.notaAvaliacao < o.getNotaAvaliacao()){
            return 1;
        }
        return 0;
    }
    
}
