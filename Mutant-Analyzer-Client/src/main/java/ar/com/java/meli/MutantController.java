package ar.com.java.meli;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import ar.com.java.meli.analyzer.MutantAnalyzer;
import ar.com.java.meli.entity.RequestJSonEntity;
import ar.com.java.meli.utils.Validator;

@SuppressWarnings("serial")
@WebServlet(name = "meliMutant",urlPatterns = {"/api/mutant/"})
public class MutantController extends AbstractController {

	public MutantController() {
		logger.info("INICIALIZO: MELI MUTANT SERVLETT");
		initialize();
	}
	
    /**
     * Retorna 200 Ok si es mutante
     * Retorna 403 Forbidden si no es mutante
     *
     * @param json: DNA, String[] cuadrada
     * @return HttpServletResponse
     * @throws IOException
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	
    	checkService();
    	
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
	    			mutantService.putMutant();
	    			enviarResposeMutant(response);
	    		}else {
	    			mutantService.putHuman();
	    			enviarResposeHuman(response);
	    		}
	    	}
    	} catch (SQLException e) {
    		enviarResponseError(response,e.getMessage());
    		logger.error(e.getMessage());
		}
    }
}