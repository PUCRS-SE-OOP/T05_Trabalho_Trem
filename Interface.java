import java.util.Scanner;

public class Interface{
    private Scanner in;
    private int tremNum;
    private Locomotiva locomotiva;
    private Vagao vagao;
    private CadastroLocomotiva cl;
    private CadastroVagao cv;
    private CadastroTrem ct;

    public Interface(){
        cl = new CadastroLocomotiva();
        cv = new CadastroVagao();
        ct = new CadastroTrem();
        inicializa();
    }
    
    private void inicializa(){
        cv.newVagao("X740","transporte", 40);
        cv.newVagao("X744","transporte", 44);
        cv.newVagao("X747","transporte", 47);
        cv.newVagao("X742","transporte", 42);
        cv.newVagao("X752","transporte", 52);
        cv.newVagao("X768","transporte", 68);
        cv.newVagao("X722","transporte", 22);
        cv.newVagao("X714","transporte", 14);
        cv.newVagao("X716","transporte", 16);
        cv.newVagao("X732","transporte", 32);
        
        cl.newLocomotiva("C-21", 2000);        
        cl.newLocomotiva("C-22", 2200);        
        cl.newLocomotiva("C-23", 2300);        
        cl.newLocomotiva("C-24", 2400);        
        cl.newLocomotiva("C-25", 2500);
    }


    public void menu(){
        in = new Scanner(System.in);
        while(true){
            System.out.println("\n--------Menu--------");
            System.out.println("1 - Cadastrar Trem" +
                             "\n2 - Acrescentar locomotiva ao trem"+
                             "\n3 - Acrescentar vagao ao trem"+
                             "\n4 - Remover locomotiva do trem"+
                             "\n5 - Remover vagao do trem"+
                             "\n6 - Imprimir composição do(s) trem(ns)"+
                             "\n7 - Fechar programa");

            String menuR = "";
            menuR = in.next();
        
            switch(menuR){
                case "1" : CadastroTrem(); break;
                case "2" : joinLocomotiva(); break;
                case "3" : joinVagao(); break;
                case "4" : removeLocomotiva(); break;
                case "5" : removeVagao(); break;
                case "6" : if(ct.toString().equals("")){
                            System.out.println("Nenhum trem cadastrado."); break;
                            }
                            System.out.println(ct);
                            break;
                case "7" : System.exit(0);
                default : menuR = in.nextLine(); //System.out.println("Valor inválido (Err Scanner).");
            }
        }
    }

    private void CadastroTrem(){
        in = new Scanner(System.in);
        
        locomotiva = getLocomotiva();
        if(locomotiva != null){
            if(ct.newTrem(locomotiva))
                System.out.println("Trem criado.");
            else
                System.out.println("A locomotiva ja esta sendo usada. O trem nao pode ser criado.");
        }else 
        System.out.println("Locomotiva não encontrada.");
    }

    private void joinLocomotiva(){        
        in = new Scanner(System.in);

        locomotiva = getLocomotiva();
        if(locomotiva != null){
            tremNum = getTrem();
            if(tremNum != -1){
            if(ct.joinLocomotiva(locomotiva, tremNum))
                System.out.println("Locomotiva inserida no trem.");
            else
                System.out.println("A locomotiva ja esta sendo usada e nao foi inserida.");
            }else System.out.println("Trem não encontrado");
            }else
        System.out.println("Locomotiva não encontrada.");
    }

    private void joinVagao(){
        in = new Scanner(System.in);

        vagao = getVagao();
        if(vagao != null){
            tremNum = getTrem();
            if(tremNum != -1){
                if(ct.joinVagao(vagao, tremNum))
                    System.out.println("Vagao inserido no trem.");
                else
                    System.out.println("O vagao ja esta sendo usado e nao foi inserido.");
            }else System.out.println("Trem nao encontrado");
        }else
        System.out.println("Vagao nao encontrado.");
    }

    private void removeLocomotiva(){
        in = new Scanner(System.in);

        tremNum = getTrem();
        if(tremNum != -1){
            if(ct.qtdLocomotivas(tremNum) == 1)
                System.out.println("O trem nao pode ficar sem locomotivas.");
            else{
                locomotiva = getLocomotiva(tremNum);
                if(locomotiva != null)
                    if(ct.removeLocomotiva(locomotiva, tremNum))
                        System.out.println("Locomotiva removida.");
                    else
                        System.out.println("Esta locomotiva nao faz parte deste trem.");
                else
                    System.out.println("Locomotiva nao encontrada");
            }
        }else System.out.println("Trem nao encontrado");
    }

    private void removeVagao(){
        in = new Scanner(System.in);

        tremNum = getTrem();
            if(tremNum != -1){
                vagao = getVagao(tremNum);
                if(vagao != null){
                    if(ct.removeVagao(vagao, tremNum))
                        System.out.println("Vagao removido.");
                    else
                        System.out.println("Este vagao nao faz parte do trem selecionado.");
            }else
                System.out.println("Vagão não encontrado."); 
        } else
            System.out.println("Trem não encontrado.");
    }

    private Locomotiva getLocomotiva(){
        in = new Scanner(System.in);

        System.out.println(cl);
        System.out.println("\nDigite o nome da locomotiva a ser inserida.");
        String locomotivaName = in.nextLine();
        locomotivaName = locomotivaName.toUpperCase();
        locomotiva = cl.findLocomotiva(locomotivaName);
    return locomotiva;
    }

    private Locomotiva getLocomotiva(int trem){
        in = new Scanner(System.in);

        System.out.println(ct.printTrem(trem));
        System.out.println("\nDigite o nome da locomotiva a ser inserida.");
        String locomotivaName = in.nextLine();
        locomotivaName = locomotivaName.toUpperCase();
        locomotiva = cl.findLocomotiva(locomotivaName);
    return locomotiva;
    }

    private Vagao getVagao(){
        in = new Scanner(System.in);

        System.out.println(cv);
        System.out.println("\nDigite o nome do vagao a ser inserido.");
        String vagaoName = in.nextLine();
        vagaoName = vagaoName.toUpperCase();
        vagao = cv.findVagao(vagaoName);
    return vagao;
    }

    private Vagao getVagao(int trem){
        in = new Scanner(System.in);

        System.out.println(ct.printTrem(trem));
        System.out.println("\nDigite o nome do vagao a ser removido.");
        String vagaoName = in.nextLine();
        vagaoName = vagaoName.toUpperCase();
        vagao = cv.findVagao(vagaoName);
    return vagao;
    }
    

    private int getTrem(){
        in = new Scanner(System.in);

        System.out.println(ct);
        System.out.println("\nDigite o numero do trem a ser selecionado;");
        int tremNumber = in.nextInt();
        if(tremNumber >= ct.size() || tremNumber < 0){
            tremNumber = -1;
        }
        return tremNumber;
    }

}