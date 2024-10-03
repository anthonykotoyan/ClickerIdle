public class Price {
    private int price;
    private String type;
    private double modifier;

    public int getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public double getModifier() {
        return modifier;
    }

    public Price(int price, String type, double modifier) {
        this.price = price;
        this.type = type;
        this.modifier = modifier;
    }
    public Price(){
        this.price = 10;
        this.type = "+";
        this.modifier = 1;
    }

    public void updatePrice(){
        if (type == "+"){
            price += modifier;
        }
        else if (type == "*"){
            price *= modifier;
        }
        else if (type == "^") {
            price = (int) Math.pow(price, modifier);
        }
    }
}
