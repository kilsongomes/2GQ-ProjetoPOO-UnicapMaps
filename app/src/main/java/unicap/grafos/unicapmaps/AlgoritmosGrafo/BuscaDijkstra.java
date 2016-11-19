package unicap.grafos.unicapmaps.AlgoritmosGrafo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import unicap.grafos.unicapmaps.controller.GrafoController;
import unicap.grafos.unicapmaps.model.Aresta;
import unicap.grafos.unicapmaps.model.Grafo;
import unicap.grafos.unicapmaps.model.Vertice;

/**
 * Created by Cais Automação on 11/11/2016. project UnicapMaps
 */
public class BuscaDijkstra implements InterfaceBuscaEmGrafo {

//    private Set<Vertice> nodesSelecionados;
//    private Set<Vertice> nodes_naoSelecionados;
//    private Map<Vertice, Vertice> proximo;
//    private Map<Vertice, Integer> distancia;

    private GrafoController controller;
    private Grafo grafo;
    private ArrayList<Integer> custos;
    private ArrayList<Vertice> anteriores;

    public BuscaDijkstra(GrafoController controller) {
        this.controller = controller;
        //this.nodes = new ArrayList<Vertice>(grafo.getVertices());
        //this.arestas = new ArrayList<Aresta>(grafo.getArestas());
        grafo = Grafo.getInstance();
    }

    @Override
    public ArrayList<Aresta> buscar(Vertice partida, Vertice chegada) {
        ArrayOrdenado fila = new ArrayOrdenado();
        ArrayList<Vertice> retorno;
        anteriores = new ArrayList();
        Vertice u;
        custos = new ArrayList();
        inicializar(anteriores,custos);
        custos.set(partida.getId(),0);
        fila.add(partida);
        //nodesSelecionados = new HashSet<Vertice>();
        //nodes_naoSelecionados = new HashSet<Vertice>();
        //distancia = new HashMap<Vertice, Integer>();
        //proximo = new HashMap<Vertice, Vertice>();
        //distancia.put(partida, 0);
        //nodes_naoSelecionados.add(partida);
        while (!fila.isEmpty()) {
            u = fila.get(0);
            fila.remove(0);
            for (Vertice adjacente : u.getAdjacentes()){
                relaxarAresta(u,adjacente,acharDistancia(u,adjacente));
                fila.add(u);
            }
//            Vertice node = acharMenor(nodes_naoSelecionados);
//            nodesSelecionados.add(node);
//            nodes_naoSelecionados.remove(node);
//            caminhoMinimo(node);
        }
        retorno = varrerAnteriores(partida,chegada);
        //retorno = escolherCaminho(chegada);
        return controller.getArestasFromVertices(retorno);
    }

    private ArrayList<Vertice> varrerAnteriores(Vertice partida,Vertice chegada){
        ArrayList<Vertice> caminho = new ArrayList();
        Vertice temp = chegada;
        while(temp != partida){
            caminho.add(temp);
            anteriores.get(temp.getId());
        }
        caminho.add(partida);
        Collections.reverse(caminho);
        return caminho;
    }

    private void relaxarAresta(Vertice A, Vertice B, int custo) {
        int idA, idB, novoCusto;
        idA = A.getId();
        idB = B.getId();
        if(custos.get(idA) == Integer.MAX_VALUE){
            novoCusto = custos.get(idA);
        } else{
            novoCusto = custos.get(idA) + custo;
        }
        if(novoCusto < custos.get(idB)){
            custos.set(idB, novoCusto);
            anteriores.set(idB, A);
        }
    }

    private void inicializar (ArrayList<Vertice> anteriores, ArrayList<Integer> custo){
        int tamanhoGrafo = grafo.countVertices(), i;
        for (i = 0; i < tamanhoGrafo; i++) {
            anteriores.add(null);
            custo.add(Integer.MAX_VALUE);
        }
    }

/*
    private Vertice acharMenor(Set<Vertice> vertexes) {
        Vertice menor = null;
        for (Vertice vertice : vertexes) {
            if (menor == null) {
                menor = vertice;
            } else {
                if (menorDistancia(vertice) < menorDistancia(menor)) {
                    menor = vertice;
                }
            }
        }
        return menor;
    }
*/

/*
    private int menorDistancia(Vertice destino) {
        Integer d = distancia.get(destino);
        if (d == null) {
            return Integer.MAX_VALUE;
        } else {
            return d;
        }
    }
*/

/*
    private void caminhoMinimo(Vertice node) {
        List<Vertice> adjacentes = acharVizinhos(node);
        for (Vertice alvo : adjacentes) {
            if (menorDistancia(alvo) > menorDistancia(node)
                    + acharDistancia(node, alvo)) {
                distancia.put(alvo, menorDistancia(node)
                        + acharDistancia(node, alvo));
                proximo.put(alvo, node);
                nodes_naoSelecionados.add(alvo);
            }
        }
    }
*/

/*
    private boolean nosSetados(Vertice vertice) {
        return nodesSelecionados.contains(vertice);
    }
*/

    private int acharDistancia(Vertice node, Vertice alvo) {
        Aresta aresta;
        aresta = controller.getArestaFromVertices(node,alvo);
        return aresta.getCusto();
    }

/*
    private List<Vertice> acharVizinhos(Vertice node) {
        List<Vertice> vizinhos = new ArrayList<Vertice>();
        for (Aresta aresta : arestas) {
            if (aresta.getB().equals(node)
                    && !nosSetados(aresta.getB())) {
                vizinhos.add(aresta.getB());
            }
        }
        return vizinhos;
    }
*/

/*
    public LinkedList<Vertice> escolherCaminho(Vertice alvo) {
        LinkedList<Vertice> caminho = new LinkedList<Vertice>();
        Vertice passo = alvo;
        // VERIFICANDO SE O CAMINHO EXISTE !!
        if (proximo.get(passo) == null) {
            return null;
        }
        caminho.add(passo);
        while (proximo.get(passo) != null) {
            passo = proximo.get(passo);
            caminho.add(passo);
        }
        // PARA COLOCAR NA ORDEM CORRETA O CAMINHO !!
        Collections.reverse(caminho);
        return caminho;
    }
*/

    private class ArrayOrdenado extends ArrayList<Vertice>{
        public ArrayOrdenado() {
            super();
        }

        @Override
        public boolean add(Vertice novo) {
            Vertice verticeTemp;
            if(isEmpty()){
                return super.add(novo);
            }
            else{
                for (int i = 0; i < size();i++){
                    verticeTemp = grafo.getVertice(i);
                    if(custos.get(novo.getId()) < custos.get(verticeTemp.getId())){
                        super.add(i,novo);
                        return true;
                    }
                }
                return super.add(novo);
            }
        }
    }
}