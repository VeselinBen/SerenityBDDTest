package models.data;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"price", "last_updated"})
public class BOB {
//    "BOB": {
//        "price": 2976759.8650601557,
//                "last_updated": "2022-04-19T13:29:58.000Z"
//    }

    private double price;
    private String last_updated;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(String last_updated) {
        this.last_updated = last_updated;
    }
}
