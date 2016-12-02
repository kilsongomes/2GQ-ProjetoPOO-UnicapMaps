package unicap.grafos.unicapmaps.dao;

import unicap.grafos.unicapmaps.model.Grafo;

public class GrafoDao {

    private GrafoCreator grafoCreator;


    public GrafoDao() {

        grafoCreator = new GrafoCreator();
    }

    public Grafo getGrafo(){
        grafoCreator.construirGrafo();
        return grafoCreator.getGrafo();
    }

}

