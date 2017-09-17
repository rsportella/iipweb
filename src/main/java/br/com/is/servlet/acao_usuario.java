package br.com.is.servlet;

import br.com.is.Person.Controller.ControlaUsuario;
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
        System.out.println("Entrei no POST!");
        String parametro = req.getParameter("parametro");

        if (parametro.equals("login")) {
            System.out.println("aqui");
            if (new ControlaUsuario().autenticarUsuario(req, resp)) {
                //encaminharPagina("menu.jsp", request, response);                
                resp.sendRedirect("index.jsp");
            } else {
                encaminharPagina("erro.jsp", req, resp);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        System.out.println("Entrei no GET!");

        String parametro = req.getParameter("parametro");
        System.out.println("Parametro: " + parametro);

        if (parametro.equals("logout")) {
            System.out.println("LOGOUTTTTTT");
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
