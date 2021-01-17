package com.company;

import java.math.*;
  public class Parallelepiped {
    float Fa; //  сторона
    float Fb; // сторона
    float Fc; // сторона
    double V; // объем
    double S; // площадь
    public Parallelepiped(int a, int b,int c){
        Fa = a;
        Fb = b;
        Fc = c;
    }
    void PlosS(){
        double S = 2*(Fa*Fb + Fa*Fc+Fb*Fc);
        System.out.println("Площадь: "+S);
    }
    void ObioV(){
        double V = Fa*Fb*Fc;
        System.out.println("Объем: "+V);
    }
    void kub(){
        if (Fa==Fb && Fb==Fc){System.out.println("Параллелипипед является кубом");}
        else {System.out.println("Параллелипипед не является кубом");}
    }
 public static void main(String[] args) {
        Parallelepiped cor1 = new Parallelepiped(4,3,4);
        Parallelepiped cor2 = new Parallelepiped(5,5,5);
        cor1.PlosS();
        cor1.ObioV();
        cor1.kub();
        cor2.PlosS();
        cor2.ObioV();
        cor2.kub();
    }

 }