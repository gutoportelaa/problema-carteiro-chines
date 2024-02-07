import java.util.ArrayList;
import java.util.List;

public class TestesdeDesempenho {
    
    public static void main(String[] args) {
        
        TestesdeDesempenho testes = new TestesdeDesempenho();


        Grafo grafoEuleriano = CriarGrafoEulerianoExemplo();
        testes.Testador(grafoEuleriano, "Grafo Euleriano");

       // Grafo grafoNaoEuleriano = CriarGrafoNaoEulerianoExemplo();
        //testes.Testador(grafoNaoEuleriano, "Grafo Nao Euleriano");

       // Grafo grafoBipartido = CriarGrafoBipartidoExemplo();
        //testes.Testador(grafoBipartido, "Grafo Bipartido");
        
       // Grafo grafoArvore = CriarGrafoArvoreExemplo();
        //testes.Testador(grafoArvore, "Grafo Arvore" );

        // Outros testes ?
    }



    public void Testador(Grafo exGrafo, String TipodoGrafo){
        Algoritmos algoritmos = new Algoritmos();   // para o caso de testar somente o Dijksra
        ResolverCarteiroChines ResolverCarteiroChines = new ResolverCarteiroChines();
        Grafo grafo = exGrafo;


        System.out.println("\nTeste de Desempenho para " + TipodoGrafo + ":\n");

        System.out.println(TipodoGrafo + "original :");
        grafo.imprimirGrafo();



        long somaTempos = 0;
        int numeroExecucoes = 5;

        List<Grafo> clones = new ArrayList<>();
        for (int i = 0; i < numeroExecucoes; i++) {
        clones.add(grafo.clonarGrafo());            // metodo criado na classe grafos
        }


        for (int i = 0; i < numeroExecucoes; i++) {    // laço de desemprenho
            Grafo grafoClone = clones.get(i);

            long tempoInicial = System.nanoTime();
          //  algoritmos.AlgResolveCarteiroChines();

            ResolverCarteiroChines.AlgResolverCarteiroChines(grafoClone);
            long tempoFinal = System.nanoTime();
            long tempoExecucao = tempoFinal - tempoInicial;
           // System.out.println("Execução " + (i + 1) + ": Tempo de execução do ResolveCarteiroChines: " + tempoExecucao + " milissegundos");
           //System.out.println("Tempo de execução médio do algoritmo de Dijkstra em " + TipodoGrafo + " é(são): " + (tempoFinalDijkstra - tempoInicialDijkstra) + " milissegundos");

            somaTempos += tempoExecucao;  //somatório
        }


        // calcula e exibe a média
        long mediaTempos = somaTempos / numeroExecucoes;
        System.out.println( "\n\nTempo médio de execução do algoritmo do em " + TipodoGrafo + " é(são): " + mediaTempos + " nanosegundos");

    }
        

   // pegar exemplos pré-montados
    private static Grafo CriarGrafoEulerianoExemplo() {
        Grafo grafoEuleriano = new Grafo();

        grafoEuleriano.adicionarAresta(1, 2, 1);
        grafoEuleriano.adicionarAresta(2, 3, 1);
        grafoEuleriano.adicionarAresta(3, 4, 1);
        grafoEuleriano.adicionarAresta(4, 1, 1);
        grafoEuleriano.adicionarAresta(1, 3, 1);

        return grafoEuleriano;
    }

    private static Grafo CriarGrafoNaoEulerianoExemplo() {
        Grafo grafoNaoeuleriano = new Grafo();



      
        return grafoNaoeuleriano;
    }
    
    private static Grafo CriarGrafoBipartidoExemplo() {
        Grafo grafo = new Grafo();

        return grafo;
    }

    private static Grafo CriarGrafoArvoreExemplo(){
        Grafo grafo = new Grafo();

        return grafo;

    }
}


