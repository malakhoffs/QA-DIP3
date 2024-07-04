package API;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserWipeStep {

    @Step("Logging in user")
    public static Response userCatchToken(String email, String password) {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        return given()
                .baseUri("https://stellarburgers.nomoreparties.site/api/")
                .header("Content-Type", "application/json")
                .body("{\"email\":\"" + email + "\", \"password\": \"" + password + "\"}")
                .when()
                .post("auth/login");
    }

    @Step("Deleting user")
    public static void userWipe(String accessToken) {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        if (accessToken != null) {
            given()
                    .baseUri("https://stellarburgers.nomoreparties.site/api/")
                    .header("Content-Type", "application/json")
                    .header("Authorization", accessToken)
                    .delete("auth/user");
        } else {
            System.out.println("Something went wrong, nothing to remove");
        }
    }
}
