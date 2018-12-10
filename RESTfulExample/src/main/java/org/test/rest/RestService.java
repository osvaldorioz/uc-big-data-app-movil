package org.test.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.test.vo.GeolocVO;
import org.test.vo.LocVO;
import org.test.vo.PersonVO;

import com.google.gson.Gson;
import static org.test.singleton.DataSton.locs;
import static org.test.singleton.DataSton.personas;

@Path("/geoloc")
public class RestService {
	
	
	
	private void setPersons() {
		PersonVO p = new PersonVO();
		p.setIdPerson(100);
		p.setNombre("Osvaldo Rios Zambrano");
		personas.add(p);
		
		p = new PersonVO();
		p.setIdPerson(200);
		p.setNombre("Fabiola Sanchez Estrada");
		personas.add(p);
		
		p = new PersonVO();
		p.setIdPerson(300);
		p.setNombre("Miranda Rios Sanchez");
		personas.add(p);
	}
	
	@GET
	@Path("/personas/{id}/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getPersons(@PathParam("id") String id,
            				 @PathParam("name") String name) {
 
		if(personas.size() == 0) {
			setPersons();
		}
		
		if(id!=null && id.length()>0) {
			PersonVO p = new PersonVO();
			p.setIdPerson(new Integer(id));
			p.setNombre(name);
			personas.add(p);
		}
 
		String json = new Gson().toJson(personas );
		System.out.println(json);
		
		return json;
 
	}
	
	@GET
	@Path("/locacion/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getLocs(@PathParam("id") String id) {
		LocVO vo = new LocVO();
		List<GeolocVO> loc = new ArrayList<GeolocVO>();
		Integer id_ = new Integer(id);
		
		if(personas.size() == 0) {
			setPersons();
		}
		PersonVO p = null;
		
		for(PersonVO vp: personas) {
			if(vp.getIdPerson().equals(new Integer(id))) {
				p = vp;
				break;
			}
		}
		
		vo.setName(p.getNombre());
		for(GeolocVO vv: locs) {
			if(vv.getIdPerson().equals(id_)) {
				loc.add(vv);
			}
		}
		vo.setLoc(loc);
		String json = new Gson().toJson(vo );
		System.out.println(json);
		
		return json;
 
	}
	
	@GET
	@Path("/{id}/{lat}/{lon}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response storeLoc(@PathParam("id") String id,
			                 @PathParam("lat") String lat,
							 @PathParam("lon") String lon) {
 
		PersonVO pp = null;
		
		for(PersonVO vp: personas) {
			if(vp.getIdPerson().equals(new Integer(id))) {
				pp = vp;
				break;
			}
		}
		GeolocVO vo = new GeolocVO();
		vo.setIdPerson(new Integer(id));
		vo.setLat(lat);
		vo.setLon(lon);
		locs.add(vo);
		String output = "Localizacion para " + pp.getNombre() +": " + vo.toString();
		System.out.println(output);
 
		return Response.status(200).entity(output).build();
 
	}
 
}
