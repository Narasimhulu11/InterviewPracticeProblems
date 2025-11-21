package interviews.java8;

import java.util.ArrayList;
import java.util.List;

public class FruitsBaskets implements Cloneable{
    private List<Fruits> fruitsList;

    public FruitsBaskets(List<Fruits> fruitsList) {
        this.fruitsList = fruitsList;
    }

    public List<Fruits> getFruitsList() {
        return fruitsList;
    }

    public void setFruitsList(List<Fruits> fruitsList) {
        this.fruitsList = fruitsList;
    }

    public FruitsBaskets clone() throws CloneNotSupportedException {
        FruitsBaskets fruitsBaskets= (FruitsBaskets) super.clone();
        List<Fruits> clonedFruits= new ArrayList<>();
        this.fruitsList.forEach(fruits -> {
            try {
                clonedFruits.add(fruits.clone());
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        });
        fruitsBaskets.setFruitsList(new ArrayList<>(this.getFruitsList()));
        return fruitsBaskets;
    }


}
