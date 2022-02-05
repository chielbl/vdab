package ehb.be.eindproject.model;

import java.util.ArrayList;

public enum  Order {

    INSTANCE;

    private ArrayList<Artikel> shoppingCar = new ArrayList<>();

    public ArrayList<Artikel> getShoppingCar() {
        return shoppingCar;
    }

    public void addItem(Artikel artikel){
        shoppingCar.add(artikel);
    }

    public void deleteItem(Artikel artikel){
        shoppingCar.remove(artikel);
    }
}
