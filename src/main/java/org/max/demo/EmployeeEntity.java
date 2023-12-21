package org.max.demo;

import javax.persistence.*;

@Entity
@Table(name = "employee", schema = "main", catalog = "")
public class EmployeeEntity {
    private Short id;
    private String name;
    private Double capacity;
    private short infoId;

    public EmployeeEntity(){}

    public EmployeeEntity(Short id, String name, Double capacity, short infoId) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.infoId = infoId;
    }

    @Id
    @Column(name = "id")
    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "capacity")
    public Double getCapacity() {
        return capacity;
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }

    @Column(name = "info_id")
    public short getInfoId() {
        return infoId;
    }

    public void setInfoId(short infoId) {
        this.infoId = infoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeEntity that = (EmployeeEntity) o;

        if (infoId != that.infoId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (capacity != null ? !capacity.equals(that.capacity) : that.capacity != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (capacity != null ? capacity.hashCode() : 0);
        result = 31 * result + (int) infoId;
        return result;
    }
}
