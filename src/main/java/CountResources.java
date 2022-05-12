import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Date;

@Path("/count")
public class CountResources {
    @Inject
    CounterBean counterBean;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Count -->>> " + counterBean.get() +" "+ new Date().toString();
    }
}
