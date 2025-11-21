package org.example;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employeee implements Cloneable{
        //implements Comparable<Employeee>{
    Long empId;
    Long deptId;
    String designation;
    Department department;

    public Department getDepartment() {
        return department;
    }

    public Employeee(Long empId, Long deptId, String designation, Department department) {
        this.empId = empId;
        this.deptId = deptId;
        this.designation = designation;
        this.department=department;
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        Employeee cloned = (Employeee) super.clone();
        cloned.department = (Department) department.clone(); // Deep copy of address
        return cloned;
    }
    public Long getEmpId() {
        return empId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public String getDesignation() {
        return designation;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
/*  @Override
    public int compareTo(Employeee o) {
        if (this.designation.compareTo(o.designation) != 0) {
            return this.designation.compareTo(o.designation);
        }

        // If strings are the same,
        // compare based on the integer value
        return (int) (this.empId - o.empId);
    }
*/


    @Override
    public String toString() {
        return "Employeee{" +
                "empId=" + empId +
                ", deptId=" + deptId +
                ", designation='" + designation + '\'' +
                ", department=" + department +
                '}';
    }

}
