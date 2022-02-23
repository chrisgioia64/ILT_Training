package lecture12;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

public class ErgastAPI {

    private ResponseSpecification checkStatusAndContentType =
            new ResponseSpecBuilder().
                    expectStatusCode(200).
                    expectContentType(ContentType.JSON).build();

	@Test(dataProvider = "years")
    public void test1(int year, int numberOfRaces) {
//        int year = 2018;
//        int numberOfRaces = 21;

        given().pathParam("raceSeason", year).
                when().get("http://ergast.com/api/f1/{raceSeason}/circuits.json")
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .contentType(ContentType.JSON)
                .and()
//                .header("Content-Length", Matchers.equalTo("4551"));
                .body("MRData.CircuitTable.Circuits.circuitId", Matchers.hasSize(numberOfRaces));
    }

    @Test
    public void testBasicAuthentication() {
        given().
//                auth().
//                preemptive().
//                basic("username", "password").
                when().
                get("http://path.to/basic/secured/api").
                then().
                assertThat().
                statusCode(200);
    }

    @Test
    public void testExtract() {
        String circuitId = given().
                when().
                get("http://ergast.com/api/f1/2017/circuits.json").
                then().
                extract().
                path("MRData.CircuitTable.Circuits.circuitId[0]");

        given().
                pathParam("circuitId",circuitId).
                when().
                get("http://ergast.com/api/f1/circuits/{circuitId}.json").
                then().
                assertThat().
                body("MRData.CircuitTable.Circuits.Location[0].country",Matchers.equalTo("Australia"));

    }

    @Test
    public void testResponseSpecBuilder() {
        given().
                when().
                get("http://ergast.com/api/f1/2017/circuits.json").
                then().
                assertThat().
                spec(this.checkStatusAndContentType).
                and().
                body("MRData.CircuitTable.Circuits.circuitId",Matchers.hasSize(20));
    }

    @DataProvider(name = "years")
    public Object[][] getData() {
        Object[][] result = new Object[][] {
                {2017, 20},
                {2018, 21},
                {2019, 21}
        };
        return result;
    }
}
