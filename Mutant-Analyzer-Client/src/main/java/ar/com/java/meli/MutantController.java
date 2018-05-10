package ar.com.java.meli;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import ar.com.java.meli.analyzer.MutantAnalyzer;
import ar.com.java.meli.entity.RequestJSonEntity;
import ar.com.java.meli.entity.Respuesta;
import ar.com.java.meli.enums.KeysEnum;
import ar.com.java.meli.report.ReportGenerator;
import ar.com.java.meli.services.MutantService;
import ar.com.java.meli.utils.Validator;

@SuppressWarnings("serial")
@WebServlet(
    name = "HelloAppEngine",
    urlPatterns = {"/api/mutant"}
)
public class MutantController extends HttpServlet {
	private static final String PROTOCOL = "HTTP";
    private static final String OK = "200-OK";
    private static final String FORBIDDEN = "403-FORBIDDEN";
    private static final String BAD_REQUEST = "400-Bad-Request";
 

    
    private  MutantService mutantService = null;
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = request.getReader();
        
        try {
            String line;
            while ((line = reader.readLine()) != null)
                sb.append(line).append('\n');
        } finally {
            reader.close();
        }
        
    	Gson gson = new Gson();
    	RequestJSonEntity dna = gson.fromJson(sb.toString(), RequestJSonEntity.class);
    	try {
	    	if(!Validator.isCadenaDnaValid(dna.getDNA())){
	    		enviarResponseError(response, "Cadena ADN invalida");
	    	}else {
	    		MutantAnalyzer ma = new MutantAnalyzer();
	    		if(ma.isMutant(dna.getDNA())) {
	    			this.mutantService.putMutant();
	    			enviarResposeMutant(response);
	    		}else {
	    			this.mutantService.putHuman();
	    			enviarResposeHuman(response);
	    		}
	    	}
    	} catch (SQLException e) {
    		enviarResponseError(response,e.getMessage());
		}finally {
    		
    	}
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	try {
    		Map<String, String> map = ReportGenerator.generarReporte(mutantService);
    		
			enviarResponseReporte(response,Respuesta.mapToJson(map));
			
		} catch (SQLException e) {
			enviarResponseError(response,e.getMessage());
			e.printStackTrace();
		}
    }

	private void enviarResponseReporte(HttpServletResponse response,String json) throws IOException {
		setResponse(response);
		response.getWriter().print(json);
	}
	private void enviarResposeMutant(HttpServletResponse response) throws IOException {
		setResponse(response);
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty(PROTOCOL, OK);
		response.getWriter().print(jsonObject);
	}
	private void enviarResposeHuman(HttpServletResponse response) throws IOException {
		setResponse(response);
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty(PROTOCOL, FORBIDDEN);
		response.getWriter().print(jsonObject);
	}
	private void enviarResponseError(HttpServletResponse response,String message) throws IOException {
		setResponse(response);
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty(PROTOCOL, BAD_REQUEST + message);
		response.getWriter().print(jsonObject);
	}
	private void setResponse(HttpServletResponse response) {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
	}
	public void init() {
    	this.mutantService = new MutantService();
	}
}