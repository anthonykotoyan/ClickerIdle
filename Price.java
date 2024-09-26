public class Price {
    private int price;
    private String type;
    private int modifier;

    public int getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public int getModifier() {
        return modifier;
    }

    public Price(int price, String type, int modifier) {
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
