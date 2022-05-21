package model;

public class Gasoline extends Car implements CalculateGasoline{
    private double gasolineCapacity;
    //Interfaz con la gasolina con la moto es por ende que se 
    private double gasolineConsume;
    private TypeGasoline typeGasoline;
    public Gasoline(int optionAlreadyUsed, double basePrice, double sellPrice, String mark, int model,
        double cilinderCapacity, double kilometers, String placa, String numDoors, int optionPolarized,
        int optionTheTyperCar,double gasolineCapacity,int optionTypeGasoline,String soatNumber,double soatMoney,int soatDay,int soatMonth,
        int soatYear,String soatImage,String technoNumber,int technoMDay,int technoMMonth,int technoMYear,String tehnoImage ) {
            super(optionAlreadyUsed, basePrice, sellPrice, mark, model, cilinderCapacity, kilometers, placa, numDoors, optionPolarized,optionTheTyperCar,soatNumber,
            soatMoney,soatDay,soatMonth,soatYear,soatImage,technoNumber,technoMDay,technoMMonth,technoMYear,tehnoImage);
            this.gasolineCapacity = gasolineCapacity ;
            this.gasolineConsume = calculateGasolineConsume() ;
            switch(optionTypeGasoline){
                case 1:
                    this.typeGasoline = TypeGasoline.CORRIENTE;
                    break;
                case 2:
                    this.typeGasoline = TypeGasoline.CORRIENTE;
                    break;
                case 3:
                    this.typeGasoline = TypeGasoline.CORRIENTE;
                    break;
            }
            

    } 
    @Override
    public double calculateSellPrice(){
        double anExtra = seachDocuments();
        double price = (super.getBasePrice()-super.getBasePrice()*0.10);
        price += anExtra;
        return price ; 
    }

    public double calculateGasolineConsume(){
        return gasolineCapacity*(super.getCilinderCapacity()/150);
    }
    public double getGasolineCapacity() {
        return gasolineCapacity;
    }
    public void setGasolineCapacity(double gasolineCapacity) {
        this.gasolineCapacity = gasolineCapacity;
    }
    public double getGasolineConsume() {
        return gasolineConsume;
    }
    public void setGasolineConsume(double gasolineConsume) {
        this.gasolineConsume = gasolineConsume;
    }
    public TypeGasoline getTypeGasoline() {
        return typeGasoline;
    }
    public void setTypeGasoline(TypeGasoline typeGasoline) {
        this.typeGasoline = typeGasoline;
    }
    @Override
    public String toString() {
        return super.toString()+"\nGasoline Capacity:" + gasolineCapacity + "\nGasoline Consume:" + gasolineConsume
                + "\nType Gasoline:" + typeGasoline +"\n/////////////////////////////";
    }
    

}
