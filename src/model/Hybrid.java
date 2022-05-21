package model;

public class Hybrid extends Car implements CalculateGasoline,CalculateTheBattery{
    private double gasolineConsume;
    private double gasolineCapacity;
    private TypeGasoline typeGasoline;
    private TypeCharger typeCharger;
    private double batteryDuration;
    private double batteryConsume;
    
    public Hybrid(int optionAlreadyUsed, double basePrice, double sellPrice, String mark, int model,
        double cilinderCapacity, double kilometers, String placa, String numDoors, int optionPolarized,
        int optionTheTyperCar,double gasolineCapacity,int optionTypeGasoline,int optionTypeCharger,
        double batteryDuration,String soatNumber,double soatMoney,int soatDay,int soatMonth,
        int soatYear,String soatImage,String technoNumber,int technoMDay,int technoMMonth,int technoMYear,String tehnoImage ) {
        super(optionAlreadyUsed, basePrice, sellPrice, mark, model, cilinderCapacity, kilometers, placa, numDoors, optionPolarized, 
                optionTheTyperCar,soatNumber,soatMoney,soatDay,soatMonth,soatYear,soatImage,technoNumber,technoMDay,technoMMonth,technoMYear,tehnoImage );
                    this.gasolineCapacity = gasolineCapacity ;
                    this.gasolineConsume = calculateGasolineConsume() ;
                    this.batteryDuration = batteryDuration;
                    this.batteryConsume = calculateBatteryConsume();
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
                    switch(optionTypeCharger){
                        case 1:
                            typeCharger = TypeCharger.FAST;
                             break;
                        case 2:
                            typeCharger = TypeCharger.NORMAL;
                            break;
                        }
    }

    public Hybrid(String numDoors, boolean polarized, TypeCar theTypeCar, double gasolineConsume,
            double gasolineCapacity, TypeGasoline typeGasoline, TypeCharger typeCharger, double batteryDuration,
            double batteryConsume) {
        super(numDoors, polarized, theTypeCar);
        this.gasolineConsume = gasolineConsume;
        this.gasolineCapacity = gasolineCapacity;
        this.typeGasoline = typeGasoline;
        this.typeCharger = typeCharger;
        this.batteryDuration = batteryDuration;
        this.batteryConsume = batteryConsume;
    }

    @Override
    public double calculateSellPrice(){
        double price;
        double anExtra = seachDocuments();
        if(super.getAlreadyUsed()==true)
            price = ((super.getBasePrice()*0.15)+super.getBasePrice())-super.getBasePrice()*0.1;
        else
            price = ((super.getBasePrice()*0.15)+super.getBasePrice());

            price += anExtra;

        return price; 
    }
    public double calculateBatteryConsume(){
        double batteryConsume = 0.0;
        if(typeCharger == TypeCharger.FAST)
            batteryConsume = batteryDuration*(super.getCilinderCapacity()/200);
        else
            batteryConsume = (batteryDuration+7)*(super.getCilinderCapacity()/200);
            
        return batteryConsume;
    }

    @Override
    public double calculateGasolineConsume() {
        return 0;
    }

    @Override
    public String toString() {
        return super.toString()+"\nBattery Consume:" + batteryConsume + "\nBattery Duration:" + batteryDuration
                + "\nGasoline Capacity:" + gasolineCapacity + "\nGasolineConsume:" + gasolineConsume + "\nType Charger:"
                + typeCharger + "\nType Gasoline:" + typeGasoline+"\n/////////////////////////////" ;
    }
    
   
    

}
