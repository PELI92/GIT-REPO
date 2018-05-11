package ar.com.java.meli;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonObject;

import ar.com.java.meli.services.MutantService;

@SuppressWarnings("serial")
public abstract class AbstractController extends HttpServlet {
	
	protected static final Logger logger = LoggerFactory.getLogger(AbstractController.class);
	protected static final String PROTOCOL = "HTTP";
	protected static final String OK = "200-OK";
	protected static final String FORBIDDEN = "403-FORBIDDEN";
	protected static final String BAD_REQUEST = "400-Bad-Request";
	protected MutantService mutantService = null;

    protected void checkService() throws IOException {
		if(this.mutantService == null) {
			IOException ioe =new IOException("Servicio de baja, imposible conectar a base de datos");
			logger.error( ioe.getMessage());
    		throw ioe;
    	}
	}

	protected void enviarResponseReporte(HttpServletResponse response,String json) throws IOException {
		setResponse(response);
		response.getWriter().print(json);
	}
    protected void enviarResposeMutant(HttpServletResponse response) throws IOException {
		setResponse(response);
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty(PROTOCOL, OK);
		response.getWriter().print(jsonObject);
	}
    protected void enviarResposeHuman(HttpServletResponse response) throws IOException {
		setResponse(response);
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty(PROTOCOL, FORBIDDEN);
		response.getWriter().print(jsonObject);
	}
    protected void enviarResponseError(HttpServletResponse response,String message) throws IOException {
		setResponse(response);
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty(PROTOCOL, BAD_REQUEST + message);
		response.getWriter().print(jsonObject);
	}
    protected void setResponse(HttpServletResponse response) {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
	}
    public void initialize() {
    	try {
			mutantService = new MutantService();
		} catch (SQLException e) {
			logger.error( e.getMessage());
		}     	
    }
}