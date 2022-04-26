package models.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"BOB"})
public class Quote {

    private BOB bob;

    @JsonProperty("BOB")
    public BOB getBob() {
        return bob;
    }
    @JsonProperty("BOB")
    public void setBob(BOB bob) {
        this.bob = bob;
    }

//    @JsonProperty("BOB")
//    public BOB getBOB() {
//        return BOB;
//    }
//
//    @JsonProperty("BOB")
//    public void setBOB(models.data.BOB BOB) {
//        this.BOB = BOB;
//    }
}
