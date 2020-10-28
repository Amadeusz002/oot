package pl.edu.agh.school.guice;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import pl.edu.agh.logger.FileMessageSerializer;
import pl.edu.agh.logger.IMessageSerializer;
import pl.edu.agh.school.persistence.IPersistenceManager;
import pl.edu.agh.school.persistence.SerializablePersistenceManager;

public class LoggerModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(IMessageSerializer.class).toInstance(new FileMessageSerializer("persistence.log"));
        bind(String.class).annotatedWith(Names.named("teachers")).toInstance("teachers_bis.dat");
        bind(String.class).annotatedWith(Names.named("class")).toInstance("class_bis.dat");
    }
}
