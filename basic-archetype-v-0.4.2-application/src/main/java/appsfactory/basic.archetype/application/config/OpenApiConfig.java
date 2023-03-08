package appsfactory.basic.archetype.application.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * OpenAPI Configuration.
 */
@Configuration
public class OpenApiConfig {

  @Value("${spring.application.name}")
  private String applicationName;

  /**
   * Creates the bean for the public API.
   *
   * @return bean for the public API
   */
  @Bean
  public OpenAPI publicApi(BuildProperties buildProperties) {

    return new OpenAPI()
        .info(new Info()
            .title(applicationName)
            .description("API Documentation")
            .version(buildProperties.getVersion()))
        .externalDocs(new ExternalDocumentation()
            .description(applicationName" API Documentation"));
  }

}
