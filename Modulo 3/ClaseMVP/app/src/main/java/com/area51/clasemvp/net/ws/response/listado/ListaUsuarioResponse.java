
package com.area51.clasemvp.net.ws.response.listado;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListaUsuarioResponse {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("rpta")
    @Expose
    private List<Rptum> rpta = null;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Rptum> getRpta() {
        return rpta;
    }

    public void setRpta(List<Rptum> rpta) {
        this.rpta = rpta;
    }

}
