package application.rest;

import java.util.Map;
import java.util.Properties;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("")
public class HelloResource {

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String hello() {
		return "<html><body><h2>REST Resources: <a href=\"getenv\">/getenv</a> and <a href=\"properties\">/properties</a></h2></body></html>";
	}

	@GET
	@Path("/getenv")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String,String> getenv() {
		return System.getenv();
	}

	@GET
	@Path("/properties")
	@Produces(MediaType.APPLICATION_JSON)
	public Properties getProperties() {
		return System.getProperties();
	}
}
