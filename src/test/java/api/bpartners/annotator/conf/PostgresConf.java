package api.bpartners.annotator.conf;

import api.bpartners.annotator.PojaGenerated;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.testcontainers.containers.PostgreSQLContainer;

@PojaGenerated
@SuppressWarnings("all")
public class PostgresConf {

  private final PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:13.9");

  void start() {
    postgres.start();
  }

  void stop() {
    postgres.stop();
  }

  void configureProperties(DynamicPropertyRegistry registry) {
    registry.add("spring.datasource.url", postgres::getJdbcUrl);
    registry.add("spring.datasource.username", postgres::getUsername);
    registry.add("spring.datasource.password", postgres::getPassword);
  }
}
