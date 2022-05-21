package model;
import java.lang.Math;

public class Soat extends Document{

    public static final int FINAL = 4;
    private double soatMoney;

    public Soat(String soatNumber,double soatMoney,int soatDay,int soatMonth,
    int soatYear,String soatImage) {
        super(soatNumber, soatDay, soatMonth, soatYear, soatImage);
       this.soatMoney = soatMoney;
    }

    

    @Override
    public String  generateNumber() {
        int [][] matrixSoat= new int [4][4];
        for (int x = 0; x < matrixSoat.length; x++) {
            for (int y = 0; y < matrixSoat[0].length; y++) {
                int randomNumber = (int)(Math.random()*20+1);
                matrixSoat[x][y] = randomNumber;
            }
        }String message = "";

        for (int x = 0; x < matrixSoat.length; x++) {
            for (int y = 0; y < matrixSoat[0].length; y++) {
                if(y ==0){
                    message =message+ "|"+ matrixSoat[x][y];
                }
                if(x ==3&&y !=0){
                    message = message+ "|"+ matrixSoat[x][y];
                }
                
            }
        }

        return message;
    }



    @Override
    public String toString() {
        String message = "\nSOAT\nSoat Cover:" + soatMoney+super.toString();
        return message;
    }
    
}
