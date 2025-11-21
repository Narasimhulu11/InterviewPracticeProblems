package org.example.tesco.container;

import org.example.Department;
import org.example.Employeee;

import java.util.ArrayList;

public class ShallowCopyAndDeepCopy {
    public static void main(String args[]) throws CloneNotSupportedException {
        Department d = new Department(1L,"cse");
        Employeee e = new Employeee(43L,32L,"sse", d);
      //  System.out.println(e);
        Employeee e1= (Employeee) e.clone();
        e1.setEmpId(32L);
        e1.getDepartment().setId(2L);
        System.out.println(e);
        System.out.println(e1);
      //  System.out.println(e==e1);
    }
}
