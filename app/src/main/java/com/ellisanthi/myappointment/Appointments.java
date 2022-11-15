package com.ellisanthi.myappointment;

public class AppointmentsUser {
    private String doctorfullName;
    private String spec;
    private String Address;
    private String date;
    private String time;

    public String getDoctorfullName() {
        return doctorfullName;
    }

    public void setDoctorfullName(String doctorfullName) {
        this.doctorfullName = doctorfullName;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
