package model;
import java.time.LocalDate;

public abstract class Document {
    private String number;
    private LocalDate date;
    private String image;
    //Methods:
    public Document(String number,int day,int month,int year, String image) {
        this.date = LocalDate.of(year, month,day);
        this.image = image;
        if(number.equalsIgnoreCase("0"))
            this.number = generateNumber();
        else
            this.number = number;

    }

    

    

    public abstract String generateNumber();
    
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    @Override
    public String toString() {
    String message = "\nDate:" + date + "\nImage:" + image + "\nNumber:" + number ;
        boolean answer = calculateStatus();
        if(answer == false)
            message = message+"\nStatus: Elapsed";
        else
            message = message+"\nStatus: Active";
        return message;
    }
    
    public boolean calculateStatus(){
        boolean answer= true;
        if(date.getYear() <2022){
            answer = false;
        }
        return answer;
    }


}
