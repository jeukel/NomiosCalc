/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;
import Datastructs.SimpleList.SimpleList;

/**
 *
 * @author jeukel
 */
public class Calculadora{
        
    //Operators (A,B) and Results (C) lists.
    private final SimpleList<Poli> A;
    private final SimpleList<Poli> B;
    private final SimpleList<Poli> C;
    private String operator;
    
    public Calculadora(){
        this.A = new SimpleList<>();
        this.B = new SimpleList<>();
        this.C = new SimpleList<>();
        operator = " ";
    }
    
    /**
     * Divide a string into separated elements to set a Poli
     * @param nomio
     * @param W 
     */
    private void dividePoli(String nomio, int W){
        String Num = "";
        String tmp = " ";
        if (nomio.charAt(0) == '|'){
            nomio = nomio.substring(1);
        }
        
        while (nomio.length() > 0){
            if(nomio.charAt(0) == ' '){
                nomio = nomio.substring(1);
            }

            if (nomio.charAt(0) == '|'){
                int poli = Integer.parseInt(Num);
                int a = poli/100;
                int x = (poli%100)/10;
                int y = poli%10;
                Poli elem = new Poli(a,x,y);                    
                //System.out.println(a);
                if(W == 0){
                    this.A.append(elem);
                }else{
                    this.B.append(elem);
                }
                
                nomio = nomio.substring(1);
                Num = "";
            }else{
                tmp = Character.toString(nomio.charAt(0));
                Num = Num.concat(tmp);                
            }
                
            if(nomio.length() == 1){
                int poli = Integer.parseInt(Num);
                int a = poli/100;
                int x = (poli%100)/10;
                int y = poli%10;
                Poli elem = new Poli(a,x,y);                 
                
                if(W == 0){
                    this.A.append(elem);
                }else{
                    this.B.append(elem);
                }
            }
            
            nomio = nomio.substring(1);
        }
        /*
        checkHeads();
        */
    }
    
    /**
     * Prints for the heads of A,B & C lists
     */
    private void checkHeads(){
        System.out.println("hello");
        if(this.A.getRootData() != null){
            System.out.print("A is: ");
            System.out.print(this.A.getRootData().getA());
            System.out.print(this.A.getRootData().getX());
            System.out.println(this.A.getRootData().getY());
        }
        if(this.B.getRootData() != null){
            System.out.print("B is: ");
            System.out.print(this.B.getRootData().getA());
            System.out.print(this.B.getRootData().getX());
            System.out.println(this.B.getRootData().getY());
        }
        if(this.C.getRootData() != null){
            System.out.print("C is: ");
            System.out.print(this.C.getRootData().getA());
            System.out.print(this.C.getRootData().getX());
            System.out.println(this.C.getRootData().getY());
        }
        System.out.println("bye");
    }
    
    /**
     * Return C list (results list) as a string for printing.
     * @return 
     */
    private String describe(){
        String result = " ";
        while(this.C.getRootData() != null){
            result = result.concat(Integer.toString(this.C.getRootData().getA()));
            result = result.concat(" ");
            result = result.concat(Integer.toString(this.C.getRootData().getX()));
            result = result.concat(" ");
            result = result.concat(Integer.toString(this.C.getRootData().getY()));
            if(this.C.length() != 1){
                result = result.concat(" | ");
            }            
            this.C.delete();
        }
        return result;
    }
    
    /**
     * Check for matching 
     */
    private void compare(){
        
        while(this.A.getRootData() != null){
            switch (this.operator) {
                case "+":
                    sum();
                    break;
                case "-":
                    res();
                    break;
                case "*":
                    mult();
                    break;
                default:
                    System.out.println("Who's this? No monkeys allowed.");
                    break;
            }
            
            this.A.delete();
        }
    }
    
    //Deletes "reverse" Polies...
    private boolean justForSum(){
        
            Poli paul = new Poli((this.A.getRootData().getA() * -1),
                                  this.A.getRootData().getX(),
                                  this.A.getRootData().getY());
            /**
            System.out.print("Paul is (besides dead): ");
            System.out.print(paul.getA());
            System.out.print(paul.getX());
            System.out.println(paul.getY());
            **/
            
            return this.B.delete(paul);
    }
    
    
    private void sum(){
        //Sum
        if(!justForSum()){
            SimpleList<Poli> W = new SimpleList<>(this.B);        
            while(W.getRootData() != null){
                if( (this.A.getRootData().getX() == W.getRootData().getX()) && 
                    (this.A.getRootData().getY() == W.getRootData().getY()) ){

                    int i = this.A.getRootData().getA() + W.getRootData().getA();
                    int j = this.A.getRootData().getX();
                    int k = this.A.getRootData().getY();
                    Poli pu = new Poli(i,j,k);
                    this.C.insert(pu);
                }
                /**
                checkHeads();
                if(W.getRootData() != null){
                    System.out.print("W is: ");
                    System.out.print(W.getRootData().getA());
                    System.out.print(W.getRootData().getX());
                    System.out.println(W.getRootData().getY());
                }**/
                W.delete();            
            }
        }        
    }
    
    private void mult(){
        //Mul
        SimpleList<Poli> W = new SimpleList<>(this.B);
        while(W.getRootData() != null){
                
            int i = this.A.getRootData().getA() * this.B.getRootData().getA();
            int j = this.A.getRootData().getX() + this.B.getRootData().getX();
            int k = this.A.getRootData().getY() + this.B.getRootData().getY();               

            Poli pu = new Poli(i,j,k);
            this.C.insert(pu);
            /**
            checkHeads();
            if(W.getRootData() != null){
                System.out.print("W is: ");
                System.out.print(W.getRootData().getA());
                System.out.print(W.getRootData().getX());
                System.out.println(W.getRootData().getY());
            }**/
            W.delete();
        }
    }
    
    private void res(){
        //Res
        SimpleList<Poli> W = new SimpleList<>(this.B);
        while(W.getRootData() != null){
            if( (this.A.getRootData().getX() == W.getRootData().getX()) && 
                (this.A.getRootData().getY() == W.getRootData().getY()) ){
                int j = 0;
                int k = 0;
                int i = this.A.getRootData().getA() - W.getRootData().getA();
                if (i != 0){
                    j = this.A.getRootData().getX();
                    k = this.A.getRootData().getY();
                }                
                Poli pu = new Poli(i,j,k);
                this.C.insert(pu);
            }
            /**
            checkHeads();
            if(W.getRootData() != null){
                System.out.print("W is: ");
                System.out.print(W.getRootData().getA());
                System.out.print(W.getRootData().getX());
                System.out.println(W.getRootData().getY());
            }**/
            W.delete();
        }
    }
    
    private void eval(int x, int y){
        double i = 0;
        while(A.getRootData() != null){
                
            i = i + this.A.getRootData().getA() + 
                Math.pow ( x,this.A.getRootData().getX() ) + 
                Math.pow ( y,this.A.getRootData().getY() );               

            
            /**
            checkHeads();
            if(W.getRootData() != null){
                System.out.print("W is: ");
                System.out.print(W.getRootData().getA());
                System.out.print(W.getRootData().getX());
                System.out.println(W.getRootData().getY());
            }**/
            A.delete();
        }
        Poli pu = new Poli((int)i,0,0);
        this.C.insert(pu);
    }
    
    //***********************************************************
    //***********************************************************
    //******************   Public Methods   *********************
    //***********************************************************
    //***********************************************************
    
    
    /**
     * Asks for what operator is for the procedure in question.
     * @return 
     */
    public String getOperator(){
        return this.operator;
    }
    /**
     * Clear all the list of operator and results.
     */
    public void resetCount(){
        this.A.clear();
        this.B.clear();
        this.C.clear();
    }
    
    /**
     * For use on "=" key.
     * @param nomio
     * @return 
     */
    public String setList(String nomio){
        dividePoli(nomio, 1);
        compare();        
        return describe();
    }
    
    /**
     * For use on eval key.
     * @param nomio
     * @return 
     */
    public String setList(int[] nomio){
        eval(nomio[0],nomio[1]);        
        return describe();
    }
    
    /**
     * For use with _ operand key.
     * @param nomio
     * @param op 
     */
    public void setList(String nomio, String op){
        dividePoli(nomio, 0);
        this.operator = op;
    }   
    
}
