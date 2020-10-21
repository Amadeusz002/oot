package pl.edu.agh.school.guice;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import pl.edu.agh.school.persistence.IPersistenceManager;
import pl.edu.agh.school.persistence.SerializablePersistenceManager;

public class SchoolModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(IPersistenceManager.class).to(SerializablePersistenceManager.class);
        bind(String.class).annotatedWith(Names.named("teachers")).toInstance("teachers_bis.dat");
        bind(String.class).annotatedWith(Names.named("class")).toInstance("class_bis.dat");
    }
/*
    @Provides
    @Named("teachers")
    String provideTeachersStorageFileName(){
        return "teachers.dat";
    }

    @Provides
    @Named("class")
    String provideClassStorageFileName(){
        return "class.dat";
    }

 */
}
