package pl.edu.agh.school.persistence;

import pl.edu.agh.logger.Logger;
import pl.edu.agh.school.SchoolClass;
import pl.edu.agh.school.Teacher;

import javax.inject.Inject;
import java.util.List;

public abstract class IPersistenceManager {

    @Inject protected Logger log;

    public abstract void saveTeachers(List<Teacher> teachers);

    public abstract List<Teacher> loadTeachers();

    public abstract void saveClasses(List<SchoolClass> classes);

    public abstract List<SchoolClass> loadClasses();
}
