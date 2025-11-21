package org.test;

public class ImplementationClass implements Interface1, Interface2{
    public static void main(String args[]){
        ImplementationClass implementationClass = new ImplementationClass();
        implementationClass.display();
    }

    // @Override
    public void display() {
        //Interface1.super.display();
        //Interface2.super.display();
        System.out.println("Implementation class");
    }
}
