package model;

import java.util.ArrayList;
import java.util.Date;

public class RegisteredUser extends User {
    private String name;
    private String address;
    private String password;
    private Boolean activeStatus;
    private Date lastPaymentDate;



    public RegisteredUser(int userId, String email, Boolean isRegistered, String name,
                          String address, String password,
                          Boolean activeStatus, Date lastPaymentDate) {
        super(userId, email, isRegistered);
        this.name = name;
        this.address = address;
        this.password = password;
        this.activeStatus = activeStatus;
        this.lastPaymentDate = lastPaymentDate;
    }

    // TO-DO: ADD ADD CARD, MAKE PAYMENT - > ACTIVATE/UPDATE LAST PAYMENT!!!

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(Boolean activeStatus) {
        this.activeStatus = activeStatus;
    }

    public Date getLastPaymentDate() {
        return lastPaymentDate;
    }

    public void setLastPaymentDate(Date lastPaymentDate) {
        this.lastPaymentDate = lastPaymentDate;
    }

    @Override
    public String toString() {
        return "RegisteredUser{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                ", activeStatus=" + activeStatus +
                ", lastPaymentDate=" + lastPaymentDate +
                ", userId=" + userId +
                ", email='" + email + '\'' +
                '}' + '\n';
    }
}
