package unicap.grafos.unicapmaps.AlgoritmosGrafo;

import java.util.ArrayList;

import unicap.grafos.unicapmaps.model.Aresta;
import unicap.grafos.unicapmaps.model.Vertice;

public interface InterfaceBuscaEmGrafo {
    ArrayList<Aresta> buscar(Vertice partida, Vertice chegada);
}
