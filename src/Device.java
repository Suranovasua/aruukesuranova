public class Device {
    private String type;
    private double price;
    private double weight;
    private String model;
    private double storage;

    public Device(String type, double price, double weight, String model, double storage ){
        this.type = type;
        this.price = price;
        this.weight = weight;
        this.model= model;
        this.storage= storage;

    }

    public String getType() {
        return this.type;
    }
    public double getPrice(){
        return this.price;
    }
    public double getWeight(){
        return this.weight;
    }
    public String getModel(){
        return this.model;
    }
    public double getStorage(){
        return this.storage;
    }
    public void setType(String type){
        this.type=type;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setStorage(double storage) {
        this.storage = storage;
    }
}