package ui;
import java.util.Scanner;
import model.*;

public class Main {
    public static Scanner lc = new Scanner(System.in);
    public static Company ct = new Company("Audi");
    public static void main(String [] args){
        int option = -1;
        do{
            option = menu();
            switch(option){
                case 1:
                    registerVehicle();
                    break;
                case 2:
                    generateDocuments();
                    break;
                case 3:
                    createReport();
                    break;
                case 4:
                    consultVehicle();
                    break;
                case 5:
                    showParking();
                    break;
                case 6:
                    parkingReport();
                   break;
                case 7:
                    break;
            }

        }while(option != 7);
    }

    /**
     * Just a Menu.
     * @return the option that the user wannted
     */

    public static int menu(){
        System.out.println("[1]Register Vehicle.\n[2]Generate Documents\n[3]Show Report\n[4]Consult a Vehicle\n[5]Show Parking\n[6]Parking Report\n[7]Exit");
        int option = lc.nextInt();
        lc.nextLine();
        return option;
    }

    /**
     * For register a vehicle you use this method, i rename as it because in all of the ocations we use this method for take the primary information
     */

    public static void registerVehicle(){
        System.out.println("Is the vehicle already used?\n[1]Yes\n[2]No");
        int optionAlreadyUsed = lc.nextInt();
        lc.nextLine();
        System.out.println("What's the base price?");
        double basePrice = lc.nextDouble();
        lc.nextLine();
        System.out.println("What's the sell Price?");
        double sellPrice = lc.nextDouble();
        lc.nextLine();
        System.out.println("What's the Mark?");
        String mark = lc.nextLine();
        System.out.println("What's the model?");
        int model = lc.nextInt();
        lc.nextLine();
        System.out.println("What's the cilinder Capacity");
        double cilinderCapacity =  lc.nextDouble();
        lc.nextLine();
        double kilometers = 0 ;
        String lisencePlate = "It will be assign";
        String soatNumber ="0";
        double soatMoney = 0;
        int soatDay = 1;
        int soatMonth = 1;
        int soatYear = 1;
        String technoNumber = "0";
        int technoMDay = 1;
        int technoMMonth = 1;
        int technoMYear = 1;
        String tehnoImage = "https//";
        String soatImage = "https//";
        if(optionAlreadyUsed== 1){
            System.out.println("How many Kilometers?");
            kilometers = lc.nextDouble();
            lc.nextLine();
            System.out.println("What's the lisence Plate?");
            lisencePlate = lc.nextLine();
            System.out.println("What's the Soat number?");
            soatNumber = lc.nextLine();
            System.out.println("How much money does the SOAT cover?");
            soatMoney = lc.nextDouble();
            lc.nextLine();
            System.out.println("What's the Soat's day of expedition?");
            soatDay = lc.nextInt();
            lc.nextLine();
            System.out.println("What's the Soat's month of expedition?");
            soatMonth = lc.nextInt();
            lc.nextLine();
            System.out.println("What's the Soat's year of expedition?");
            soatYear = lc.nextInt();
            lc.nextLine();
            System.out.println("What's the Soat's image?");
            soatImage = lc.nextLine();
            System.out.println("What's the Mechanical tecnique's number?");
            technoNumber =lc.nextLine();
            System.out.println("What's the Mechanical Technique's day of expedition?");
            technoMDay = lc.nextInt();
            lc.nextLine();
            System.out.println("What's the Mechanical Technique's month of expedition?");
            technoMMonth = lc.nextInt();
            lc.nextLine();
            System.out.println("What's the Mechanical Technique's year of expedition?");
            technoMYear = lc.nextInt();
            lc.nextLine();
            System.out.println("What's the Mechanical Technique's image?");
            tehnoImage = lc.nextLine();

        }
        boolean existPlate = ct.serchplate(lisencePlate);
        if(existPlate != false){
            System.out.println("Select One Type:\n[1]Car\n[2]Motorcycle");
            int optionCarOrMotorcycle = lc.nextInt();
            lc.nextLine();
            switch(optionCarOrMotorcycle){
                case 1:
                    registerCar(optionAlreadyUsed,basePrice,sellPrice,mark,model,
                        cilinderCapacity,kilometers,lisencePlate,soatNumber,soatMoney,
                        soatDay,soatMonth,soatYear,soatImage,technoNumber,technoMDay,technoMMonth,technoMYear,tehnoImage);
                        
                    break;
                case 2:
                    registerMotorcycle(optionAlreadyUsed,basePrice,sellPrice,mark,model,
                        cilinderCapacity,kilometers,lisencePlate,soatNumber,soatMoney,
                        soatDay,soatMonth,soatYear,soatImage,technoNumber,technoMDay,technoMMonth,technoMYear,tehnoImage );
                        
                    break;
                default:
                    System.out.println("Error, you didn't put a correct Type.");
                    break;
            }
        }else{
            System.out.println("This placa already registered in our base data.\nCheck and Try Again.");
        }
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

    public static void registerCar(int optionAlreadyUsed, double basePrice, double sellPrice, String mark, int model,
        double cilinderCapacity, double kilometers, String plate,String soatNumber,double soatMoney,int soatDay,int soatMonth,
        int soatYear,String soatImage,String technoNumber,int technoMDay,int technoMMonth,int technoMYear,String tehnoImage ){
            System.out.println("How many doors does it have?");
            String numDoors = lc.nextLine();
            System.out.println("Is it polarized?\n[1]Yes\n[2]No");
            int optionPolarized = lc.nextInt();
            lc.nextLine();
            System.out.println("Select One type:\n[1]Sedan\n[2]Truck");
            int optionTheTyperCar = lc.nextInt();
            lc.nextLine();
            System.out.println("Pick one:\n[1]Gasoline\n[2]Hybrid\n[3]Electric");     
            int optionSelectCar = lc.nextInt();
            lc.nextLine();
            switch(optionSelectCar){
                case 1:
                    registerGasolineCar(optionAlreadyUsed,basePrice,sellPrice,mark,model,
                        cilinderCapacity,kilometers,plate,numDoors,optionPolarized,optionTheTyperCar,soatNumber,soatMoney,
                        soatDay,soatMonth,soatYear,soatImage,technoNumber,technoMDay,technoMMonth,technoMYear,tehnoImage);
                    break;
                case 2:
                    registerHybridCar(optionAlreadyUsed,basePrice,sellPrice,mark,model,
                        cilinderCapacity,kilometers,plate,numDoors,optionPolarized,optionTheTyperCar,soatNumber,soatMoney,
                        soatDay,soatMonth,soatYear,soatImage,technoNumber,technoMDay,technoMMonth,technoMYear,tehnoImage);
                    break;
                case 3:
                    registerElectricCar(optionAlreadyUsed,basePrice,sellPrice,mark,model,
                        cilinderCapacity,kilometers,plate,numDoors,optionPolarized,optionTheTyperCar,soatNumber,soatMoney,
                        soatDay,soatMonth,soatYear,soatImage,technoNumber,technoMDay,technoMMonth,technoMYear,tehnoImage);
                    break;
                default:
                    break;
            }
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

    public static void registerMotorcycle(int optionAlreadyUsed, double basePrice, double sellPrice, String mark, int model,
        double cilinderCapacity, double kilometers, String placa,String soatNumber,double soatMoney,int soatDay,int soatMonth,
        int soatYear,String soatImage,String technoNumber,int technoMDay,int technoMMonth,int technoMYear,String tehnoImage ){
            System.out.println("///Register Motorcycle///\nSelect One Kind Of Motorcycle:\n[1]Standar\n[2]Sport\n[3]Scooter\n[4]Cross");
            int optionTypeMotocycle =lc.nextInt();
            lc.nextLine();
            System.out.println("What's the Gasoline Capacity?");
            double capacity = lc.nextDouble();
            lc.nextLine();
            System.out.println("Select one type of gasoline:\n[1]Extra\n[2]Corriente\n[3]Diesel");
            int optionTypeGasoline = lc.nextInt();
            lc.nextLine();
            String message = ct.registerMotorcycle(optionAlreadyUsed,basePrice,sellPrice,mark,model,
                cilinderCapacity,kilometers,placa,optionTypeMotocycle,capacity,soatNumber,soatMoney,soatDay,soatMonth,soatYear,soatImage,technoNumber,technoMDay,
                technoMMonth,technoMYear,tehnoImage,optionTypeGasoline);
                ct.theParking(model,placa);
            System.out.println(message);
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

    public static void registerGasolineCar(int optionAlreadyUsed, double basePrice, double sellPrice, String mark, int model,
        double cilinderCapacity, double kilometers, String placa, String numDoors, int optionPolarized,int optionTheTyperCar,String soatNumber,double soatMoney,int soatDay,int soatMonth,
        int soatYear,String soatImage,String technoNumber,int technoMDay,int technoMMonth,int technoMYear,String tehnoImage ){
            System.out.println("What's the Gasoline Capacity?");
            double gasolineCapacity = lc.nextDouble();
            lc.nextLine();
            System.out.println("Select one type of gasoline:\n[1]Extra\n[2]Corriente\n[3]Diesel");
            int optionTypeGasoline = lc.nextInt();
            lc.nextLine();
            String message = ct.registerGasolineCar(optionAlreadyUsed,basePrice,sellPrice,mark,model,
                cilinderCapacity,kilometers,placa,numDoors,optionPolarized,optionTheTyperCar,
                gasolineCapacity,optionTypeGasoline,soatNumber,soatMoney,soatDay,soatMonth,soatYear,soatImage,technoNumber,technoMDay,
                technoMMonth,technoMYear,tehnoImage);
                ct.theParking(model,placa);
            System.out.println(message);
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
    public static void registerHybridCar(int optionAlreadyUsed, double basePrice, double sellPrice, String mark, int model,
        double cilinderCapacity, double kilometers, String placa, String numDoors, int optionPolarized,int optionTheTyperCar,String soatNumber,double soatMoney,int soatDay,int soatMonth,
        int soatYear,String soatImage,String technoNumber,int technoMDay,int technoMMonth,int technoMYear,String tehnoImage ){
            System.out.println("What's the Gasoline Capacity ?");
            double gasolineCapacity = lc.nextDouble();
            lc.nextLine();
            System.out.println("Select one type of gasoline:\n[1]Extra\n[2]Corriente\n[3]Diesel");
            int optionTypeGasoline = lc.nextInt();
            lc.nextLine();
            System.out.println("Select One type of Charge:\n[1]Fast\n[2]Normal");
            int optionTypeCharger = lc.nextInt();
            lc.nextLine();
            System.out.println("What's the battery's duration?");
            double batteryDuration = lc.nextDouble();
            lc.nextLine();
            String message = ct.registerHybridCar(optionAlreadyUsed,basePrice,sellPrice,mark,model,
                cilinderCapacity,kilometers,placa,numDoors,optionPolarized,optionTheTyperCar,gasolineCapacity,optionTypeGasoline,optionTypeCharger,batteryDuration,
                soatNumber,soatMoney,soatDay,soatMonth,soatYear,soatImage,technoNumber,technoMDay,technoMMonth,technoMYear,tehnoImage);
                ct.theParking(model,placa);
                System.out.println(message);
            
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
    public static void registerElectricCar(int optionAlreadyUsed, double basePrice, double sellPrice, String mark, int model,
        double cilinderCapacity, double kilometers, String plate, String numDoors, int optionPolarized,int optionTheTyperCar,String soatNumber,double soatMoney,int soatDay,int soatMonth,
        int soatYear,String soatImage,String technoNumber,int technoMDay,int technoMMonth,int technoMYear,String tehnoImage ){
            System.out.println("Select One type of Charge:\n[1]Fast\n[2]Normal");
            int optionTypeCharger = lc.nextInt();
            lc.nextLine();
            System.out.println("What's the battery's duration?");
            double batteryDuration = lc.nextDouble();
            lc.nextLine();
            String message = ct.registerElectricCar(optionAlreadyUsed,basePrice,sellPrice,mark,model,
                cilinderCapacity,kilometers,plate,numDoors,optionPolarized,optionTheTyperCar,optionTypeCharger,batteryDuration,soatNumber,
                soatMoney,soatDay,soatMonth,soatYear,soatImage,technoNumber,technoMDay,technoMMonth,technoMYear,tehnoImage );
                ct.theParking(model,plate);
                System.out.println(message);
        
    }

    /**
     * This method was just created with the only motive to generate the documents,
     * as you can jnow, if it's a New Car has an especial path MoreOver you have to
     * complete a request , Why? Because if it's new the group in the basement have to select
     * one car with those kind of especification.
     */

    public static void generateDocuments(){
        String message = "";
        boolean toSerch = true;
        String plate = "";
        int sw = 0;
        boolean exist= true;
        System.out.println("Select One\n[1]New Vehicles\n[2]Old Vehicles");
        int option1 = lc.nextInt();
        lc.nextLine();
        switch(option1){
            case 1:
                System.out.println("To find the vehicle, You have to complete this short request:\nWhat's the mark?");
                String mark = lc.nextLine();
                System.out.println("What's the model?");
                int model = lc.nextInt();
                lc.nextLine();
                System.out.println("Select One\nWhich One Type:\n[1]Car\n[2]Motorcycle");
                int optionSelectType = lc.nextInt();
                lc.nextLine();
                System.out.println("What's the plate that you want to this car?");
                plate = lc.nextLine();
                boolean existPlate = ct.existPlate(plate);
                if(existPlate == false){
                    toSerch = ct.serchVehicle(mark,model,optionSelectType,plate);
                    if(toSerch==true){
                        System.out.println("How much money does the SOAT cover?");
                        double soatMoney = lc.nextDouble();
                        lc.nextLine();
                        System.out.println("What's the Soat's day of expedition?");
                        int soatDay = lc.nextInt();
                        lc.nextLine();
                        System.out.println("What's the Soat's month of expedition?");
                        int soatMonth = lc.nextInt();
                        lc.nextLine();
                        System.out.println("What's the Soat's year of expedition?");
                        int soatYear = lc.nextInt();
                        lc.nextLine();
                        System.out.println("What's the Soat's image?");
                        String soatImage = lc.nextLine();
                        System.out.println("What's the Mechanical Technique's day of expedition?");
                        int technoMDay = lc.nextInt();
                        lc.nextLine();
                        System.out.println("What's the Mechanical Technique's month of expedition?");
                        int technoMMonth = lc.nextInt();
                        lc.nextLine();
                        System.out.println("What's the Mechanical Technique's year of expedition?");
                        int technoMYear = lc.nextInt();
                        lc.nextLine();
                        System.out.println("What's the Mechanical Technique's image?");
                        String tehnoImage = lc.nextLine();
                        ct.createdSoatTechnoMec(soatMoney,soatDay,soatMonth,soatYear,soatImage,technoMDay,technoMMonth,technoMYear,tehnoImage,plate);
                        option1 = 2;
                        sw = 1;
                    }else{
                        break;
                    }
                }else{
                    message = "The company already created a vehicle with that plate.";
                    break;
                }
            case 2:
                if(sw==0){
                    System.out.println("Put the Vehicle's plate that you want to create the Owner Card");
                    plate = lc.nextLine();
                    exist = ct.existPlate(plate);
                }
                if(!exist){
                    message = "The plate doesn't exist.";
                }else{
                    System.out.println("What's the Owner Card's day of expedition?");
                    int ownerDay = lc.nextInt();
                    lc.nextLine();
                    System.out.println("What's the Owner Card's month of expedition?");
                    int ownerMonth = lc.nextInt();
                    lc.nextLine();
                    System.out.println("What's the Owner Card's year of expedition?");
                    int ownerYear = lc.nextInt();
                    lc.nextLine();
                    System.out.println("What's the Owner Card's image?");
                    String ownerImage = lc.nextLine();
                    message = ct.createdOwner(plate,ownerDay,ownerMonth,ownerYear,ownerImage);
                }
                break;
            default:
                message = "Error, You have to select One type.";
                break;
        }
        if(sw==0){
            System.out.println(message);
        }else{
            System.out.println("Documents Created In A Correct Way");
        }
        if(!toSerch){
            System.out.println("A New car with those kinds of specifications hasn't been registered yet\nCome Back, when you register it :)");
        }
        

    }
    /**
     * In this method you just want to know all about the parking and deppends on the context that
     * you want to select , in your screen Appears a message with all information that you want.
     */

    public static void parkingReport(){
        String message = "";
        System.out.println("Select One The Way that you want to get the parking report:\n[1]Vehicles List In A Range\n[2]The oldest and The youngest(Vehicle)\n[3]Ocupation Average");
        int option1 = lc.nextInt();
        lc.nextLine();
        switch(option1){
            case 1:
                System.out.println("What's the initial Year?");
                int initialYear = lc.nextInt();
                lc.nextLine();
                System.out.println("What's the final Year?");
                int finalYear = lc.nextInt();
                lc.nextLine();
                message =ct.listVehicles(initialYear,finalYear);
                break;
            case 2:
                message = ct.theOldestAndYoungest() ;
                break;
            case 3:
                message = ct.parkingReport();
                break;
        }

        System.out.println(message);

    }

    /**
     * This method call upon a method in the controller to show you up all the informtion the car that you previus input
     */

    public static void consultVehicle(){
        System.out.println("Put the license plate:");
        String plate = lc.nextLine();
        String message = ct.consultVehicle(plate);
        System.out.println(message);
    }
    /**
     * This method just print the whole parking 
     */

    public static void showParking(){
        Vehicle [][]parking = ct.getParking();
        char a = 174;
        for (int i = 0; i < parking[0].length; i++) {
            System.out.print("----");
        }
        for (int x = 0; x < 10; x++) { 
            System.out.println("");
            System.out.print("|");
            for (int y = 0; y < 5; y++){
                if(parking[x][y]==null){
                    System.out.print("  ");
                }else{
                       System.out.print(""+a+"");
                }
                System.out.print(" |");
            }
                System.out.println("");
                for (int i = 0; i < parking[0].length; i++) {
                    System.out.print("----");
                }
        } 
        System.out.println("");
    }

    /**
     * Menu, for select One:
     */
    public static void createReport(){
        System.out.println("///Information///\nSelect one type of Report\n[1]Type Vehicles.\n[2]Type Fuel.\n[3]New/Used Cars.");
        int optionReport = lc.nextInt();
        lc.nextLine();
        switch(optionReport){
            case 1:
                reportTypeVehicle();
                break;
            case 2:
                reportTypeFuel();
                break;
            case 3:
                reportNewUsedCars();
                break;
        }
    }
    /**
     * To report what's gonna on each car.
     */

    public static void reportTypeVehicle(){
        String [] message = ct.reportTypeVehicle();
        System.out.println("[GASOLINE]"+message[0]+"\n[HYBRID]\n"+message[1]+"\n[ELECTRIC]\n"+message[2]+"\n[MOTORCYCLE]"+message[3]);
        
        
    }
    /**
     * To report what's gonna on each car.
     */
    
    public static void reportTypeFuel(){
        String [] message = ct.reportTypeFuel();
        System.out.println("[EXTRA]"+message[0]+"\n[CORRIENTE]\n"+message[1]+"\n[DIESEL]\n"+message[2]);
    }
    /**
     * To report what's gonna on each car.
     */

    public static void reportNewUsedCars(){
        String[] message = ct.reportNewUsedCars();
        System.out.println("[USED]"+message[0]+"\n[NEW]\n"+message[1]);
    }
}