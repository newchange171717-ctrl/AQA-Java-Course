import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostmanEchoRequestMethodsTest {

    private static final String BASE_URL = "https://postman-echo.com";

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = BASE_URL;

        // Отключаем автоматическое добавление charset (решает проблему 500)
        RestAssured.config = RestAssured.config()
                .encoderConfig(EncoderConfig.encoderConfig()
                        .appendDefaultContentCharsetToContentTypeIfUndefined(false));
    }

    // ====================== GET ======================
    @Test
    public void testGetRequest() {
        given()
                .log().ifValidationFails()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .log().ifValidationFails()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("url", containsString("foo1=bar1"))
                .body("url", containsString("foo2=bar2"));
    }

    // ====================== POST Form Data (исправлено) ======================
    @Test
    public void testPostFormData() {
        given()
                .log().all()                    // оставляем полный лог для отладки
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post("/post")
                .then()
                .log().ifError()
                .statusCode(200)
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"))
                // Исправленная проверка: json теперь содержит объект, а не null
                .body("json.foo1", equalTo("bar1"))
                .body("json.foo2", equalTo("bar2"));
    }

    // ====================== POST Raw JSON ======================
    @Test
    public void testPostRawJson() {
        String jsonBody = """
                {
                    "name": "John",
                    "age": 30,
                    "city": "New York"
                }
                """;

        given()
                .log().ifValidationFails()
                .contentType(ContentType.JSON)
                .body(jsonBody)
                .when()
                .post("/post")
                .then()
                .log().ifValidationFails()
                .statusCode(200)
                .body("json.name", equalTo("John"))
                .body("json.age", equalTo(30))
                .body("json.city", equalTo("New York"));
    }

    // ====================== PUT ======================
    @Test
    public void testPutRequest() {
        String jsonBody = """
                {
                    "name": "Updated Name",
                    "id": 123
                }
                """;

        given()
                .log().ifValidationFails()
                .contentType(ContentType.JSON)
                .body(jsonBody)
                .when()
                .put("/put")
                .then()
                .log().ifValidationFails()
                .statusCode(200)
                .body("json.name", equalTo("Updated Name"))
                .body("json.id", equalTo(123));
    }

    // ====================== PATCH ======================
    @Test
    public void testPatchRequest() {
        String jsonBody = """
                {
                    "status": "active"
                }
                """;

        given()
                .log().ifValidationFails()
                .contentType(ContentType.JSON)
                .body(jsonBody)
                .when()
                .patch("/patch")
                .then()
                .log().ifValidationFails()
                .statusCode(200)
                .body("json.status", equalTo("active"));
    }

    // ====================== DELETE ======================
    @Test
    public void testDeleteRequest() {
        given()
                .log().ifValidationFails()
                .when()
                .delete("/delete")
                .then()
                .log().ifValidationFails()
                .statusCode(200);
    }
}