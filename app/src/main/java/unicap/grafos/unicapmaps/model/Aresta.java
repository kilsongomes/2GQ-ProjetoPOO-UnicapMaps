package unicap.grafos.unicapmaps.model;

import java.util.ArrayList;


public class Aresta {
    private int id;
    private Vertice A = null;
    private Vertice B = null;
    private int custo;
    private String descricao[];
    private ArrayList<Coordenadas> coordenadas;

    public Aresta(Vertice a, Vertice b){
        this.A = a;
        this.B = b;
        coordenadas = new ArrayList<>();
    }

    public String[] getDescricao() {
        return descricao;
    }

    public void setDescricao(String[] descricao) {
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setA(Vertice a) {
        A = a;
    }

    public void setB(Vertice b) {
        B = b;
    }

    public int getCusto() {
        return custo;
    }

    public void setCusto(int custo) {
        this.custo = custo;
    }

    public Vertice getA() {
        return A;
    }

    public Vertice getB(){
        return B;
    }

    public void addCoord(int x, int y){
        Coordenadas novoPonto = new Coordenadas(x, y);
        coordenadas.add(novoPonto);
    }

    public ArrayList<Coordenadas> getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(ArrayList<Coordenadas> coordenadas) {
        this.coordenadas = coordenadas;
    }
}
