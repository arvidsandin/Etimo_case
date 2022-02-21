public class Store {

    private int inventory = 0;

    public int sell(int amount) throws EmptyInventoryException{
        if (inventory - amount < 0){
            throw new EmptyInventoryException();
        }
        inventory -= amount;
        return inventory;
    }

    public int procure(int amount){
        inventory += amount;
        return inventory;
    }

    public int getInventory(){
        return inventory;
    }

}
