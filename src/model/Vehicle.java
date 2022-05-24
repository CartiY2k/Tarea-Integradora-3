package model;
import java.time.LocalDate;

public abstract class Vehicle {
    //Attributes
    private boolean alreadyUsed;
    private double basePrice;
    private double sellPrice;
    private String mark; 
    private int model;
    private double cilinderCapacity;
    private double kilometers;
    private String placa;

    private Document [] documents;

    public Vehicle(int optionAlreadyUsed, double basePrice, double sellPrice, String mark, int model,
        double cilinderCapacity, double kilometers, String placa,String soatNumber,double soatMoney,int soatDay,int soatMonth,
        int soatYear,String soatImage,String technoNumber,int technoMDay,int technoMMonth,int technoMYear,String tehnoImage) {
        switch(optionAlreadyUsed){
            case 1:
                this.alreadyUsed = true;
                break;
            case 2:
                this.alreadyUsed = false;
                break;
        }

        this.documents = new Document[3];
        documents[0] = fillSoat(soatNumber,soatMoney,soatDay,soatMonth,soatYear,soatImage);
        documents[1] = fillTechnoMechanic(technoNumber,technoMDay,technoMMonth,technoMYear,tehnoImage);
        this.basePrice = basePrice;
        this.sellPrice = calculateSellPrice();
        this.mark = mark;
        this.model = model;
        this.cilinderCapacity = cilinderCapacity;
        this.kilometers = kilometers;
        this.placa = placa;
    }

    

    public String allDocument(){
    String message = "";
        for (int i = 0; i < documents.length-1; i++) {           ////////////OJO SE DEBE CAMBIAR ESTO CUANDO TENGA LA TARJETA DE PROPIEDAD
            message = message+documents[i].toString();
        }
        if(documents[2]==null){
            message = message + "\nThe vehicle doesn't have a OwnerCard.";
        }else{
            message = message +documents[2].toString();
        }
        return message;
    }

    public Soat fillSoat(String soatNumber,double soatMoney,int soatDay,int soatMonth,
        int soatYear,String soatImage){
            Soat soat = new Soat(soatNumber,soatMoney, soatDay, soatMonth, soatYear, soatImage);
            return soat;

    }

    public Tehnomechanic fillTechnoMechanic(String technoNumber,int technoMDay,int technoMMonth,int technoMYear,
        String tehnoImage){
            Tehnomechanic tehnomechanic = new Tehnomechanic(technoNumber, technoMDay, technoMMonth, technoMYear, tehnoImage);
            return tehnomechanic;
    }
    public abstract double calculateSellPrice();

    public void createdOwner(int ownerDay, int ownerMonth, int ownerYear,String ownerImage){
        documents[2] = new OwnerCard(ownerDay, ownerMonth, ownerYear, ownerImage);
    }

   
    public double seachDocuments(){
        double anExtra = 0;
        for (int i = 0; i < documents.length-1; i++) {            
            if(documents[i].getDate().getYear()<2020){
                anExtra += 500000;
            }
        }
        return anExtra;
    }
    
    public boolean getAlreadyUsed() {
        return alreadyUsed;
    }
    public void setAlreadyUsed(boolean alreadyUsed) {
        this.alreadyUsed = alreadyUsed;
    }
    public double getBasePrice() {
        return basePrice;
    }
    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }
    public double getSellPrice() {
        return sellPrice;
    }
    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }
    public String getMark() {
        return mark;
    }
    public void setMark(String mark) {
        this.mark = mark;
    }
    public int getModel() {
        return model;
    }
    public void setModel(int model) {
        this.model = model;
    }
    public double getCilinderCapacity() {
        return cilinderCapacity;
    }
    public void setCilinderCapacity(double cilinderCapacity) {
        this.cilinderCapacity = cilinderCapacity;
    }
    public double getKilometers() {
        return kilometers;
    }
    public void setKilometers(double kilometers) {
        this.kilometers = kilometers;
    }
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Override
    public String toString() {
    return "\nIs it Already Used? :" + alreadyUsed + "\nBase Price:" + basePrice + "\nCilinder Capacity:"
                + cilinderCapacity + "\nKilometers:" + kilometers + "\nMark:" + mark + "\nModel:" + model + "\nPlaca:"
                + placa + "\nSellPrice:" + sellPrice ;
    }

    public void SoatAnDocum(double soatMoney,int soatDay,int soatMonth,int soatYear,
         String soatImage,int technoMDay,int technoMMonth,int technoMYear,String technoImage){
         documents[0] = new Soat("0",soatMoney,soatDay,soatMonth,soatYear,soatImage) ;
         documents[1] = new Tehnomechanic("0",technoMDay,technoMMonth,technoMYear,technoImage);
    }

    public void fixSellprice(int soatYear,int technoMYear){
        if(soatYear>=2022){
            sellPrice -=500000;
        }
        if(technoMYear>=2022){
            sellPrice -=500000;
        }
    }
    

    public Document[] getDocuments() {
        return documents;
    }
    
    public void setDocuments(Document[] documents) {
        this.documents = documents;
    }
    
}
