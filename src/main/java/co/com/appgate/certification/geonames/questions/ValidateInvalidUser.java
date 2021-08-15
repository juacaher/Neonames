package co.com.appgate.certification.geonames.questions;

import co.com.appgate.certification.geonames.models.ModelDataInformation;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;
public class ValidateInvalidUser implements Question<Boolean> {

    private List<ModelDataInformation> data;

    public ValidateInvalidUser(List<ModelDataInformation> data) {
        this.data = data;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return data.get(0).getMessage().equals(actor.recall("INVALIDUSER"));
    }

    public static ValidateInvalidUser verify(List<ModelDataInformation> data){
        return new ValidateInvalidUser(data);
    }
}
