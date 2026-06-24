package org.example.solid.LSK.good.example;

abstract class MenuItem {
    int price;
    String description;
    String name;

    public MenuItem (int price, String description, String name) {
        this.description = description;
        this.name = name;
        this.price = price;
    }

    public int getPrice(){
        return this.price;
    }

    public abstract int getDiscount();

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
// now there are only few item which has discount ie. BeverageItem
class BeverageItem extends MenuItem{

    BeverageItem(int price,String description,String name ){
        super(price,description,name);
    }

    @Override
    public int getPrice(){
        return this.price - getDiscount();
    }

    @Override
    public int getDiscount() {
        return  (int) ((10 * 0.01) * this.price);
    }

   /* private int getDiscount(int discountRatio){
        return (int) ((discountRatio * 0.01) * this.price);
    }*/
}


public class LSK_With_Good_LSK {

    //calling code
    public static void processMenus(MenuItem menuItem){

        System.out.println(menuItem.getPrice());
    }

    public static void main(String... e){
        BeverageItem beverageItem = new BeverageItem(300,"mint","mojito");
       // MenuItem m = new MenuItem(400,"mint","mojito");
        LSK_With_Good_LSK.processMenus(beverageItem);
        //LSK_With_Good_LSK.processMenus(m);
    }
}
