package util;

import java.io.Serializable;

public class Login implements Serializable {
    private String productioncompany;
    private String password;
    private boolean status;

    public String getProductioncompany() {
        return productioncompany;
    }

    public void setProductioncompany(String productioncompany) {
        this.productioncompany = productioncompany;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
