/**
 * Created by mhare on 6/1/16.
 */


import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;


@Path("/ftocservice")
public class FtoCService
{
    @GET
    @Produces("application/json")
    public Response convertFtoC() throws JSONException
    {
        JSONObject jsonObject = new JSONObject();
        Double fahrenheit = 98.24;
        Double celsius;
        celsius = (fahrenheit - 32) * 5 / 9;

        jsonObject.put("F Value", fahrenheit);
        jsonObject.put("C Value", celsius);

        String result = "@Produces(\"application/json\") Output: \n\nF to C Convertor Output:\n\n" + jsonObject;
        return Response.status(200).entity(result).build();
    }

    @Path("{f}")
    @GET
    @Produces("application/json")
    public Response convertFtoCfromInput(@PathParam("f") Double f) throws JSONException
    {
        JSONObject jsonObject = new JSONObject();
        Double celsius;
        celsius = (f - 32) * 5 / 9;

        jsonObject.put("F Value", f);
        jsonObject.put("C Value", celsius);

        String result = "@Produces(\"application/json\") Output: \n\nF to C Convertor Output:\n\n" + jsonObject;
        return Response.status(200).entity(result).build();
    }

    @Path("/fahrenheit")
    @GET
    @Produces("application/json")
    public Response convertFtoC(@QueryParam("f") Double f) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        Double fahrenheit = f;
        Double celsius;
        celsius = (f - 32) * 5 / 9;

        jsonObject.put("F Value", f);
        jsonObject.put("C Value", celsius);

        String result = "@Produces(\"application/json\") Output: \n\nF to C Convertor Output:\n\n" + jsonObject;
        return Response.status(200).entity(result).build();
    }

}
