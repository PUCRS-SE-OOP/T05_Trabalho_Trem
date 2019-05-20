public class Locomotiva{
    private final String SM = "CV";
    private boolean trash;
    private boolean used;
    private int power;
    private String name;

    public Locomotiva(String name, int power){
        if(power > 1){
            this.name = name;
            this.power = power;
            used = false;
        }
        trash = true;
    }

    public String toString(){
        String linha = "";
        linha += "\nLocomotiva " + name;
        linha += "\nPotencia: " + power + " "+SM;
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