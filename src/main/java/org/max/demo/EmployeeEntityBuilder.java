package org.max.demo;

public class EmployeeEntityBuilder {
    private Short id;
    private String name;
    private Double capacity;
    private short infoId;

    public EmployeeEntityBuilder setId(Short id) {
        this.id = id;
        return this;
    }

    public EmployeeEntityBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public EmployeeEntityBuilder setCapacity(Double capacity) {
        this.capacity = capacity;
        return this;
    }

    public EmployeeEntityBuilder setInfoId(short infoId) {
        this.infoId = infoId;
        return this;
    }

    public EmployeeEntity build() {
        return new EmployeeEntity(id, name, capacity, infoId);
    }
}