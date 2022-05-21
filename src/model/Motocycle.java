package model;

public class Motocycle extends Vehicle implements CalculateGasoline{
    private double gasolineCapacity;
    private double gasolineConsume;//Este creo que es una interfaz la cual se calcula para saber cuanta gasolina consume de estop.
    private MotocycleType typeMotocycle;
    private TypeGasoline typeGasoline;
    public Motocycle(int optionAlreadyUsed, double basePrice, double sellPrice, String mark, int model,
        double cilinderCapacity, double kilometers, String placa,int optionTypeMotocycle,double gasolineCapacity,String soatNumber,double soatMoney,int soatDay,int soatMonth,
        int soatYear,String soatImage,String technoNumber,int technoMDay,int technoMMonth,int technoMYear,String tehnoImage,int optioTypeGasoline) {
            super(optionAlreadyUsed, basePrice, sellPrice, mark, model, cilinderCapacity, kilometers, placa,
            soatNumber,soatMoney,soatDay,soatMonth,soatYear,soatImage,technoNumber,technoMDay,technoMMonth,technoMYear,tehnoImage );
            this.gasolineCapacity = gasolineCapacity;
            switch(optionTypeMotocycle){
                case 1:
                    this.typeMotocycle=MotocycleType.STANDAR;
                    break;
                case 2:
                    this.typeMotocycle=MotocycleType.SPORT;
                    break;
                case 3:
                    this.typeMotocycle=MotocycleType.SCOOTER;
                    break;
                case 4:
                    this.typeMotocycle=MotocycleType.CROSS;
                    break;
            }
            this.gasolineConsume = calculateGasolineConsume();
            switch(optioTypeGasoline){
                case 1:
                    this.setTypeGasoline(TypeGasoline.EXTRA);
                    break;
                case 2:
                    this.setTypeGasoline(TypeGasoline.CORRIENTE);
                    break;
                case 3:
                    this.setTypeGasoline(TypeGasoline.DIESEL);
                    break;

            }
    }

    public TypeGasoline getTypeGasoline() {
        return typeGasoline;
    }

    public void setTypeGasoline(TypeGasoline typeGasoline) {
        this.typeGasoline = typeGasoline;
    }

    @Override
    public double calculateSellPrice(){
        double price;
        double anExtra = seachDocuments();
        if(super.getAlreadyUsed()==true)
            price = ((super.getBasePrice()*0.04)+super.getBasePrice())-super.getBasePrice()*0.02;
        else
            price = ((super.getBasePrice()*0.04)+super.getBasePrice());

        
            price += anExtra;

        return price; 
    }

    public double calculateGasolineConsume(){
        return gasolineCapacity*(super.getCilinderCapacity()/75);
    }

    @Override
    public String toString() {
        return super.toString()+"\nGasoline Capacity:" + gasolineCapacity + "\nGasolineConsume:" + gasolineConsume
                + "\nType Motocycle" + typeMotocycle+"\n/////////////////////////////" ;
    }
    
}
