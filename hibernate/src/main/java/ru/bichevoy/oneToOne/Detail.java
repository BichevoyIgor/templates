package ru.bichevoy.oneToOne;

import javax.persistence.*;

@Entity
@Table(name = "details")
public class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "number")
    private String number;
    @Column(name = "city")
    private String city;

    public Detail() {
    }

    /** UNI-directional
    @OneToOne(mappedBy = "empDetails", cascade = CascadeType.ALL)
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    **/

    public Detail(String number, String city) {
        this.number = number;
        this.city = city;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
