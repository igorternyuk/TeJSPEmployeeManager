package model.dto;

import java.util.Objects;

/**
 *
 * @author igor
 */
public class EmployeeDTO {
    private int id;
    private String name;
    private String surname;
    private int age;
    private String address;
    private String phone;
    private String email;
    private double salary;
    
    public EmployeeDTO() {
    }
    
    public EmployeeDTO(String name, String surname, int age, String address,
                    String phone, String email, double salary) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.salary = salary;
    } 

    public EmployeeDTO(int id, String name, String surname, int age,
                       String address, String phone, String email, double salary) {
        this(name, surname, age, address, phone, email, salary);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Objects.hashCode(this.surname);
        hash = 97 * hash + this.age;
        hash = 97 * hash + Objects.hashCode(this.address);
        hash = 97 * hash + Objects.hashCode(this.phone);
        hash = 97 * hash + Objects.hashCode(this.email);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.salary) ^
                (Double.doubleToLongBits(this.salary) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final EmployeeDTO other = (EmployeeDTO) obj;
        if (this.age != other.age) {
            return false;
        }
        if (Double.doubleToLongBits(this.salary) !=
            Double.doubleToLongBits(other.salary)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.surname, other.surname)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        return Objects.equals(this.email, other.email);
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" + "id=" + id + ", name=" + name + ", surname="
                + surname + ", age=" + age + ", address=" + address + ", phone="
                + phone + ", email=" + email + ", salary=" + salary + '}';
    }

}
