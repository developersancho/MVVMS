package developersancho.mvvm_s.data.remote.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ParkResult {
    @SerializedName("results")
    @Expose
    private List<ParkResponse> results = null;
    @SerializedName("status")
    @Expose
    private String status;

    public List<ParkResponse> getResults() {
        return results;
    }

    public void setResults(List<ParkResponse> results) {
        this.results = results;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
