package unicap.grafos.unicapmaps.controller;

/**
 * Created by kilso on 23/11/2016.
 */

public class ResultadoPesquisa {
    private String nomeBloco;
    private String descricao;
    private int id;

    public ResultadoPesquisa(String nomeBloco, int id, String descricao){
        this.nomeBloco = nomeBloco;
        this.descricao = descricao;
        this.id = id;
    }

    public String getNomeBloco(){
        return nomeBloco;
    }
    public String getDescricao(){
        return descricao;
    }
    public int getId(){
        return id;
    }
}
