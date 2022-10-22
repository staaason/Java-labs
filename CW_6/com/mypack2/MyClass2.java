package com.mypack2;
public class MyClass2 {
    String name  = "Stas";
    protected  String getName(){
        return name;
    }
    public void foo(){
        System.out.println(getName());
    }
}
