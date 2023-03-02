package algoritmogenetico;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 20202PF.CC0011
 */
public class Main {

    public static void main(String[] args) {
        
        List<Itens> listaItens = new ArrayList();
        listaItens.add(new Itens("Item1", 5.0, 3.0));
        listaItens.add(new Itens("Item2", 4.0, 3.0));
        listaItens.add(new Itens("Item3", 7.0, 2.0));
        listaItens.add(new Itens("Item4", 8.0, 4.0));
        listaItens.add(new Itens("Item5", 4.0, 2.0));
        listaItens.add(new Itens("Item6", 4.0, 3.0));
        listaItens.add(new Itens("Item7", 6.0, 4.0));
        listaItens.add(new Itens("Item8", 8.0, 2.0));
        
        List pesos = new ArrayList();
        List beneficios = new ArrayList();
        List nomes = new ArrayList();
        
        for(Itens item : listaItens){
            pesos.add(item.getPeso());
            beneficios.add(item.getBeneficio());
            nomes.add(item.getNome());
        }
            
        Double limite = 3.0;
        int tamanhoPopulacao = 20;
        Double taxaMutacao = 0.01;
        int numeroGeracoes = 100;
        
        AlgoritmoGenetico ag = new AlgoritmoGenetico(tamanhoPopulacao);
        List resultado = ag.resolver(taxaMutacao, numeroGeracoes, pesos, beneficios, limite);
        for(int i=0; i < listaItens.size(); i++){
            if(resultado.get(i).equals("1")){
                System.out.println("Nome: " + listaItens.get(i).getNome());
            }
        }
    }
    
}
