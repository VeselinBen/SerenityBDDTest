package models.data;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import models.Data;
import models.Status;

@JsonPropertyOrder({"status", "data"})
public class ResponseBodyConvertor {

    private Status status;
    private DataConverte data;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public DataConverte getData() {
        return data;
    }

    public void setData(DataConverte data) {
        this.data = data;
    }
}
