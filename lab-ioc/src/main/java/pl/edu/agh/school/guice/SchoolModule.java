package pl.edu.agh.school.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.google.inject.multibindings.Multibinder;
import com.google.inject.name.Names;
import pl.edu.agh.logger.FileMessageSerializer;
import pl.edu.agh.logger.IMessageSerializer;
import pl.edu.agh.logger.Logger;
import pl.edu.agh.school.persistence.IPersistenceManager;
import pl.edu.agh.school.persistence.SerializablePersistenceManager;

public class SchoolModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Logger.class).in(Singleton.class);
        bind(IPersistenceManager.class).to(SerializablePersistenceManager.class);
        Multibinder<IMessageSerializer> messageSerializerMultibinder =
                Multibinder.newSetBinder(binder(), IMessageSerializer.class);
        messageSerializerMultibinder.addBinding().toInstance(new FileMessageSerializer("persistence.log"));
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
