package interviews.java8;

import java.io.Serializable;

@AuthorAnnotation(Name = "mnsd",Email = "mnsd#gmail.com", EmployeeType = "permanent")
public class Employee implements Serializable {

    private static final Long serialVersionUID=1L;
    private String name;
    private Integer id;

    public Employee(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
