package model;
import java.lang.Math;


public class OwnerCard extends  Document{
    public static final int FINAL = 4;

    public OwnerCard(int ownerDay,int ownerMonth,int ownerYear,String ownerImage) {
        super("0",ownerDay, ownerMonth, ownerYear, ownerImage);
    }

    @Override
    public String generateNumber() {
        int [][] matrixOwner= new int [4][4];
        for (int x = 0; x < matrixOwner.length; x++) {
            for (int y = 0; y < matrixOwner[0].length; y++) {
                int randomNumber = (int)(Math.random()*20+1);
                matrixOwner[x][y] = randomNumber;
            }
        }String message = "";

        for (int x = matrixOwner.length-1; x > 0; x--) {
            for (int y =  matrixOwner[0].length-1; y >= 0; y--) {
                if(x%2 !=0 && y%2!=0){
                    message = message+ "|"+ matrixOwner[x][y];
                }
                else if(x%2==0&&y%2==0){
                    message = message+ "|"+ matrixOwner[x][y];
                }
                
            }
        }
        for (int x = 0; x < matrixOwner.length; x++) {
            for (int y = 0; y < matrixOwner.length; y++) {
                if(y == 2&& x==0){
                    message = message+ "|"+ matrixOwner[x][y];
                }
            }
        }
        return message;
    }

    @Override
    public String toString() {
        String message = "\n\nOWNER CARD"+super.toString();
        return message;
    }
}
