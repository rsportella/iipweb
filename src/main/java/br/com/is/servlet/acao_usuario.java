package br.com.is.servlet;

import br.com.is.Person.Controller.UsuarioController;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Portella, Rodolfo <rodolfosportella@gmail.com>
 */
public class acao_usuario extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String parametro = req.getParameter("parametro");
        if (parametro.equals("login")) {
            if (new UsuarioController().authenticate(req, resp)) {
                resp.sendRedirect("index.jsp");
            } else {
                encaminharPagina("erro.jsp", req, resp);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String parametro = req.getParameter("parametro");
        if (parametro.equals("logout")) {
            HttpSession sessao = req.getSession();
            sessao.invalidate();
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }

    private void encaminharPagina(String pagina, HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher(pagina);
            rd.forward(request, response);
        } catch (Exception e) {
            System.out.println("Erro ao encaminhar: " + e);
        }
    }
}
