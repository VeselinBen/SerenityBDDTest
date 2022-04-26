package models;

import java.util.List;

public class ResponceBody {

    private Status status;
    private List<Data> data;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponceBody{" +
                "status=" + status +
                ", data=" + data +
                '}';
    }
}
