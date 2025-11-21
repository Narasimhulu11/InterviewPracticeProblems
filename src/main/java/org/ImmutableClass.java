package org;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

final class ImmutableClass implements Serializable {
    private final String name;
    private final Map<String,String> map;

    public ImmutableClass(String name, Map<String, String> map) {
        this.name = name;
        Map<String,String> m=new HashMap<>();
        for(Map.Entry<String,String> entry:map.entrySet()){
            m.put(entry.getKey().toString(),entry.getValue());
        }
        this.map = m;
    }

    public String getName() {
        return name;
    }

    public Object readResolve(){
        return new ImmutableClass(this.name, this.map);
    }

    @Override
    public String toString() {
        return "ImmutableClass{" +
                "name='" + name + '\'' +
                ", map=" + map +
                '}';
    }

    public Map<String, String> getMap() {
        return map;
    }
    public static void main(String args[]) throws IOException, ClassNotFoundException {
        Map<String,String> m1 = new HashMap<>();
        m1.put("1","b");
        ImmutableClass o1 = new ImmutableClass("a",m1);
        System.out.println(o1);
        FileOutputStream outputStream = new FileOutputStream("test.txt");
        ObjectOutputStream outputStream1 = new ObjectOutputStream(outputStream);
        outputStream1.writeObject(o1);
        FileInputStream inputStream = new FileInputStream("test.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        ImmutableClass o2= (ImmutableClass)objectInputStream.readObject();
        System.out.println(o2);
        System.out.println(o1.hashCode()==o2.hashCode());
        objectInputStream.close();
        outputStream1.close();
    }
}
