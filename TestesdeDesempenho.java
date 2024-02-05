public class TestesdeDesempenho {
    
    public static void main() {
        
        TestesdeDesempenho testes = new TestesdeDesempenho();



        Grafo grafoEuleriano = CriarGrafoEulerianoExemplo();
        testes.Testador(grafoEuleriano, "Grafo Euleriano");

        Grafo grafoNaoEuleriano = CriarGrafoNaoEulerianoExemplo();
        testes.Testador(grafoNaoEuleriano, "Grafo Nao Euleriano");

        Grafo grafoBipartido = CriarGrafoBipartidoExemplo();
        testes.Testador(grafoBipartido, "Grafo Bipartido");
        
        Grafo grafoArvore = CriarGrafoArvoreExemplo();
        testes.Testador(grafoArvore, "Grafo Arvore" );
        // Outros testes ?
    }



    public void Testador(Grafo exGrafo, String TipodoGrafo){
        //Algoritmos algoritmos = new Algoritmos();   // para o caso de testar somente o Dijksra
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

		int a = 1;
		int b = 2;
		int c = 3;
		int d = 4;
		int e = 5;
		int f = 6;

		grafo.adicionarAresta(a, b, 1);
		grafo.adicionarAresta(b, c, 4);
		grafo.adicionarAresta(a, d, 1);
		grafo.adicionarAresta(d, e, 3);
		grafo.adicionarAresta(e, f, 1);
		grafo.adicionarAresta(f, c, 3);
		grafo.adicionarAresta(a, e, 2);
		grafo.adicionarAresta(b, f, 5);
		grafo.adicionarAresta(e, c, 1);

        return grafo;
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


