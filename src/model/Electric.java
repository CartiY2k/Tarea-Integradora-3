package model;


public class Electric extends Car implements CalculateTheBattery{
    private TypeCharger typeCharger;
    private double batteryDuration;
    private double batteryConsume;

    public Electric(int optionAlreadyUsed, double basePrice, double sellPrice, String mark, int model,
         double cilinderCapacity, double kilometers, String placa, String numDoors, int optionPolarized,
         int optionTheTyperCar,int optionTypeCharger,double batteryDuration,String soatNumber,double soatMoney,int soatDay,int soatMonth,
         int soatYear,String soatImage,String technoNumber,int technoMDay,int technoMMonth,int technoMYear,String tehnoImage ) {
            super(optionAlreadyUsed, basePrice, sellPrice, mark, model, cilinderCapacity, kilometers, placa, numDoors, optionPolarized, 
                optionTheTyperCar,soatNumber,
                soatMoney,soatDay,soatMonth,soatYear,soatImage,technoNumber,technoMDay,technoMMonth,technoMYear,tehnoImage );
                this.batteryDuration = batteryDuration;
                this.batteryConsume = calculateBatteryConsume();
                    switch(optionTypeCharger){
                        case 1:
                            typeCharger = TypeCharger.FAST;
                            break;
                        case 2:
                            typeCharger = TypeCharger.NORMAL;
                            break;
                    }
    }

    public double calculateBatteryConsume(){
        double batteryConsume = 0.0;
        if(typeCharger == TypeCharger.FAST)
            batteryConsume = (batteryDuration+13)*(super.getCilinderCapacity()/100);
        else
            batteryConsume = (batteryDuration+18)*(super.getCilinderCapacity()/100);

        return batteryConsume;
    }

    @Override
    public double calculateSellPrice(){
        double price;
        if(super.getAlreadyUsed()==true)
            price = ((super.getBasePrice()*0.2)+super.getBasePrice())-super.getBasePrice()*0.1;
        else
            price = ((super.getBasePrice()*0.2)+super.getBasePrice());

        return price; 
    }

    @Override
    public String toString() {
        return super.toString()+"\nBattery Consume:" + batteryConsume + "\nBattery Duration:" + batteryDuration + "\nType Charger:"
                + typeCharger+"\n/////////////////////////////" ;
    }
    

}