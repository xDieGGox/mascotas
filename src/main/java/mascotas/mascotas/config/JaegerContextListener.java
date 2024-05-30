package mascotas.mascotas.config;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class JaegerContextListener implements ServletContextListener{

	@Override
    public void contextInitialized(ServletContextEvent sce) {
        JaegerConfig.initTracer();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // No-op
    }
}
