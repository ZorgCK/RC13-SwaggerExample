package software.xdev.swagger_rapidclipse.rest.controller;

import java.util.List;
import java.util.Optional;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;



@Path("/beverage")
public class BeverageController
{
	private final BeverageDB beverageDB = BeverageDB.getInstance();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllBeverages()
	{
		List<Beverage> beverageList = beverageDB.getAll();

		return Response
			.status(Response.Status.OK)
			.entity(beverageList)
			.build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createBeverage(final String beverageName)
	{

		Beverage beverage = beverageDB.addBeverage(beverageName);

		return Response
			.status(Response.Status.OK)
			.entity(beverage)
			.build();
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateBeverage(final Beverage jaxbElement)
	{
		final Beverage updateDTO = jaxbElement;
		
		Optional<Beverage> optBeverage = beverageDB.update(updateDTO);

		if(optBeverage.isPresent()) {
			return Response
					.status(Response.Status.OK)
					.entity(optBeverage.get())
					.build();
		}
		return Response
			.status(Response.Status.NOT_FOUND)
			.build();
	}

	@DELETE
	@Path("{beverageId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteBeverage(@PathParam("beverageId") final int beverageId)
	{
		Optional<Beverage> optBeverage = beverageDB.delete(beverageId);

		if(optBeverage.isPresent())
		{
			return Response
				.status(Response.Status.OK)
				.entity(optBeverage.get())
				.build();
		}

		return Response
			.status(Response.Status.NOT_FOUND)
			.build();
	}
}
