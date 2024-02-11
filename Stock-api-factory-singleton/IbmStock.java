public class IbmStock extends Stock {
    IbmStock(){
        super();
    }

    public IbmStock(String name, double price, String description) {
        super(name, price, description);
    }

    public void calculatePrice(){
        double avg = 0;

        for(double p: getBid()){
            avg+= p;
        }
        avg = avg/getBid().size();
        if(avg > this.price && getMetric() >= 0) {
            setMetric(getMetric() +2);
        }else if(avg > this.price && getMetric() < 0){
            setMetric(0);
        }else if(avg < this.price && getMetric() <= 0) {
            setMetric(getMetric()-2);
        }else if(avg < this.price && getMetric() > 0) {
            setMetric(0);
        }
        setPrice(avg);
    }
        }






