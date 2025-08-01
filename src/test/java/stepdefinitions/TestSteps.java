package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pojo.testPost.PostResponseBody;
import org.example.apis.Impl.TestImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class TestSteps {
    private static final Logger log = LoggerFactory.getLogger(TestSteps.class);
    TestImpl requestApi=new TestImpl();
    PostResponseBody response;
    @When("user calls {string} api")
    public void user_calls_api(String apiMethod){
       response=requestApi.getPostRequestResponse("api/users");
    }
    @Then("the API call got success with job {string}")
    public void the_api_call_got_success_with_job(String job){
        Assert.assertEquals(job,response.getJob());

    }
}
