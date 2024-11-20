/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.stacks;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Abc
 */
public class Reversing_an_integer_with_Stacks {
     public static void main(String[] args) {
        
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter a number: ");
    int input = scan.nextInt();
    scan.close();
    
        Stack<Integer> stack = new Stack<>();
        
        while(input!=0){
            stack.push(input % 10);
            input /= 10;
        }
            int reversed = 0;
            int multiplier = 1;
     while(!stack.isEmpty()){
         reversed += stack.pop()* multiplier;
         multiplier *= 10;
     }
         System.out.println("Reversed Integer: "+reversed);
    }
}
