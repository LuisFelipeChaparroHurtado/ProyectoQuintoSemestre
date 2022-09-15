package co.edu.usta.tunja.supermarket.persistence.entity;


import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name= "PERSON_TYPE")

public class PersonTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_person_type", nullable = false)
    private Integer id;

    @Column(name = "person_type_name", length = 45, nullable = false)
    private String person_type_name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPerson_type_name() {
        return person_type_name;
    }

    public void setPerson_type_name(String person_type_name) {
        this.person_type_name = person_type_name;
    }

    @Override
    public String toString() {
        return person_type_name;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.person_type_name);
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
        final PersonTypeEntity other = (PersonTypeEntity) obj;
        if (!Objects.equals(this.person_type_name, other.person_type_name)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
}
