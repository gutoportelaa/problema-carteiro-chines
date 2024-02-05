public class TestesdeDesempenho {
    
    public static void main() {
        
        TestesdeDesempenho testes = new TestesdeDesempenho();



        Grafo grafoEuleriano = CriarGrafoEulerianoExemplo();
        testes.Testador(grafoEuleriano, "Grafo Euleriano");

        Grafo grafoNaoEuleriano = CriarGrafoNaoEulerianoExemplo();
        testes.Testador(grafoNaoEuleriano, "Grafo Nao Euleriano");

        Grafo grafoBipartido = CriarGrafoBipartidoExemplo();
        testes.Testador(grafoBipartido, "Grafo Bipartido");
        
        // Outros testes ?
    }



    public void Testador(Grafo exGrafo, String TipodoGrafo){
        Algoritmos algoritmos = new Algoritmos();   // para o caso de testar somente o Dijksra
        ResolverCarteiroChines ResolverCarteiroChines = new ResolverCarteiroChines();
        Grafo grafo = exGrafo;


        System.out.println("\nTeste de Desempenho para " + TipodoGrafo + ":\n");

        System.out.println(TipodoGrafo + ":");
        grafo.imprimirGrafo();


        long somaTempos = 0;
        int numeroExecucoes = 5;


        for (int i = 0; i < numeroExecucoes; i++) {    // laço de desemprenho

            long tempoInicial = System.currentTimeMillis();
            ResolverCarteiroChines.AlgResolverCarteiroChines(grafo);
            long tempoFinal = System.currentTimeMillis();
            long tempoExecucao = tempoFinal - tempoInicial;

           // System.out.println("Execução " + (i + 1) + ": Tempo de execução do ResolveCarteiroChines: " + tempoExecucao + " milissegundos");
           //System.out.println("Tempo de execução médio do algoritmo de Dijkstra em " + TipodoGrafo + " é(são): " + (tempoFinalDijkstra - tempoInicialDijkstra) + " milissegundos");

            somaTempos += tempoExecucao;  //somatório
        }

        // calcula e exibe a média
        long mediaTempos = somaTempos / numeroExecucoes;
        System.out.println("Tempo médio de execução do algoritmo de Dijkstra em " + TipodoGrafo + " é(são): " + mediaTempos + " milissegundos");

    }
        

   // pegar exemplos pré-montados
    private static Grafo CriarGrafoEulerianoExemplo() {
        Grafo grafo = new Grafo();

        return grafo;
    }
    private static Grafo CriarGrafoNaoEulerianoExemplo() {
        Grafo grafo = new Grafo();

        return grafo;
    }
    private static Grafo CriarGrafoBipartidoExemplo() {
        Grafo grafo = new Grafo();

        return grafo;
    }

    
}


