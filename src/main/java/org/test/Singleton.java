package org.test;

import java.io.Serializable;

public class Singleton implements Cloneable, Serializable {
    public static Singleton singleton = null;

    private Singleton() {

    }

    public static Singleton getSingletonObj() {
        if (singleton==null) {
            singleton = new Singleton();
        }
        return singleton;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
       return getSingletonObj();
    }

    public Object readResolve(){

        return getSingletonObj();
    }
}

//dr1 to dr100
//each dir has 1 to 25
//<dir1, list<dir>
