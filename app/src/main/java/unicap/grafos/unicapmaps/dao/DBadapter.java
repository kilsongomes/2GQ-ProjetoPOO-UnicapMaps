package unicap.grafos.unicapmaps.dao;

import java.util.ArrayList;

/**
 * Created by kilso on 08/12/2016.
 */

public class DBadapter {

    public DBadapter(){
        coordenadasMatriz.add(matrizAdjacencias);
        coordenadasMatriz.add(coordenadasVertices);
        coordenadasComplementares.add(coordenadasComple);
        custosGrafos.add(custos);
        infoBlocos.add(A);      //0  A
        infoBlocos.add(B);      //1  B
        infoBlocos.add(C);      //2  C
        infoBlocos.add(D);      //3  D
        infoBlocos.add(E);      //4  E
        infoBlocos.add(F);      //5  F
        infoBlocos.add(G);      //6  G
        infoBlocos.add(H);      //7  H = Capela
        infoBlocos.add(I);      //8  I
        infoBlocos.add(J);      //9  J
        infoBlocos.add(K);      //10 K
        infoBlocos.add(L);      //11 L
        infoBlocos.add(M);      //12 M = Biblioteca
        infoBlocos.add(N);      //13 N
        infoBlocos.add(O);      //14 O
        infoBlocos.add(P);      //15 P = Estacionamento professores
        infoBlocos.add(Q);      //16 Q
        infoBlocos.add(R);      //17 R
        infoBlocos.add(S);      //18 S = Estacionamento estudantes
        infoBlocos.add(T);      //19 T
        infoBlocos.add(U);      //20 U = Quadra de esportes
        infoBlocos.add(V);      //21 V = Jardim
        infoBlocos.add(W);      //22 W
        infoBlocos.add(G4);     //23 G4

    }

    private ArrayList<int[][]> coordenadasMatriz = new ArrayList<>();
    private ArrayList<int [][][]>coordenadasComplementares = new ArrayList<>();
    private ArrayList<int[]>custosGrafos = new ArrayList<>();
    private ArrayList<String[]> infoBlocos = new ArrayList<>();

    public ArrayList<String[]> getInfoBlocos() {
        return infoBlocos;
    }

    public ArrayList<int[][]> getCoordenadasMatriz() {
        return coordenadasMatriz;
    }

    public ArrayList<int[][][]> getCoordenadasComplementares() {
        return coordenadasComplementares;
    }

    public ArrayList<int[]> getCustosGrafos() {
        return custosGrafos;
    }

    public int[] BuscarArray(String info,String bloco){
        int[] vet = new int[2];int i,j = 0;
        vet[0] = -1;//bloco
        vet[1] = -1;//String de informações

        for(i = 0;i <= infoBlocos.size();i++){
            if(nomesBlocos[i].equalsIgnoreCase(bloco)) {
                while(j <= infoBlocos.get(i)[j].length()) {
                    if (infoBlocos.get(i)[j].equalsIgnoreCase(info)) {
                        vet[0] = i;
                        vet[1] = j;
                        return vet;
                    }
                    j++;
                }
                break;
            }
        }
        return vet;
    }

    public void setInfoBlocos(String info,String bloco){
        int i,j = 0;

        for(i = 0;i <= infoBlocos.size();i++){
            if(nomesBlocos[i].equalsIgnoreCase(bloco)){
               while(j <= infoBlocos.get(i)[j].length()){
                   j++;
               }
                infoBlocos.get(i)[j+1] = info;
                break;
            }
        }
    }
    public void ListarInfoBlocos(){
        int i,j;

        for(i = 0;i <= infoBlocos.size();i++){
            for(j = 0; j <= infoBlocos.get(i)[j].length();j++ ){
                System.out.printf("Bloco:%i  %s\n",i,infoBlocos.get(i)[j]);
            }
        }
    }

    public void RemoverInfoBlocos(String info,String bloco){
        int i,j = 0;
        int[] vet = new int[2];

        vet = BuscarArray(info,bloco);
        if(vet[0] == -1){
            System.out.printf("Informação ncao encontrada.\n");
        }
        else {
            infoBlocos.remove(vet[0])[vet[1]].toString();
        }
    }

    public void Alterar (String info,String bloco,String infoTroca){
        int[] vet = new int[2];

        vet = BuscarArray(info,bloco);

        if(vet[0] == -1){
            System.out.printf("Informacao nao encontrada.\n");
        }
        else{
            infoBlocos.get(vet[0])[vet[1]] = infoTroca;
        }
    }

    public void Consultar(String info,String bloco){
        int[] vet = new int[2];

        vet = BuscarArray(info,bloco);

        if(vet[0] == -1){
            System.out.printf("Informacao nao existe\n");
        }
        else{
            System.out.printf("informacao existe no bloco:%i como %s",vet[0],infoBlocos.get(vet[0])[vet[1]]);
        }
    }

    public int[][] getMatrizAdjacencias(){
       return coordenadasMatriz.get(0);
    }
    public int [][] getCoordenadasVertices(){
        return coordenadasMatriz.get(1);
    }
    public int [][][] getCoordenadasComple(){
        return coordenadasComplementares.get(0);
    }
    public int [] getCustos(){
        return custosGrafos.get(0);
    }

    private static int matrizAdjacencias[][] = { //matriz nova com arestas simples. precisa passar o procedimento de espelhamento
            // A B C D E F G H I J K L M N O P Q R S T U V W G4
            {0,1,0,1,1,1,1,0,0,0,0,0,0,0,0,0,0,1,0,1,1,1,0,0}, //0  A
            {0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0}, //1  B
            {0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0}, //2  C
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, //3  D
            {0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0,1,0,1,1,0,0,0}, //4  E
            {0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,0,1,1,1,0,0,0,0}, //5  F
            {0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,1,1,0,1,0,1}, //6  G
            {0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0}, //7  H = Capela
            {0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, //8  I
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, //9  J
            {0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,1,0}, //10 K
            {0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0}, //11 L
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0}, //12 M = Biblioteca
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0}, //13 N
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, //14 O
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0}, //15 P = Estacionamento professores
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0}, //16 Q
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0}, //17 R
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0}, //18 S = Estacionamento estudantes
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, //19 T
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, //20 U = Quadra de esportes
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, //21 V = Jardim dos patos
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, //22 W
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}  //23 G4
            // A B C D E F G H I J K L M N O P Q R S T U V W G4
    };


    public static int coordenadasVertices[][] = {
            { 587,810},  //0  A
            { 556,810},  //1  B
            { 433,735},  //2  C
            { 661,794},  //3  D
            { 733,508},  //4  E
            { 812,1214}, //5  F
            { 572,1118}, //6  G
            { 437,649},  //7  H = Capela
            { 850,442},  //8  I
            { 870,209},  //9  J
            {1091,1354}, //10 K
            { 863,1275}, //11 L
            { 451,989},  //12 M = Biblioteca
            { 993,1172}, //13 N
            {1086,1172}, //14 O
            { 516,707},  //15 P = Estacionamento professores
            { 752,664},  //16 Q
            { 659,1002}, //17 R
            { 579,1176}, //18 S = Estacionamento estudantes
            { 860,1044}, //19 T
            { 684,636},  //20 U = Quadra de esportes
            { 543,1002}, //21 V = Jardim dos patos
            {1016,1398}, //22 W
            { 343,1116}, //23 G4
    };

    private static int coordenadasComple[][][] = {
            {},                                                                               //id:0  (Bloco A -> Bloco B)
            {{619,794}},                                                                      //id:1  (Bloco A -> Bloco D)
            {{605,707}, {605,607},{664,607},{670,508}},                                       //id:2  (Bloco A -> Bloco E)
            {{587,877},{812,877},{812,1124}},                                                 //id:3  (Bloco A -> Bloco F)
            {{587,877},{812,877},{812,1124}},                                                 //id:4  (Bloco A -> Bloco G)
            {{587,877},{659,877}},                                                            //id:5  (Bloco A -> Bloco R)
            {{587,877},{812,877},{812,1044}},                                                 //id:6  (Bloco A -> Bloco T)
            {{605,707}, {605,607},{664,607}},                                                 //id:7  (Bloco A -> Quadra de esportes)
            {{587,877},{659,877},{659,963}, {584,963},{568,969},{557,980}},                   //id:8  (Bloco A -> Jardim)
            {{438,810}},                                                                      //id:9  (Bloco B -> Bloco C)
            {},                                                                               //id:10 (Bloco B -> Estacionamento professores)
            {},                                                                               //id:11 (Bloco C -> Capela)
            {},                                                                               //id:12 (Bloco C -> Estacionamento professores)
            {{812,508}},                                                                      //id:13 (Bloco E -> Bloco F)
            {{812,508},{812,1124}},                                                           //id:14 (Bloco E -> Bloco G)
            {{447,508}},                                                                      //id:15 (Bloco E -> Capela)
            {{447,508},{447,492},{483,492},{493,442}},                                        //id:16 (Bloco E -> Bloco I)
            {{812,508},{812,877},{658,877}},                                                  //id:17 (Bloco E -> Bloco R)
            {{812,508},{812,1044}},                                                           //id:18 (Bloco E -> Bloco T)
            {{670,508},{664,607}},                                                            //id:19 (Bloco E -> Quadra de esportes)
            {{863,1214}},                                                                     //id:20 (Bloco F -> Bloco L)
            {{863,1214},{863,1172}},                                                          //id:21 (Bloco F -> Bloco N)
            {{812,877},{659,877}},                                                            //id:22 (Bloco F -> Bloco R)
            {{812,1176}},                                                                     //id:23 (Bloco F -> Estacionamento estudantes)
            {{812,1044}},                                                                     //id:24 (Bloco F -> Bloco T)
            {{572,1086},{472,1086},{472,1066},{483,1047},{484,1021},{480,1005},{468,996}},    //id:25 (Bloco G -> Biblioteca)
            {{572,1086}, {663,1052}},                                                         //id:26 (Bloco G -> Bloco R)
            {},                                                                               //id:27 (Bloco G -> Estacionamento estudantes)
            {{812,1124},{812,1044}},                                                          //id:28 (Bloco G -> Bloco T)
            {{572,1086}, {522,1086},{522,1066},{543,1011}},                                   //id:29 (Bloco G -> Jardim)
            {},                                                                               //id:30 (Bloco G -> Bloco G4)
            {{447,508},{447,492},{483,492},{493,442}},                                        //id:31 (Capela -> Bloco I)
            {},                                                                               //id:32 (Capela -> Estacionamento professores)
            {{902,442},{884,271}},                                                            //id:33 (Bloco I -> Bloco J)
            {{863,1354}},                                                                     //id:34 (Bloco K -> Bloco L)
            {{1143,1354},{1135,1172}},                                                        //id:35 (Bloco K -> Bloco O)
            {{1016,1354}},                                                                    //id:36 (Bloco K -> Bloco W)
            {{863,1172}},                                                                     //id:37 (Bloco L -> Bloco N)
            {{863,1354},{1016,1354}},                                                         //id:38 (Bloco L -> Bloco W)
            {{466,989},{480,993},{486,992},{501,999},{522,1003}},                             //id:39 (Biblioteca -> Jardim)
            {},                                                                               //id:40 (Bloco N -> Bloco O)
            {{863,1172}},                                                                     //id:41 (Bloco N -> Bloco T)
            {{575,607},{664,607}},                                                            //id:42 (Estacionamento professores -> Quadra de esportes)
            {{721,636}},                                                                      //id:43 (Bloco Q -> Quadra de esportes)
            {{659,877},{812,877},{812,1044}},                                                 //id:44 (Bloco R -> Bloco T)
            {{659,963},{584,963},{568,969},{557,980}},                                        //id:45 (Bloco R -> Jardim)
            {{812,1176}, {812,1044}}                                                          //id:46 (Estacionamento estudantes -> Bloco T)
    };

    private static int[] custos = {
            11,     //id:0  (Bloco A -> Bloco B)
            30,     //id:1  (Bloco A -> Bloco D)
            124,    //id:2  (Bloco A -> Bloco E)
            380,    //id:3  (Bloco A -> Bloco F)
            270,    //id:4  (Bloco A -> Bloco G)
            92,     //id:5  (Bloco A -> Bloco R)
            190,    //id:6  (Bloco A -> Bloco T)
            94,     //id:7  (Bloco A -> Quadra de esportes)
            117,    //id:8  (Bloco A -> Jardim)
            68,     //id:9  (Bloco B -> Bloco C)
            34,     //id:10 (Bloco B -> Estacionamento professores)
            29,     //id:11 (Bloco C -> Capela)
            28,     //id:12 (Bloco C -> Estacionamento professores)
            256,    //id:13 (Bloco E -> Bloco F)
            316,    //id:14 (Bloco E -> Bloco G)
            126,    //id:15 (Bloco E -> Capela)
            192,    //id:16 (Bloco E -> Bloco I)
            250,    //id:17 (Bloco E -> Bloco R)
            225,    //id:18 (Bloco E -> Bloco T)
            64,     //id:19 (Bloco E -> Quadra de esportes)
            36,     //id:20 (Bloco F -> Bloco L)
            65,     //id:21 (Bloco F -> Bloco N)
            197,    //id:22 (Bloco F -> Bloco R)
            93,     //id:23 (Bloco F -> Estacionamento estudantes)
            47,     //id:24 (Bloco F -> Bloco T)
            72,     //id:25 (Bloco G -> Biblioteca)
            40,     //id:26 (Bloco G -> Bloco R)
            12,     //id:27 (Bloco G -> Estacionamento estudantes)
            104,    //id:28 (Bloco G -> Bloco T)
            60,     //id:29 (Bloco G -> Jardim)
            68,     //id:30 (Bloco G -> Bloco G4)
            128,    //id:31 (Capela -> Bloco I)
            35,     //id:32 (Capela -> Estacionamento professores)
            95,     //id:33 (Bloco I -> Bloco J)
            98,     //id:34 (Bloco K -> Bloco L)
            50,     //id:35 (Bloco K -> Bloco O)
            32,     //id:36 (Bloco K -> Bloco W)
            84,     //id:37 (Bloco L -> Bloco N)
            84,     //id:38 (Bloco L -> Bloco W)
            23,     //id:39 (Biblioteca -> Jardim)
            29,     //id:40 (Bloco N -> Bloco O)
            70,     //id:41 (Bloco N -> Bloco T)
            80,     //id:42 (Estacionamento professores -> Quadra de esportes)
            22,     //id:43 (Bloco Q -> Quadra de esportes)
            168,    //id:44 (Bloco R -> Bloco T)
            50,     //id:45 (Bloco R -> Jardim)
            115     //id:46 (Estacionamento estudantes -> Bloco T)
    };

    private static String[] nomesBlocos = {
            "Bloco A",
            "Bloco B",
            "Bloco C",
            "Bloco D",
            "Bloco E",
            "Bloco F",
            "Bloco G",
            "Capela",
            "Bloco I",
            "Bloco J",
            "Bloco K",
            "Bloco L",
            "Biblioteca",
            "Bloco N",
            "Bloco O",
            "Estacionamento professores",
            "Bloco Q",
            "Bloco R",
            "Estacionamento estudantes",
            "Bloco T",
            "Quadra de esportes",
            "Jardim",
            "Bloco W",
            "Bloco G4"
    };
    public String[] getNomesBlocos(){
        return nomesBlocos;
    }
    private String[] A = {
            "Portaria",
            "Posto de uma agência do banco Santander (2 caixas eletrônicos)",
            "SBS - Livraria Internacional",
            "FASA - Fundação Antônio dos Santos Abranches",
            "Sala 104 - Laboratório de Cinesiologia e Método e Técnicas de Avaliação",
            "Sala 105 - Laboratório de Recursos Terapêuticos e Prótese e Ortése ",
            "Sala 107 - Laboratório de Filosofia e Imagenologia ",
            "Sala 108 - Laboratório de Cinesioterapia ",
            "Sala 109 - Laboratório de Manipulação ",
            "Sala 110 - Laboratório de Eletrofototermoterapia ",
            "Sala 204 - Laboratório de Ciências ",
            "Salas 205/206 - Laboratório de Zoologia",
            "Sala 207 - Laboratório de Botânica ",
            "Salas 208/209 - Secretaria de Apoio aos Laboratórios de Biologia e Fisioterapia ",
            "Sala 210 - Laboratório de Citologia, Histologia e Embriologia ",
            "Salas 211/212 - Laboratório de Anatomia ",
            "Sala 404 - Laboratório de Comunicação Visual",
            "Sala 405 - Laboratório de Jogos Digitais",
            "Sala 407 - Laboratório Multiuso: Publicidade e Cursos de Tecnologia ",
            "Sala 408 - Hemeroteca ",
            "Sala 409 - Secretaria, Coordenação, Assessoria e Sala dos Professores do CCS - Centro de Comunicação Social (Jornalismo, Relações Públicas, Jogos Digitais e Publicidade e Propaganda). ",
            "Sala 410 - Arquivo ",
            "Sala 411 - AGERP - Agência Experimental de Relações Públicas ",
            "Sala 504 - Estúdio de Telejornalismo ",
            "Sala 505 - Estúdio de Radiojornalismo ",
            "Sala 506 - Laboratório de Redação Jornalística (TV) ",
            "Sala 507 - Laboratório de Redação Jornalística (Rádio) ",
            "Sala 809 - Escritório Modelo - Arquitetura e Urbanismo "
    };

    private String[] B = {
            "PROCOM - Pró-Reitoria Comunitária",
            "Sala 002 - Coordenação de Ação Comunitária",
            "Sala 003 - Secretaria",
            "Sala 004 - Espaço Loyola",
            "Salas 005/006/007 - Divisão de Ação Social",
            "Sala 008 - Instituto Humanitas Unicap",
            "Sala 102 - Auditório Inácio de Azevedo",
            "Sala 103 - Assessoria C.T.C.H.",
            "Salas 104/105 - Secretaria C.T.C.H.",
            "Sala 106 - Coordenação do curso de Pedagogia / Coordenação de Estágio",
            "Sala 107 - Coordenação do curso de História / Coordenação do curso de Letras",
            "Sala 108 - Coordenação do curso de Filosofia / Coordenação do curso de Teologia",
            "Sala 109 - Sala dos Professores",
            "Sala 110 - Espaço Cultural",
            "Sala 206 - Arquivo C.T.C.H.",
            "6º andar - Clínica de Fonoaudiologia",
            "7º andar - C.C.B.S. - Centro de Ciências Biológicas e Sáude",
            "Sala 713 - Secretaria C.C.B.S.",
            "Sala 715 - Coordenação Fisioterapia / Coordenação Ciências Biológicas",
            "Sala 716 - Sala de Ludoterapia",
            "Sala 717 - Coordenação Psicologia / Coordenação Terapia Ocupacional",
            "Sala 719 - Pastoral",
            "Sala 721 - Centro de Estudos sobre Parkinson",
            "Sala 728 - Atendimento Otorrino",
            "8º andar - Clínica de Psicologia"
    };

    private String[] C = {
            "Cabine da Telefonista",
            "Ouvidoria Comunitária",
            "CETEC - Centro de Educação Técnico e Cultural",
            "DMP - Divisão de Manutenção Predial",
            "Oficina Elétrica",
    };

    private String[] D = {
            "Escritório Técnico e Patrimônio",
            "Sala 002 - Secretaria CCT",
            "Sala 003 - Laboratório de CAD",
            "Sala 004 - Laboratório de Estruturas",
            "Sala 005 - Laboratório de Tecnologia de Materias",
            "Sala 008 - Laboratório de Mecância dos Fluidos e Hidráulica",
            "Sala 009 - Laboratório de Computação",
            "Sala 010 - Laboratório de Geotecnia",
            "Sala 011 - Câmara Úmida",
            "Sala 012 - Laboratório de Conforto Ambiental",
            "Sala 014 - Oficina de Áudio/Vídeo",
            "Sala 102 - Coordenação do CCT",
            "Sala 107 - Laboratório de Arquitetura",
            "sala 110 - Laboratório de Geotecnia",
            "Sala 111 - Laboratório de Topografia",
            "Sala 112 - Laboratório de Geologia",
            "Sala 113 - Sala Multiuso do CCT",
            "Salas 202/206 - Laboratório de Arquitetura",
            "Salas 302/306 - Laboratório de Arquitetura",
            "Sala 402 - Laboratório de Física I e II",
            "Sala 406 - Laboratório de Arquitetura",
            "Sala 504 - Almoxarifado do Departamento de Física",
            "Salas 505/506 - Laboratório de Física III e IV",
            "Sala 602 - Laboratório de Química Orgânica e Polímeros",
            "Sala 604 - Laboratório de Físico-Química",
            "Sala 702 - Laboratório de Química Geral e Inorgânica I",
            "Sala 703 - GDEP - Grupo de Desenvolvimento de Equipamentos e Processos",
            "Sala 704 - Laboratório de Bioengenharia",
            "Sala 705 - Laboratório de Química Geral e Inorgânica II",
            "Sala 802 - Laboratório de Análises Químicas",
            "Sala 803 - Laboratório de Instrumentação",
            "Sala 804 - Laboratório de Química Analítica e Ambiental",
            "Sala 805 - Laboratório de Controle de Processos",
            "Sala 806 - Laboratório de Engenharia Química"
    };

    private String[] E = {
            "FASA Gráfica",
            "COAVE - Comissão para Aplicação do Vestibular"
    };

    private String[] F = {};

    private String[] G = {
            "Sala 001 - Laboratório de Tratamento de Imagens do curso de Fotografia",
            "Sala 002 - Laboratório de Fotografia",
            "Sala 004 - Tesouraria",
            "Banco Itaú",
            "COGEST - Coordenação Geral de Estágio",
            "Sala 101 - Auditório G1",
            "Sala 102 - Auditório",
            "Sala 103/104 - Laboratórios Espaço Loyola",
            "Sala 105 - Auditório G2",
            "Sala 202 - Sala de Pesquisa Arqueológica",
            "Sala 203 - Laboratório e Museu de Arqueologia - LABMUSARq",
            "Salas 502/503 - Secretaria e Coordenação do CCB - Centro de Ciências Sociais (Gestão de Turismo, Gestão de Eventos, Gestão Portuária, Fotografia, Economia, Administração, Serviço Social e Contábeis)",
            "Sala 802 - Sala dos Professores do 1º Ciclo",
            "Sala 803 - Secretaria e Coordenação Geral do 1º Ciclo"
    };

    private String[] H = {
            "Atendimento Pastoral",
            "Serviço Médico",
            "Centro Cultural",
            "Almoxarifado / DIMAT - Divisão de Materiais"
    };

    private String[] I = {
            "Coordenação de Tecnologia de Informação",
            "Administração"
    };

    private String[] J = {};

    private String[] K = {};

    private String[] L = {};

    private String[] M = {};

    private String[] N = {};

    private String[] O = {};

    private String[] P = {};

    private String[] Q = {};

    private String[] R = {
            "Salas 005, 009 - SERDAE (Setor de Processamento de infoBlocos)",
            "Sala 011 - SERD (Setor de Emissão e Registro de Diplomas)",
            "Sala 012 - SEAD (Setor de Admissão)",
            "Sala 017 - SEPED (Setor de Protocolo)",
            "Sala 020 - DGE (Diretoria de Gestão Escolar)",
            "Sala 022 - SEAC (Arquivo Central do DGE)",
            "Atendimento para os setores de Admissão, Protocolo e Diplomas",
            "Sala 105 - Prad (Pró-Reitoria Administrativa)",
            "Salas 110, 111 - DPA (Divisão de Programação Acadêmica)",
            "Salas 112, 113, 114, 115, 116 - DIPES (Divisão de Pessoal)",
            "Sala 117 - ASSECOM e Aê (Assessoria de Comunicação e Agência Experimental de Publicidade e Propaganda)",
            "Salas 118, 118 - Contadoria",
            "Salas 120, 121 - DIFIC (Divisão de Finanças)",
            "Salas 204, 205 - Reitoria",
            "Salas 206, 207 - Sala dos Conselhos",
            "Sala 209 - Salão Nobre",
            "Sala 212 - Relações Interinstitucionais e Internacionais",
            "Salas 213, 214, 215, 216 - ASSEPLAN e Avaliação",
            "Anexo - ASSEJUR"
    };

    private String[] S = {};

    private String[] T = {};

    private String[] U = {};

    private String[] V = {};

    private String[] W = {};

    private String[] G4 = {
            "Sala 001 - Laboratório de Áudio e Vídeo do curso de Publicidade, que é ligado ao CCS",
            "Sala 003 - Coordenação Geral de Pós-Graduação e Secretaria Acadêmica dos Mestrados e Doutorado",
            "Sala 005 - Sala de Teleconferências",
            "Secretaria Acadêmica da Especialização Latu sensu",
            "Secretaria Acadêmica da Especialização MBA",
            "Coordenação Geral de Extensão",
            "Anfiteatro",
            "Laboratório Religião, Cultura e Sociedade (Mestrado)",
            "Laboratório de Linguagem, Distúrbio e Multidisciplinaridade (Mestrado)",
            "Laboratório de Linguagem, Educação e Organização Sócio-Cultural (Mestrado)",
            "Centro de Convivência de Afásicos - Grupo de Estudos em Afasia e Gagueira",
            "Secretaria e Sala de Computação dos Mestrados",
            "Gabinete da Pró-Reitoria Acadêmica",
            "Coordenação Geral de Pesquisa",
            "Projeto de Iniciação científica (PIBIC)",
            "Comitê de Ética em Pesquisa",
            "Coordenação Geral de Graduação",
            "NAD - Núcleo de Atendimento ao Discente",
            "Gabinete da Coordenação Geral de Pós-Graduação",
            "Secretaria Administrativa dos cursos de Mestrado e Doutorado",
            "Gabinete dos coordenadores dos cursos de mestrado e doutorado",
            "Comissão Editorial"
    };


}
