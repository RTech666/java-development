package com.pluralsight;

public class Shipper {
    // Create variables, as private.
    private int id;
    private String name;
    private String phone;

    // Create the constructor.
    public Shipper(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    // Create getters and setters.
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Create override string.
    @Override
    public String toString() {
        return "Shipper{id=" + id + ", name='" + name + "', phone='" + phone + "'}";
    }
}
