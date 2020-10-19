package pl.edu.agh.iisg.to.dao;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

import org.hibernate.Session;
import pl.edu.agh.iisg.to.model.Course;
import pl.edu.agh.iisg.to.model.Student;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

public class StudentDao extends GenericDao<Student> {

    public Optional<Student> create(final String firstName, final String lastName, final int indexNumber) {
    	Student student = new Student(firstName,lastName,indexNumber);
    	try{
    	    this.save(student);
    	    return Optional.of(student);
        } catch (PersistenceException e){
    	    e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<Student> findByIndexNumber(final int indexNumber) {
    	final Session session = currentSession();
        try{
            Student student = session.createQuery("SELECT  s FROM Student s WHERE s.indexNumber = :index", Student.class)
                    .setParameter("index", indexNumber)
                    .getSingleResult();
            return Optional.ofNullable(student);
        } catch (PersistenceException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Map<Course, Float> createReport(final Student student) {
        //TODO additional task
        return Collections.emptyMap();
    }

}
