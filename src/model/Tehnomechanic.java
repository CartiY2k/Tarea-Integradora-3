package model;
import java.lang.Math;

public class Tehnomechanic extends Document {

    public static final int FINAL = 4;
    public Tehnomechanic(String technoNumber,int technoMDay,int technoMMonth,int technoMYear,String tehnoImage) {
        super(technoNumber, technoMDay, technoMMonth, technoMYear, tehnoImage);
    }

    @Override
    public String generateNumber() {
        int [][] matrixTechoMechanic= new int [4][4];
        for (int x = 0; x < matrixTechoMechanic.length; x++) {
            for (int y = 0; y < matrixTechoMechanic[0].length; y++) {
                int randomNumber = (int)(Math.random()*20+1);
                matrixTechoMechanic[x][y] = randomNumber;
            }
        }
        String message = "";

        for (int x = 0; x < matrixTechoMechanic.length; x++) {
            for (int y = 0; y < matrixTechoMechanic[0].length; y++) {
                if(x ==0){
                    message =message+ "|"+ matrixTechoMechanic[x][y];
                }
                
            }
        } 
        boolean continue1 = true;

        for (int y = matrixTechoMechanic.length-1; y > 0; y--) {
            continue1 = true;
            for (int x = 0; x < matrixTechoMechanic.length&&continue1 != false; x++) {
                if(y!= 3){
                    message =message+ "|"+ matrixTechoMechanic[y][x];
                    continue1 = false;
                }
            }
        }
        for (int x = 3; x < matrixTechoMechanic.length; x++) {
            for (int y = 0; y < matrixTechoMechanic[0].length; y++) {
                message =message+ "|"+ matrixTechoMechanic[x][y];
            }
        }

        return message;
    }

    @Override
    public String toString() {
        String message = "\n\nTECHNO MECHANIC"+super.toString();
        return message;
    }
    
}
