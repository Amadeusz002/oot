package pl.edu.agh.school;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.edu.agh.logger.Logger;
import pl.edu.agh.school.guice.SchoolModule;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class SchoolModuleTest {
    @Test
    public void testLoggerSingleton(){
        Injector injector = Guice.createInjector(new SchoolModule());
        Logger log1 = injector.getInstance(Logger.class);
        Logger log2 = injector.getInstance(Logger.class);
        assertSame(log1, log2);
    }
}
