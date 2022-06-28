package com.training.collections.set;

import java.util.Objects;

public class Vehicle implements Comparable<Vehicle>{
    private String model;
    private String marca;
    private int year;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Vehicle(String model, String marca, int year) {
        this.model = model;
        this.marca = marca;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "model='" + model + '\'' +
                ", marca='" + marca + '\'' +
                ", year=" + year +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return year == vehicle.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year);
    }

    @Override
    public int compareTo(Vehicle o) {
        return Integer.compare(this.year, o.year) ;
    }
}
