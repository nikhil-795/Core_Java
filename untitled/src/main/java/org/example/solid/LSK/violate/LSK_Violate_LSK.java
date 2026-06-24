package org.example.solid.LSK.violate;

abstract class MenuItem1 {
    int price;
    String description;
    String name;

    public MenuItem1(int price, String description, String name) {
        this.description = description;
        this.name = name;
        this.price = price;
    }

    public int getPrice(){
        return this.price;
    }

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

class BeverageItem1 extends MenuItem1{

    BeverageItem1(int price,String description,String name ){
        super(price,description,name);
    }

    public int getDiscount(int discountRatio){
        return (int) ((int)this.price - ((discountRatio * 0.01) * this.price));
    }
}

//calling code


public class LSK_Violate_LSK {

    //violate LSK
    public static void processMenus(MenuItem1 menuItem){

        if(menuItem instanceof BeverageItem1){
            System.out.println("beverage-menu-item");
            //here we are not able to substitute the instance of menu item with the beverage item instance
            System.out.println(((BeverageItem1)menuItem).getDiscount(10));
        }else {
            System.out.println("non beverage ");
            System.out.println(menuItem.getPrice());
        }
    }

    public static void main(String... e){
        BeverageItem1 beverageItem = new BeverageItem1(300,"mint","mojito");

        LSK_Violate_LSK.processMenus(beverageItem);
    }
}
