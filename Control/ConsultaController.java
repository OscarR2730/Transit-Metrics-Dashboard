package Control;

import Modelo.Accidente;
import Modelo.AccidenteDAO;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ConsultaController", urlPatterns = {"/ConsultaController"})
public class ConsultaController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String departamento = request.getParameter("departamento");
        int anio = Integer.parseInt(request.getParameter("anio"));
        
        AccidenteDAO dao = new AccidenteDAO();
        List<Accidente> resultados = dao.filtrarAccidentes(departamento, anio);
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        PrintWriter out = response.getWriter();
        out.print(new Gson().toJson(resultados));
        out.flush();
    }
}

