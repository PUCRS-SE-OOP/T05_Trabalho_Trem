public class Vagao{
    private final String Acomodacao = "assento(s)";
    private final String SM = "kg";
    private boolean trash;
    private boolean used;
    private int capacidade;
    private String type;
    private String name;


    public Vagao(String name, String type, int i){
        type = type.toUpperCase();
        if(type.equals("CARGA") || type.equals("TRANSPORTE")){
            this.capacidade = i;
            this.type = type;
            this.name = name;
            used = false;
        }
        trash = true;
    }

    public String toString(){
        String linha = "";
        linha += "\nVagao " + name;
        linha += "\nVagao de " + type.toLowerCase();
        linha += "\nCapacidade: " + capacidade;

        if(type.equals("Carga"))
        linha += " " + SM;
        else
        linha += " " + Acomodacao;

    return linha;
    }

    public String getName(){
        return name;
    }

    public boolean isTrash(){
        return trash;
    }

    public void using(boolean i){
        used = i;
    }

    public boolean using(){
        return used;
    }
}