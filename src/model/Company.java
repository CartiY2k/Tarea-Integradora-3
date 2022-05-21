package model;
import java.util.ArrayList;

public class Company{
    private String name; 
    //Relation:
    private ArrayList<Vehicle> vehicles;
    private Vehicle[][] parking;

    public Company(String name){
        this.name = name;
        vehicles = new ArrayList<Vehicle>();  
        parking = new Vehicle[10][5];
              
    }
/**
 * for know the list car that exit this moment
 * @param initialYear the fist year for create an interval
 * @param finalYear the last year for create an interval
 * @return messatge whoose said everthing 
 */
    public String  listVehicles(int initialYear,int finalYear){
        ArrayList<Vehicle> cars = new ArrayList<Vehicle>();
        for (int x = 0; x < parking.length; x++) {
            for (int y = 0; y < parking[0].length; y++) {
                if(parking[x][y]!=null){
                    cars.add(parking[x][y]);
                }
            }
        }
        String message = createdListM(cars,initialYear,finalYear);
        return message;
    }

    /**
 * for know the list car that exit this moment
 * @param initialYear the fist year for create an interval
 * @param finalYear the last year for create an interval
 * @return messatge whoose said everthing 
 */
    public String createdListM(ArrayList<Vehicle> cars,int initialYear,int finalYear){
        String message = "";
        for (int i = 0; i < cars.size(); i++) {
            if(cars.get(i).getModel()>=initialYear&&cars.get(i).getModel()<= finalYear){
                message = message+cars.get(i).toString();
            }
        }

        return message;
    }
    /**
     * 
     * @return message that said the  ocupation parking
     */
    public String parkingReport(){
        String message = "";
        int counter = 0;
        for (int x = 0; x < parking.length; x++) {
            for (int y = 0; y < parking[0].length; y++) {
                if(parking[x][y]!=null){
                    counter++;
                }
            }
        }
        counter = counter*100/50;
        message="The ocupation average in the parking is"+counter+"%";
        return message;
    }
    /**
     * It's fot create the owner car
     * @param plate is the value of plate
     * @param ownerDay is the value of owner Day
     * @param ownerMonth is the value of owner Month
     * @param ownerYear is the value of owner Year
     * @param ownerImage is the value of owner Image
     * @return
     */

    public String createdOwner(String plate,int ownerDay,int ownerMonth,int ownerYear,String ownerImage){
        boolean continue1 = true;
        String message = "";
        for (int i = 0; i < vehicles.size()&& continue1 != false; i++) {
            if(vehicles.get(i).getPlaca().equalsIgnoreCase(plate)){
                vehicles.get(i).createdOwner(ownerDay, ownerMonth, ownerYear, ownerImage);
                continue1 = false;

            }
        }
        message = "Created OwnerCard";
        return message;
    }

    /**
     * For sech The plate
     * @param plate
     * @return id the plate exist
     */

    public boolean serchplate(String plate){
        boolean answer = true;
        for (int i = 0; i < vehicles.size()&&answer != false; i++) {
            if(vehicles.get(i).getPlaca().equalsIgnoreCase(plate)){
                answer = false;
            }
        }
        return answer;
    }
    /**
     * You just have to wait a the magic come to you, because it's methos was created with an only motive.
     * @param mark is the mark of the vehicle
     * @param model is the mark of the vehicle
     * @param optionSelectType is the mark of the vehicle
     * @param plate is the mark of the vehicle
     * @return the answer of the serch
     */
    public boolean serchVehicle(String mark,int model,int optionSelectType,String plate){
        boolean answer = false;
        boolean continue1 = true;
        switch(optionSelectType){
            case 1:
                for (int i = 0; i < vehicles.size()&& continue1 != false; i++) {
                    if(vehicles.get(i).getModel()==model&&vehicles.get(i).getMark().equalsIgnoreCase(mark)&&vehicles.get(i).getAlreadyUsed()==false&&vehicles.get(i) instanceof Car&&vehicles.get(i).getPlaca().equalsIgnoreCase("It will be assign")){
                        continue1 = false;
                        answer = true;
                        vehicles.get(i).setPlaca(plate);
                    
                    }
                }
                break;
            case 2:
                for (int i = 0; i < vehicles.size()&& continue1 != false; i++) {
                    if(vehicles.get(i).getMark().equalsIgnoreCase(mark)&&vehicles.get(i).getModel()==model&&vehicles.get(i) instanceof Motocycle&&vehicles.get(i).getAlreadyUsed()==false&&vehicles.get(i).getPlaca().equalsIgnoreCase("It will be assign")){
                        continue1 = false;
                        answer = true;
                        vehicles.get(i).setPlaca(plate);
                    }
                }
                break;
        }
        return answer;
    }
    /** @param soatNumber this is the  soat Number  of the vehicle
     * @param soatMoney this is the  soat Money of the vehicle
     * @param soatDay this is the soat Day of the vehicle
     * @param soatMonth this is the soat Month of the vehicle
     * @param soatYear this is the soat Year of the vehicle
     * @param soatImage this is the soat Image of the vehicle
     * @param technoNumber this is the  techno Number of the vehicle
     * @param technoMDay this is the technoM Day of the vehicle
     * @param technoMMonth this is the technoM Month of the vehicle
     * @param technoMYear this is the technoM Year of the vehicle
     * @param tehnoImage this is the tehno Image of the vehicle
     */
    public void createdSoatTechnoMec(double soatMoney,int soatDay,int soatMonth,int soatYear,
        String soatImage,int technoMDay,int technoMMonth,int technoMYear,String technoImage,String plate){
            boolean continue1 = true;
            for (int i = 0; i < vehicles.size()&&continue1!= false; i++) {
                if(vehicles.get(i).getPlaca().equalsIgnoreCase(plate)){
                    vehicles.get(i).SoatAnDocum(soatMoney,soatDay,soatMonth,soatYear,soatImage,technoMDay,technoMMonth,technoMYear,technoImage);
                    continue1 = false;
                    
                }
            }
    }


    
/**
 * for save the car postions in the parking
 * @param model != null
 * @param lisencePlate != null
 */

    public void theParking(int model ,String lisencePlate){
        boolean flag = true;
        int lastVehicle = vehicles.size()-1;
        if(model==2014){
            for (int i = 0; i < parking[0].length&&flag != false; i++) {
                if(parking[i][0]==null){
                    parking[i][0]=vehicles.get(lastVehicle);
                    flag = false;
                }
            }
        }else if(model==2013){
            for (int i = 0; i < parking[0].length&&flag != false; i++) {
                if(parking[i][1]==null){
                    parking[i][1]=vehicles.get(lastVehicle);
                    flag = false;
                }
            }

        }else if(model==2012){
            for (int i = 0; i < parking[0].length&&flag != false; i++) {
                if(parking[i][2]==null){
                    parking[i][2]=vehicles.get(lastVehicle);
                    flag = false;
                }
            }

        }else if(model==2011){
            for (int i = 0; i < parking[0].length&&flag != false; i++) {
                if(parking[i][3]==null){
                    parking[i][3]=vehicles.get(lastVehicle);
                    flag = false;
                }
            }
        }else if(model<2011){
            for (int i = 0; i < parking[0].length&&flag != false; i++) {
                if(parking[i][4]==null){
                    parking[i][4]=vehicles.get(lastVehicle);
                    flag = false;
                }
            }
        }
    }
/**
 * for show all of the vehicle
 * @param plate !!= null
 * @return
 */
    public String consultVehicle(String plate){
        String message = "The plate:"+plate+" doesn't have documents\n";
        for (int i = 0; i < vehicles.size(); i++){
            if(vehicles.get(i).getPlaca().equals(plate)){
                message = "";
                message = vehicles.get(i).allDocument();
            }
        }
        return message;
    }

    /**
     * for report new and used cars in the company
     * @return
     */
    public String [] reportNewUsedCars(){
        String[] message = new String[2];
        String messageNew = "";
        String messageUsed = "";
        for (int i = 0; i < vehicles.size(); i++){
            if(vehicles.get(i).getAlreadyUsed() == true)
                messageNew = messageNew+"\n"+vehicles.get(i).toString();
            else
                messageUsed = messageUsed+"\n"+vehicles.get(i).toString();
        }
        message[0]=messageNew;
        message[1]=messageUsed;

        return message;
    }

    /**
     * For report vehicle type
     * @return
     */

    public String[] reportTypeVehicle(){
        String[] message = new String[4];
        String messageGasoline = "";
        String messageHybrid = "";
        String messageElectric = "";
        String messageMotoCycle = "";
        for (int i = 0; i < vehicles.size(); i++){
            if(vehicles.get(i) instanceof Gasoline){
                messageGasoline = messageGasoline+"\n"+vehicles.get(i).toString();
            }else if(vehicles.get(i) instanceof Hybrid){
                messageHybrid = messageHybrid+"\n"+vehicles.get(i).toString();
            }else if(vehicles.get(i) instanceof Electric){
                messageElectric = messageElectric+"\n"+vehicles.get(i).toString();
            }else if(vehicles.get(i) instanceof Motocycle){
                messageMotoCycle = messageMotoCycle+"\n"+vehicles.get(i).toString();
            }    
        }
        message[0]= messageGasoline;
        message[1]= messageHybrid;
        message[2]= messageElectric;
        message[3]= messageMotoCycle;

        return message;
        
    }
    /**
     * This method report in a message the type of fuel for each vehicle
     * @return
     */

    public String [] reportTypeFuel(){
        String [] message = new String [3];
        String messageExtra = "";
        String messageCorriente = "";
        String messageDiesel = "";
        for (int i = 0; i < vehicles.size(); i++) {
            if(vehicles.get(i) instanceof Gasoline){
                Gasoline obj = (Gasoline)vehicles.get(i);
                if(obj.getTypeGasoline() == TypeGasoline.EXTRA){
                    messageExtra = messageExtra+"\n"+vehicles.get(i).toString();
                }else if(obj.getTypeGasoline() == TypeGasoline.CORRIENTE){
                    messageCorriente = messageCorriente+"\n"+vehicles.get(i).toString();

                }else if(obj.getTypeGasoline() == TypeGasoline.DIESEL){
                    messageDiesel = messageDiesel+"\n"+vehicles.get(i).toString();
                }
            }if(vehicles.get(i) instanceof Motocycle){
                Motocycle obj = (Motocycle)vehicles.get(i);
                if(obj.getTypeGasoline() == TypeGasoline.EXTRA){
                    messageExtra = messageExtra+"\n"+vehicles.get(i).toString();
                }else if(obj.getTypeGasoline() == TypeGasoline.CORRIENTE){
                    messageCorriente = messageCorriente+"\n"+vehicles.get(i).toString();

                }else if(obj.getTypeGasoline() == TypeGasoline.DIESEL){
                    messageDiesel = messageDiesel+"\n"+vehicles.get(i).toString();
                }
            }
        }
        message[0]= messageExtra;
        message[1]= messageCorriente;
        message[2]= messageDiesel;

        return message;
    }
    /**
     * To register an Gasoline Car
     * I created this method just for take more especific information .
     * @param optionAlreadyUsed this value say me if the vehicle Has been used
     * @param basePrice this is the base price of the vehicle
     * @param sellPrice this is the price of the vehicle
     * @param mark this is the mark of the vehicle
     * @param model this is the model of the vehicle
     * @param cilinderCapacity this is the cilinderCapacity of the vehicle
     * @param kilometers this is the cilinderCapacity of the vehicle
     * @param plate this is the plate of the vehicle
     * @param soatNumber this is the  soat Number  of the vehicle
     * @param soatMoney this is the  soat Money of the vehicle
     * @param soatDay this is the soat Day of the vehicle
     * @param soatMonth this is the soat Month of the vehicle
     * @param soatYear this is the soat Year of the vehicle
     * @param soatImage this is the soat Image of the vehicle
     * @param technoNumber this is the  techno Number of the vehicle
     * @param technoMDay this is the technoM Day of the vehicle
     * @param technoMMonth this is the technoM Month of the vehicle
     * @param technoMYear this is the technoM Year of the vehicle
     * @param tehnoImage this is the tehno Image of the vehicle
     * @param optionPolarized this is the option Polarized of the vehicle
     * @param optionTheTyperCar this is option The typer Car of the vehicle
     */

    public String registerGasolineCar(int optionAlreadyUsed, double basePrice, double sellPrice, String mark, int model,
        double cilinderCapacity, double kilometers, String placa, String numDoors, int optionPolarized,
        int optionTheTyperCar,double gasolineCapacity,int optionTypeGasoline ,String soatNumber,double soatMoney,int soatDay,int soatMonth,
        int soatYear,String soatImage,String technoNumber,int technoMDay,int technoMMonth,int technoMYear,String tehnoImage  ){
            String message = "Registered Gasoline Car.";
            vehicles.add(new Gasoline(optionAlreadyUsed, basePrice, sellPrice, mark, model, cilinderCapacity, kilometers, placa, numDoors, optionPolarized, optionTheTyperCar,
            gasolineCapacity,optionTypeGasoline,soatNumber,soatMoney,soatDay,soatMonth,soatYear,soatImage,technoNumber,technoMDay,technoMMonth,technoMYear,tehnoImage ));
            return message;

    }
    
    /**
     * I created this method just for take more especific information .
     * @param optionAlreadyUsed this value say me if the vehicle Has been used
     * @param basePrice this is the base price of the vehicle
     * @param sellPrice this is the price of the vehicle
     * @param mark this is the mark of the vehicle
     * @param model this is the model of the vehicle
     * @param cilinderCapacity this is the cilinderCapacity of the vehicle
     * @param kilometers this is the cilinderCapacity of the vehicle
     * @param plate this is the plate of the vehicle
     * @param soatNumber this is the  soat Number  of the vehicle
     * @param soatMoney this is the  soat Money of the vehicle
     * @param soatDay this is the soat Day of the vehicle
     * @param soatMonth this is the soat Month of the vehicle
     * @param soatYear this is the soat Year of the vehicle
     * @param soatImage this is the soat Image of the vehicle
     * @param technoNumber this is the  techno Number of the vehicle
     * @param technoMDay this is the technoM Day of the vehicle
     * @param technoMMonth this is the technoM Month of the vehicle
     * @param technoMYear this is the technoM Year of the vehicle
     * @param tehnoImage this is the tehno Image of the vehicle
     * @param optionPolarized this is the option Polarized of the vehicle
     * @param optionTheTyperCar this is option The typer Car of the vehicle
     */
    public String registerElectricCar(int optionAlreadyUsed, double basePrice, double sellPrice, String mark, int model,
        double cilinderCapacity, double kilometers, String placa, String numDoors, int optionPolarized,
        int optionTheTyperCar,int optionTypeCharger,double batteryDuration,String soatNumber,double soatMoney,int soatDay,int soatMonth,
        int soatYear,String soatImage,String technoNumber,int technoMDay,int technoMMonth,int technoMYear,String tehnoImage ){
            String message = "Registered Electric Car.";
            vehicles.add(new Electric(optionAlreadyUsed, basePrice, sellPrice, mark, model, cilinderCapacity, kilometers, placa, numDoors, optionPolarized,
             optionTheTyperCar,optionTypeCharger,batteryDuration,
             soatNumber,soatMoney,soatDay,soatMonth,soatYear,soatImage,technoNumber,technoMDay,technoMMonth,technoMYear,tehnoImage));
            return message;
    }
    /**
     * I created this method just for take more especific information .
     * @param optionAlreadyUsed this value say me if the vehicle Has been used
     * @param basePrice this is the base price of the vehicle
     * @param sellPrice this is the price of the vehicle
     * @param mark this is the mark of the vehicle
     * @param model this is the model of the vehicle
     * @param cilinderCapacity this is the cilinderCapacity of the vehicle
     * @param kilometers this is the cilinderCapacity of the vehicle
     * @param plate this is the plate of the vehicle
     * @param soatNumber this is the  soat Number  of the vehicle
     * @param soatMoney this is the  soat Money of the vehicle
     * @param soatDay this is the soat Day of the vehicle
     * @param soatMonth this is the soat Month of the vehicle
     * @param soatYear this is the soat Year of the vehicle
     * @param soatImage this is the soat Image of the vehicle
     * @param technoNumber this is the  techno Number of the vehicle
     * @param technoMDay this is the technoM Day of the vehicle
     * @param technoMMonth this is the technoM Month of the vehicle
     * @param technoMYear this is the technoM Year of the vehicle
     * @param tehnoImage this is the tehno Image of the vehicle
     * @param optionPolarized this is the option Polarized of the vehicle
     * @param optionTheTyperCar this is option The typer Car of the vehicle
     */

    public String registerHybridCar(int optionAlreadyUsed, double basePrice, double sellPrice, String mark, int model,
        double cilinderCapacity, double kilometers, String placa, String numDoors, int optionPolarized,
        int optionTheTyperCar,double gasolineCapacity,int optionTypeGasoline,int optionTypeCharger,
        double batteryDuration,String soatNumber,double soatMoney,int soatDay,int soatMonth,
        int soatYear,String soatImage,String technoNumber,int technoMDay,int technoMMonth,int technoMYear,String tehnoImage ){
            String message = "Registered Hybrid Car.";
            vehicles.add(new Hybrid(optionAlreadyUsed, basePrice, sellPrice, mark, model, cilinderCapacity, kilometers, placa, numDoors, optionPolarized,
             optionTheTyperCar,gasolineCapacity,optionTypeGasoline,optionTypeCharger,batteryDuration,soatNumber,soatMoney,soatDay,soatMonth,soatYear,soatImage,technoNumber,technoMDay,
             technoMMonth,technoMYear,tehnoImage));
            return message;
    }
    public boolean existPlate(String plate){
        boolean answer = false;
        for (int i = 0; i < vehicles.size()&&answer!= true; i++) {
            if(vehicles.get(i).getPlaca().equalsIgnoreCase(plate)){
                answer = true;
            }
        }
        return answer;
    }
      /**
     * I created this method just for take more especific information .
     * @param optionAlreadyUsed this value say me if the vehicle Has been used
     * @param basePrice this is the base price of the vehicle
     * @param sellPrice this is the price of the vehicle
     * @param mark this is the mark of the vehicle
     * @param model this is the model of the vehicle
     * @param cilinderCapacity this is the cilinderCapacity of the vehicle
     * @param kilometers this is the cilinderCapacity of the vehicle
     * @param plate this is the plate of the vehicle
     * @param soatNumber this is the  soat Number  of the vehicle
     * @param soatMoney this is the  soat Money of the vehicle
     * @param soatDay this is the soat Day of the vehicle
     * @param soatMonth this is the soat Month of the vehicle
     * @param soatYear this is the soat Year of the vehicle
     * @param soatImage this is the soat Image of the vehicle
     * @param technoNumber this is the  techno Number of the vehicle
     * @param technoMDay this is the technoM Day of the vehicle
     * @param technoMMonth this is the technoM Month of the vehicle
     * @param technoMYear this is the technoM Year of the vehicle
     * @param tehnoImage this is the tehno Image of the vehicle
     */

    public String registerMotorcycle(int optionAlreadyUsed, double basePrice, double sellPrice, String mark, int model,
        double cilinderCapacity, double kilometers, String placa,int optionTypeMotocycle,double gasolineCapacity,String soatNumber,double soatMoney,int soatDay,int soatMonth,
        int soatYear,String soatImage,String technoNumber,int technoMDay,int technoMMonth,int technoMYear,String tehnoImage,int optionTypeGasoline ){
            String message = "Registered Motorcycle.";
            vehicles.add(new Motocycle(optionAlreadyUsed, basePrice, sellPrice, mark, model, cilinderCapacity, kilometers, placa, optionTypeMotocycle, gasolineCapacity,
            soatNumber,soatMoney,soatDay,soatMonth,soatYear,soatImage,technoNumber,technoMDay,technoMMonth,technoMYear,tehnoImage , optionTypeGasoline));
            return message;
    }
    /**
     * 	To know how is the oldest and the youngest
     * @return
     */

    public String theOldestAndYoungest(){
        int oldest = 0;
        int youngest = 1000023;
        ArrayList<Vehicle> namesOlderYoungest = new ArrayList<Vehicle>();
        for (int i = 0; i < vehicles.size(); i++) {
            if(oldest<=vehicles.get(i).getModel()){
                oldest =vehicles.get(i).getModel();
                if(oldest!=0){
                    namesOlderYoungest.add(vehicles.get(i));
                }
            }
        }
        for (int i = 0; i < namesOlderYoungest.size()-1; i++) {
            namesOlderYoungest.remove(i);
        }
        for (int i = 0; i < vehicles.size(); i++) {
            if(youngest>vehicles.get(i).getModel()){
                youngest =vehicles.get(i).getModel();
                if(youngest!=0){
                    namesOlderYoungest.add(vehicles.get(i));
                }
            }
        }for (int i = 1; i < namesOlderYoungest.size()-1; i++) {
            namesOlderYoungest.remove(i);
        }

        String message = "";
        message ="[The Oldest]"+namesOlderYoungest.get(0).toString();
        message =message+"\n[The Youngest]"+namesOlderYoungest.get(1).toString();


        return message;
            
    }



    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }


    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }


    public Vehicle[][] getParking() {
        return parking;
    }


    public void setParking(Vehicle[][] parking) {
        this.parking = parking;
    }
}