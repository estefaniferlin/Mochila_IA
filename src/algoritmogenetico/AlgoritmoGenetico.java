package algoritmogenetico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author 20202PF.CC0011
 */
public class AlgoritmoGenetico {
    private int tamPopulacao;
    private List<Individuo> populacao = new ArrayList();
    private Individuo geracao;
    private Individuo melhorSolucao;
    
    public AlgoritmoGenetico(int tamPopulacao) {
        this.tamPopulacao = tamPopulacao;
    }
    
    public void inicializaPopulacao(List peso, List beneficio, Double limitePeso){
        for(int i=0; i<tamPopulacao; i++){
            this.populacao.add(new Individuo(peso, beneficio, limitePeso));
        }
        this.melhorSolucao = this.populacao.get(0);
    }
    
    public void melhorIndividuo(Individuo individuo){
        if(individuo.getNotaAvaliacao() > this.melhorSolucao.getNotaAvaliacao()){
            this.melhorSolucao = this.populacao.get(0);
        }
    }
 
    public void ordenaPopulacao(){
        Collections.sort(this.populacao);
    }
    
    public Double somaAvaliacoes(){
        Double soma = 0.0;
        for(Individuo individuo: this.populacao){
            soma += individuo.getNotaAvaliacao();
        }
        return soma;
    }
    
    public int selecionaPai(Double somaAvaliacao){
        int pai =- 1;
        Double valorSorteado = Math.random()* somaAvaliacao;
        Double soma = 0.0;
        int i = 0;
        while (i < this.populacao.size() && soma < valorSorteado){
            soma += this.populacao.get(i).getNotaAvaliacao();
            pai += 1;
            i += 1;
        }
        return pai;
    }
    
    public void visualizaGeracao(){
        Individuo melhor = this.populacao.get(0);
        System.out.println("Melhor Geracao: " + melhor.getGeracao()
                        + " Valor: " + melhor.getNotaAvaliacao()
                        + " Espaço: " + melhor.getPesoUsado()
                        + " Cromossomo: " + melhor.getCromossomo());
    }
    
    public List resolver (Double taxaMutacao, int numeroGeracoes, List pesos, List beneficios, Double limitePeso){
        this.inicializaPopulacao(pesos, beneficios, limitePeso);
        for(Individuo individuo: this.populacao){
            individuo.avaliacao();
        }
        this.ordenaPopulacao();
        this.visualizaGeracao();
        
        for(int geracao=20; geracao < numeroGeracoes; geracao++){
            Double somaAvaliacao = this.somaAvaliacoes();
            List<Individuo> novaPopulacao = new ArrayList();
            
            for(int i=0; i<this.populacao.size() /2; i++){
                int pai1 = this.selecionaPai(somaAvaliacao);
                int pai2 = this.selecionaPai(somaAvaliacao);
                
                List<Individuo> filhos = this.getPopulacao().get(pai1).crossover(this.getPopulacao().get(pai2));
                novaPopulacao.add(filhos.get(0).mutacao(taxaMutacao));
                novaPopulacao.add(filhos.get(1).mutacao(taxaMutacao));
            }
            
            this.setPopulacao(novaPopulacao);
            for(Individuo individuo: this.populacao){
                individuo.avaliacao();
            }
            this.ordenaPopulacao();
            this.visualizaGeracao();
            Individuo melhor = this.populacao.get(0);
            this.melhorIndividuo(melhor);
        }
        System.out.println("MELHOR SOLUÇÃO: " + this.melhorSolucao.getGeracao()
                        + " Valor: " + this.melhorSolucao.getNotaAvaliacao()
                        + " Espaço: " + this.melhorSolucao.getPesoUsado()
                        + " Cromossomo: " + this.melhorSolucao.getCromossomo());
        return this.melhorSolucao.getCromossomo();
    }
    
    public int getTamPopulacao() {
        return tamPopulacao;
    }

    public void setTamanhoPopulacao(int tamPopulacao) {
        this.tamPopulacao = tamPopulacao;
    }

    public Individuo getGeracao() {
        return geracao;
    }

    public void setGeracao(Individuo geracao) {
        this.geracao = geracao;
    }

    public Individuo getMelhorSolucao() {
        return melhorSolucao;
    }

    public void setMelhorSolucao(Individuo melhorSolucao) {
        this.melhorSolucao = melhorSolucao;
    }

    public List<Individuo> getPopulacao() {
        return populacao;
    }

    public void setPopulacao(List<Individuo> populacao) {
        this.populacao = populacao;
    }

}
