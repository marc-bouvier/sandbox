package fr.baldir.architecture;

import static io.restassured.RestAssured.given;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class TechnicalArchitectureDocumentResourceTest {

  @Test
  public void testHelloEndpoint() {

    var response = given().when().get("/technical-architecture-document");
    var body = response.getBody();
    assertThat(body.asString()).isEqualTo(loadResourceAsString("expected-demo-result.md"));
    response.then().statusCode(200);
  }

  private String loadResourceAsString(String resourceName) {
    ClassLoader classLoader = this.getClass().getClassLoader();
    try (var inputStream = classLoader.getResourceAsStream(resourceName)) {
      return IOUtils.toString(inputStream, "UTF-8");
    } catch (IOException ioException) {
      fail("Cannot load test fixture reource : " + resourceName);
      return "";
    }
  }

}
