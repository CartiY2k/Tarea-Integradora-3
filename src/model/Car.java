package model;


public class Car extends Vehicle {
    private String numDoors;
    private boolean polarized;
    private TypeCar theTypeCar;
    public Car(int optionAlreadyUsed, double basePrice, double sellPrice, String mark, int model,
            double cilinderCapacity, double kilometers, String placa, String numDoors, int optionPolarized,
            int optionTheTyperCar,String soatNumber,double soatMoney,int soatDay,int soatMonth,
            int soatYear,String soatImage,String technoNumber,int technoMDay,int technoMMonth,int technoMYear,String tehnoImage) {
        super(optionAlreadyUsed, basePrice, sellPrice, mark, model, cilinderCapacity, kilometers, placa,soatNumber,
        soatMoney,soatDay,soatMonth,soatYear,soatImage,technoNumber,technoMDay,technoMMonth,technoMYear,tehnoImage);
        this.numDoors = numDoors;
        switch(optionPolarized){
            case 1:
                polarized = true;
                break;
            case 2:
                polarized = false;
                break;
        }
        switch(optionTheTyperCar){
            case 1: 
                this.theTypeCar =TypeCar.SEDAN;
                break;
            case 2: 
                this.theTypeCar = TypeCar.TRUCK;
                break;
        }
    }
    public Car(String numDoors, boolean polarized, TypeCar theTypeCar) {
        this.numDoors = numDoors;
        this.polarized = polarized;
        this.theTypeCar = theTypeCar;
    }
    @Override
    public double calculateSellPrice() {
        return 0;
    }
    
    @Override
    public String toString() {
        return super.toString()+"\nNumber Doors:" + numDoors + "\nPolarized:" + polarized + "\nType Car:" + theTypeCar;
    }
}
