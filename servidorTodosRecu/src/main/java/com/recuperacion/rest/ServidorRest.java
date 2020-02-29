package com.recuperacion.rest;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Destroyed;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.agent.model.NewService;

@ApplicationScoped
@ApplicationPath(value="/")
public class ServidorRest extends Application {

	@Inject
	@ConfigProperty(name="server.port")
	private Integer puerto;
	
	//id randon para que se registre con el consul a instancia del servicio
	private String id=UUID.randomUUID().toString();
	
	@Inject
	@ConfigProperty(name="consult.host", defaultValue = "127.0.0.1")
	private String consulHost;
	
	@Inject
	@ConfigProperty(name="consult.port", defaultValue = "8500")
	private Integer consulPort;
	
	@Override
    public Set<Class<?>> getClasses() {
        return Set.of(
        		TodoRest.class
        );
    }
	
	private String getIP() {
		try {
			return Inet4Address.getLocalHost().getHostAddress();
		}catch(UnknownHostException e) {
			e.printStackTrace();
		}
		return "127.0.0.1";
	}
	
	//Creamos una lista para la conexion con Fabio
		List<String> tags = Arrays.asList("urlprefix-/todo");
		
	public void init(@Observes @Initialized(ApplicationScoped.class) Object init) {
		System.out.println("Inicializando");
		
		//se puede dejar por default o especificar el puerto
		ConsulClient client = new ConsulClient(consulHost,consulPort);
		
		NewService s = new NewService();
		
		s.setName("Todo");
		s.setId(id);
		s.setAddress(getIP());
		s.setPort(puerto);
		//Se debe agregar un tag para que haya la conexion entre fabio y consul
		s.setTags(tags);
		
	   //para comprobar si el servicio esta levantado o caido 
		NewService.Check check = new NewService.Check();
	   
	   check.setMethod("GET");
	   check.setHttp("http://"+getIP()+":" + puerto +"/todo" +"/ping");
	   check.setInterval("10s");
	   check.setDeregisterCriticalServiceAfter("20s");
	   
	   s.setCheck(check);
	   
	   client.agentServiceRegister(s);
		
		}
	
	public void destroy(@Observes @Destroyed(ApplicationScoped.class) Object init) {
		ConsulClient client = new ConsulClient(consulHost, consulPort);
		System.out.println("Deteniendo");
		client.agentServiceDeregister( id );
		}
}
