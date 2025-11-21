package interviews.java8;

public class Fruits implements Cloneable{
    private String name;
    private String category;

    public Fruits(){
        super();
    }

    public Fruits(String name, String category){
        super();
        this.name =name;
        this.category=category;
    }

    public Fruits clone() throws CloneNotSupportedException {
        return (Fruits) super.clone();
    }
}
