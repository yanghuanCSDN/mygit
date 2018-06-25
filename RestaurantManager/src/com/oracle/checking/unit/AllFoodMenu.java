package com.oracle.checking.unit;
//menu ¿‡
public class AllFoodMenu {
        private int id;
        private String name;
        private double price;
        private double discount;
      public int getId() {
	       return id;
     }
     public String getName() {
	      return name;
     }
     public double getPrice() {
	      return price;
     }
    
     public double getDiscount() {
	      return discount;
     }
     public AllFoodMenu(int id,String name,double price,double discount){
    	 this.id=id;
    	 this.name=name;
    	 this.price=price;
    	 this.discount=discount;
    	 
     }
 
}
