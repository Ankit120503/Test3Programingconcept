package com.example.csd214test3ankitkumar;


public class PizzaOrder {

        private int ID;
        private String CustomerName;
        private String MobileNumber;
        private String PizzaSize;
        private String Toppings;
        private String Bill;

        public PizzaOrder(int ID, String CustomerName, String MobileNumber, String PizzaSize, String Toppings, String Bill) {
            this.ID = ID;
            this.CustomerName = CustomerName;
            this.MobileNumber = MobileNumber;
            this.PizzaSize = PizzaSize;
            this.Toppings = Toppings;
            this.Bill = Bill;
        }

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public String getCustomerName() {
            return CustomerName;
        }

        public void setCustomerName(String CustomerName) {
            this.CustomerName = CustomerName;
        }

        public String getMobileNumber() {
            return MobileNumber;
        }

        public void setMobileNumber(String MobileNumber) {
            this.MobileNumber = MobileNumber;
        }

        public String getPizzaSize() {
            return PizzaSize;
        }

        public void setPizzaSize(String PizzaSize) {
            this.PizzaSize = PizzaSize;
        }

        public String getToppings() {
            return Toppings;
        }

        public void setToppings(String Toppings) {
            this.Toppings = Toppings;
        }

        public String getBill() {
            return Bill;
        }

        public void setBill(String Bill) {
            this.Bill = Bill;
        }
    }

