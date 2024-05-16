
public class Card {
    private String color;
    private int value;
    private int specialValue;
    private boolean special;


    public Card(int value,String color) {


        this.color = color;
        this.value = value;
        this.specialValue = 0;
        this.special = false;
    }


    public Card(int specialValue) {


        this.color="";
        this.specialValue = specialValue;
        this.value = 0;
        this.special = true;
    }

    public String formatCard() {// how the card looks after running the code
        if (!this.isSpecial()) {
            return "[" + this.getColor() + " " + this.getValue() + "]";
        } else {
            return "[" + "+" + this.getValue() + "]";
        }
    }


    public String getColor() {

        return this.color;
    }

    public int getValue() {


        if(!this.special) {
            return this.value;}

        else {
            return this.specialValue;
        }
    }


    public boolean isSpecial() {


        if(special) {
            return true;
        }

        return false;
    }
}