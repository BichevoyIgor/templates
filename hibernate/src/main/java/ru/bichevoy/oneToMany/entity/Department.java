package ru.bichevoy.oneToMany.entity;

import javax.persistence.*;

@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String departmentName;
    @Column(name = "min_salary")
    private int minSalary;
    @Column(name = "max_salary")
    private int maxSalary;


    /**    BI directional
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH
            , CascadeType.REFRESH, CascadeType.MERGE}
            , mappedBy = "dep") //ссылаемся на поле где прописана связь на стороне Many
    private List<Employee> emps;

    public List<Employee> getEmps() {
        return emps;
    }

    public void setEmps(List<Employee> emps) {
        this.emps = emps;
    }

    public void addEmployeeToDepartment(Employee employee) {
        if (emps == null) {
            emps = new ArrayList<>();
        }
        emps.add(employee);
        employee.setDep(this);
    }
    **/


    public Department() {
    }


    public Department(String name, int minSalary, int maxSalary) {
        this.departmentName = name;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    public int getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", minSalary=" + minSalary +
                ", maxSalary=" + maxSalary +
//                ", emps=" + emps +
                '}';
    }
}
