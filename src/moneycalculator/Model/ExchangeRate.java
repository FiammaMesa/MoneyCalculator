package moneycalculator.Model;

import java.util.Date;

public class ExchangeRate {

    private Date date;
    private final Currency from;
    private final Currency to;
    private final Number rate;

    public ExchangeRate (Currency from, Currency to, Number rate){
        this.from = from;
        this.to = to;
        this.rate = rate;
    }
    
    public ExchangeRate(Date date, Currency from, Currency to, Number rate) {
        this.date = date;
        this.from = from;
        this.to = to;
        this.rate = rate;
    }
    
    public Date getDate() {
        return date;
    }

    public Currency getFrom() {
        return from;
    }

    public Currency getTo() {
        return to;
    }

    public Number getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return "fecha:" + date + ", de:" + from + ", a:" + to + ", tasa de cambio:" + rate;
    }
    
    
}
