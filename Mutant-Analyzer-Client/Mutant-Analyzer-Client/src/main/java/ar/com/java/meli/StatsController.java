package ar.com.java.meli;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.java.meli.entity.Respuesta;
import ar.com.java.meli.report.ReportGenerator;

@SuppressWarnings("serial")
@WebServlet(name = "meliStats",urlPatterns = {"/api/stats/"})
public class StatsController extends AbstractController {
	
    public StatsController() {
    	logger.info("INICIALIZO: MELI STAT SERVLETT");
    	initialize();
    }
    
    /**
     * Retorna una simple estadistica de lo registros procesados:
     * count_mutant_dna, count_human_dna y ratio
     *
     * @param void
     * @return HttpServletResponse
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	logger.info("DO_GET INVOCADO");
    	checkService();
    	try {
    		Map<String, String> map = ReportGenerator.generarReporte(mutantService);
    		
			enviarResponseReporte(response,Respuesta.mapToJson(map));
			
		} catch (SQLException e) {
			enviarResponseError(response,e.getMessage());
			logger.error(e.getMessage());
		}
    }
}