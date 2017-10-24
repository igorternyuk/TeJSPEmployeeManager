package uml;

import java.util.Objects;

/**
 *
 * @author igor
 */
public class Employee {
    private int id;
    private String name;
    private String surname;
    private int age;
    private String address;
    private String phone;
    private String email;
    
    public Employee() {
    }
    
    public Employee(String name, String surname, int age, String address,
                    String phone, String email) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
        this.phone = phone;
        this.email = email;
    } 

    public Employee(int id, String name, String surname, int age, String address,
                    String phone, String email) {
        this(name, surname, age, address, phone, email);
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

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", surname=" +
               surname + ", age=" + age + ", address=" + address + ", phone=" + 
               phone + ", email=" + email + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.name);
        hash = 19 * hash + Objects.hashCode(this.surname);
        hash = 19 * hash + this.age;
        hash = 19 * hash + Objects.hashCode(this.address);
        hash = 19 * hash + Objects.hashCode(this.phone);
        hash = 19 * hash + Objects.hashCode(this.email);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;
        if (this.age != other.age) {
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

}
