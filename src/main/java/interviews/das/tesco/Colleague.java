package interviews.das.tesco;

import java.util.Objects;

public class Colleague {
    private int id;
    private String Name;

    public Colleague() {
    }

    public Colleague(int id, String name) {
        this.id = id;
        Name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Colleague colleague = (Colleague) o;
        return id == colleague.id && Objects.equals(Name, colleague.Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Name);
    }
}
