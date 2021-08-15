package co.com.appgate.certification.geonames.tasks;

import co.com.appgate.certification.geonames.models.InvalidUser;
import co.com.appgate.certification.geonames.models.ModelDataInformation;
import co.com.appgate.certification.geonames.models.ModelGeoNames;
import co.com.appgate.certification.geonames.models.Status;
import co.com.appgate.certification.geonames.utils.Headers;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

import java.util.List;

import static co.com.appgate.certification.geonames.utils.Constants.URL_REQUEST;
import static co.com.appgate.certification.geonames.utils.Constants.URL_REQUEST_USER_INVALID;

public class ConsultInvalidUser implements Task {

    private List<ModelDataInformation> data;

    public ConsultInvalidUser(List<ModelDataInformation> data) {
        this.data = data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(String.format(URL_REQUEST_USER_INVALID, data.get(0).getLatitude(), data.get(0).getLength())).with(request -> request
                        .header(Headers.CONTENT_TYPE.getKey(), Headers.CONTENT_TYPE.getValue())
                )
        );
        InvalidUser invUser = new InvalidUser();
        Status status = new Status();
        status.setMessage(SerenityRest.lastResponse().jsonPath().get("status.message").toString());
        invUser.setStatus(status);
        actor.remember("INVALIDUSER",invUser.getStatus().getMessage());
    }

    public static ConsultInvalidUser with(List<ModelDataInformation> data) {
        return Tasks.instrumented(ConsultInvalidUser.class, data);
    }
}
