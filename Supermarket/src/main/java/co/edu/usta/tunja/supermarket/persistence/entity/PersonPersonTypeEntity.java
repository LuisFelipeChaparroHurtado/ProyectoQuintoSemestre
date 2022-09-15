package co.edu.usta.tunja.supermarket.persistence.entity;

import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name= "PERSON_PERSON_TYPE")

public class PersonPersonTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_person_person_type", nullable = false)
    private Integer id;
    
    @Column(name="fk_id_person_type")
    private Integer fkIdPersonType;
    
    @Column(name="fk_id_person")
    private Integer fkIdPerson;
    
    @ManyToOne
    @JoinColumn(name = "fk_id_person_type", insertable = false, updatable = false)
    private PersonTypeEntity fkPersonType;
    

    @ManyToOne
    @JoinColumn(name = "fk_id_person", insertable = false, updatable = false)
    private PersonEntity fkPerson;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFkIdPersonType() {
        return fkIdPersonType;
    }

    public void setFkIdPersonType(Integer fkIdPersonType) {
        this.fkIdPersonType = fkIdPersonType;
    }

    public Integer getFkIdPerson() {
        return fkIdPerson;
    }

    public void setFkIdPerson(Integer fkIdPerson) {
        this.fkIdPerson = fkIdPerson;
    }

    public PersonTypeEntity getFkPersonType() {
        return fkPersonType;
    }

    public void setFkPersonType(PersonTypeEntity fkPersonType) {
        this.fkPersonType = fkPersonType;
    }

    public PersonEntity getFkPerson() {
        return fkPerson;
    }

    public void setFkPerson(PersonEntity fkPerson) {
        this.fkPerson = fkPerson;
    }
    
    
    
    
    @Override
    public String toString() {
        return "PersonPersonTypeEntity{" + "personType=" + fkPersonType + ", person=" + fkPerson + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.id);
        hash = 19 * hash + Objects.hashCode(this.fkIdPersonType);
        hash = 19 * hash + Objects.hashCode(this.fkIdPerson);
        hash = 19 * hash + Objects.hashCode(this.fkPersonType);
        hash = 19 * hash + Objects.hashCode(this.fkPerson);
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
        final PersonPersonTypeEntity other = (PersonPersonTypeEntity) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.fkIdPersonType, other.fkIdPersonType)) {
            return false;
        }
        if (!Objects.equals(this.fkIdPerson, other.fkIdPerson)) {
            return false;
        }
        if (!Objects.equals(this.fkPersonType, other.fkPersonType)) {
            return false;
        }
        if (!Objects.equals(this.fkPerson, other.fkPerson)) {
            return false;
        }
        return true;
    }
    
    
    
}
