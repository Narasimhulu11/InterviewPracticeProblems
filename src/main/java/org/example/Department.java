package org.example;

import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Setter
public class Department implements Cloneable{
    Long id;
    String name;

    public Department(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    @Override
    public Object clone() throws CloneNotSupportedException {

        return super.clone();
    }
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static void main(String args[]){
        List<Employeee> employeeeList = new ArrayList<>();
      /*  employeeeList = Arrays.asList(new Employeee(1L, 1L,"SE"),
                new Employeee(1L,2L,"SE"),new Employeee(1L,1L,"SE2"),
                new Employeee(1L,2L,"SE2"),new Employeee(2L,2L,"SE3")
                ,new Employeee(1L,2L,"SE3"), new Employeee(2L,1L,"SE"),
                new Employeee(2L,1L,"SE"));*/
        List<Department> deptList = new ArrayList<>();
        deptList = Arrays.asList(new Department(1L,"Finance"), new Department(2L,"IT"));
          Map<String, Long> designationCount = employeeeList.stream()
                .collect(Collectors.groupingBy(Employeee::getDesignation, Collectors.counting()));

        Long maxCount = designationCount.values().stream()
                .max(Long::compare)
                .orElse(0L);

        List<String> maxDesignations = designationCount.entrySet().stream()
                .filter(entry -> entry.getValue().equals(maxCount))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        List<Department> finalDeptList = deptList;
        Map<String, List<String>> designationToDeptNames = employeeeList.stream()
                .filter(emp -> maxDesignations.contains(emp.getDesignation()))
                .collect(Collectors.groupingBy(Employeee::getDesignation,
                        Collectors.mapping(emp -> finalDeptList.stream()
                                .filter(dept -> dept.getId().equals(emp.getDeptId()))
                                .findFirst()
                                .get()
                                .getName(), Collectors.toList())));

        System.out.println("Designations and departments with maximum designation count: " + designationToDeptNames);
   
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
