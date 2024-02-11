import interfaces.Tradable;

import java.util.ArrayList;
import java.util.List;

public class Stock implements Tradable {

    private String ID;
    private String description;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getDescription() {
        return description;
    }

    public Stock() {
        this.ID = "";
        this.price = 0;
        this.description = "";
        this.bids = new ArrayList<>();
        this.bids.add(price);
        this.metric = 0;
    }

    public Stock(String ID, double price, String description) {
        this.ID = ID;
        this.price = price;
        this.description = description;
        this.bids = new ArrayList<>();
        this.bids.add(price);
        this.metric = 0;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMetric() {
        return metric;
    }

    public void setMetric(int metric) {
        metric = metric;
    }

    public List<Double> getBids() {
        return bids;
    }

    public void setBid(double bid) {
        this.bids.add(bid);
        calculatePrice();
    }

    private void calculatePrice() {
        double avg = 0;
        for(double p : bids) {
            avg+= p;
        }
        avg = avg/bids.size();
        if(avg > this.price ) {
            setMetric(this.metric +1);
        }else if(avg < this.price) {
            setMetric(this.metric -1);
        }
        setPrice(avg);
    }

    public Stock(String ID) {
        this.ID = ID;
    }

    protected double price;

    private int metric;

    private List<Double> bids;


    public String getMetricValue() {
        if(this.getMetric() < -3) {
            return "--> Not a good stock, Not Recommended..!!";
        } else if (this.getMetric() >= -3 && this.getMetric() <= 3) {
            return " --> Good stock, But be cautious..!!";
        } else {
            return " --> Excellent stock, Highly Recommended..!!";
        }
    }

    @Override
    public String toString() {
        return "Stock{" +
                "name='" + ID + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", Metric Value=" + getMetricValue() +
                '}';
    }

    public List<Double> getBid(){
        return this.bids;
    }









}
