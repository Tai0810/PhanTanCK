package entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "OfficeAssignment")
public class OfficeAssignment implements Serializable {
    private static final long serialVersionUID = -4398744465887167245L;
    
    @Id
    @OneToOne
    @JoinColumn(name = "InstructorID")
    private Instructor instructor;
    
    private String location;
    
    @Column(name = "Timestamp", columnDefinition = "DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP")
    private Timestamp timestamp;

    public OfficeAssignment() {
    }
    
    public OfficeAssignment(Instructor instructor, String location, Timestamp timestamp) {
        this.instructor = instructor;
        this.location = location;
        this.timestamp = timestamp;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OfficeAssignment that = (OfficeAssignment) o;
        return Objects.equals(instructor, that.instructor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(instructor);
    }

    @Override
    public String toString() {
        return "OfficeAssignment [instructor=" + instructor.getId() + ", location=" + location + ", timestamp="
                + timestamp + "]";
    }
}
