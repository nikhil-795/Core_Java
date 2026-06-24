package org.example.cloning;

class Address implements Cloneable{
    private int street;
    private String houseNo;

    public Address(int street, String houseNo) {
        this.street = street;
        this.houseNo = houseNo;
    }

    public int getStreet() {
        return street;
    }

    public void setStreet(int street) {
        this.street = street;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    @Override
    public Address clone() throws CloneNotSupportedException {
        return (Address)super.clone();
    }
}
class Person1 implements Cloneable{
    private int age;
    private String name;
    private Address address;

    public Person1(int age, String name,Address address) {
        this.age = age;
        this.name = name;
        this.address = address;
    }

   @Override
    public Person1 clone() throws CloneNotSupportedException{
        Person1 p =  (Person1)super.clone();
       p.address =  p.address.clone();
      /* p.address = new Address(p.getAddress().getStreet(),p.getAddress().getHouseNo()); */
               return p;
   }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Person1{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}


public class DeepCloningTest {

    public static void main(String... e) throws CloneNotSupportedException {
        Person1 p = new Person1(100, "Nikhil", new Address(8,"udaipur"));
        System.out.println(p);
        System.out.println(p.hashCode());

        Person1 p1 = p.clone();
        System.out.println(p1);
        System.out.println(p1.hashCode());

        p1.getAddress().setHouseNo("xyz");
        System.out.println(p.getAddress().getHouseNo());
        System.out.println(p1.getAddress().getHouseNo());

    }
}