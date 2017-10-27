package model.dto;

import model.Error;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author igor
 * Last edited 24-10-2017
 */

public class UserDTO {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    private String name;
    private String email;
    private String password;
    private final List<Error> errors = new ArrayList<>();;

    public UserDTO() {
    }
    
    public UserDTO(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public UserDTO(String email, String password) {
        this.name = "Anonymus";
        this.email = email;
        this.password = password;
    }
    
    public void addError(Error error){
        errors.add(error);
    }
    
    public boolean hasErrors(){
        return !errors.isEmpty();
    }
    
    public List<Error> getErrors(){
        return errors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.name);
        hash = 73 * hash + Objects.hashCode(this.email);
        hash = 73 * hash + Objects.hashCode(this.password);
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
        final UserDTO other = (UserDTO) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return Objects.equals(this.password, other.password);
    }

    @Override
    public String toString() {
        return "UserDTO{" + "id=" + id + ", name=" + name + ", email=" + email + 
                ", password=" + password + ", errors=" + errors + '}';
    }


        
}
