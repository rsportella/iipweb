package br.com.is.servlet;

import br.com.is.Address.Controller.EstadoController;
import br.com.is.Address.Entity.Estado;
import br.com.is.Address.Entity.Pais;
import br.com.is.Util.DAO.Generico;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Portella, Rodolfo <rodolfosportella@gmail.com>
 */
public class EstadoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("post");
        req.setCharacterEncoding("UTF-8");
        String action = "" + req.getParameter("action");

        if (action.equals("save")) {
            new EstadoController().save(req, resp);
            encaminharPagina("estado.jsp?action=", req, resp);
        } else {
            resp.sendRedirect("estado.jsp?action=");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String action = "" + req.getParameter("action");

        if (action.equals("delete")) {
            new EstadoController().delete(req, resp);
            encaminharPagina("estado.jsp?action=", req, resp);
        } else if (action.equals("edit") || action.equals("new")) {
            String[][] criteriosPais = {{"codigo", req.getParameter("codigo")}};
            Pais pais = new Generico<Pais>(new Pais()).visualizar(criteriosPais);
            req.setAttribute("pais", pais);
            if (action.equals("edit")) {
                String[][] criteriosEstado = {{"codigo", req.getParameter("codigo")}};
                Estado estado = new Generico<Estado>(new Estado()).visualizar(criteriosEstado);

                req.setAttribute("estado", estado);
            }
            encaminharPagina("estado.jsp?action=noe", req, resp);
        } else {
            int pais = Integer.parseInt(req.getParameter("codigo"));
            List<Estado> estados = new EstadoController().list(pais);
            req.setAttribute("pais", req.getParameter("codigo"));
            req.setAttribute("estados", estados);
            encaminharPagina("estado.jsp?action=", req, resp);
        }
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet acao</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet acao aaaa aaaaaaaat " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void encaminharPagina(String pagina, HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher(pagina);
            rd.forward(request, response);
        } catch (Exception e) {
            System.out.println("Erro ao encaminhar: " + e);
        }
    }
}
