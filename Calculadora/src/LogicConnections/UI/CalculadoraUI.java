/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicConnections.UI;
import java.io.*;
import Logic.Calculadora;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jeukel
 */
public class CalculadoraUI{
    
    public static void controlFlow() throws Exception {
        Calculadora calc = new Calculadora();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("\n\t=========================================");		
        System.out.println("\n\t    Calculadora de Nomios y Bonomios ");
        System.out.println("\n\t=========================================");

        System.out.println("\n\t");
        System.out.println("Introduzca secuencialmente los nomios con el formato correcto");
        System.out.println("A B C | D E F | H I J");
        System.out.println("\n\t");
        System.out.println("¿Cual es el primero operando?");
        String opd1 = br.readLine();
        System.out.println("\n\t");
        
        System.out.println("¿Cual es el operandor para dicho nomio?");        
        String opr = br.readLine();
        System.out.println("\n\t");
        
        calc.setList(opd1,opr);
        
        System.out.println("¿Cual es el segundo operando?");
        String opd2 = br.readLine();
        System.out.println("\n\t");

        System.out.println("La ciudad de Mainframe ha votado y la solución es:");
        System.out.println("\n\t");
        String result = calc.setList(opd2);
        System.out.println(result);
    }
    
    public static void test01(){
        Calculadora calc = new Calculadora();
        String opd = "2 3 4 | 3 2 1 | 2 1 3";
        //calc.dividePoli(opd, 0);
    }
    
    public static void test02(){
        Calculadora calc = new Calculadora();
        String opd1 = "1 2 3 | 4 5 6 | 7 8 9";
        //calc.dividePoli(opd1, 0);
        String opd2 = "9 8 7 | 6 5 4 | 3 2 1";
        //calc.dividePoli(opd2, 1);
    }
    
    public static void test03(){
        Calculadora calc = new Calculadora();
        String opd1 = "2 3 4 | 3 2 1 | 2 1 3";
        calc.setList(opd1, "+");
        String opd2 = "3 2 1 | 2 3 4 | 2 1 3";
        String result = calc.setList(opd2);
        System.out.println(result);
    }
    
    public static void test04(){
        Calculadora calc = new Calculadora();
        String opd1 = "2 3 4 | 3 2 1 | 2 1 3";
        calc.setList(opd1, "-");
        String opd2 = "3 2 1 | 2 3 4 | 2 1 3";
        String result = calc.setList(opd2);
        System.out.println(result);
    }
    
    public static void test05(){
        Calculadora calc = new Calculadora();
        String opd1 = "2 3 4 | 3 2 1 | 2 1 3";
        calc.setList(opd1, "*");
        String opd2 = "3 2 1 | 2 3 4 | 2 1 3";
        String result = calc.setList(opd2);
        System.out.println(result);
    }
    
    public static void test06(){
        Calculadora calc = new Calculadora();
        String opd1 = "2 3 4 | 3 2 1 | 2 1 3";
        calc.setList(opd1, "*");
        int[] eva = {2,3};
        String result = calc.setList(eva);
        System.out.println(result);
    }
    
    public static void main(String [] args) {
        try {
            controlFlow();
        } catch (Exception ex) {
            Logger.getLogger(CalculadoraUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
