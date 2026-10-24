package Control;

import Modelo.Cinemometro;
import Modelo.CinemometroDAO;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CinemometroController", urlPatterns = {"/CinemometroController"})
public class CinemometroController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String departamento = request.getParameter("departamento");
        int anio = Integer.parseInt(request.getParameter("anio"));
        
        CinemometroDAO dao = new CinemometroDAO();
        List<Cinemometro> lista = dao.filtrarCinemometros(departamento, anio);
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        PrintWriter out = response.getWriter();
        out.print(new Gson().toJson(lista));
        out.flush();
    }
}
