package br.com.is.servlet;

import br.com.is.Address.Controller.CidadeController;
import br.com.is.Address.Entity.Cidade;
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
public class CidadeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String action = "" + req.getParameter("action");

        if (action.equals("save")) {
            new CidadeController().save(req, resp);
            encaminharPagina("cidade.jsp?action=", req, resp);
        } else {
            resp.sendRedirect("cidade.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String action = "" + req.getParameter("action");

        if (action.equals("delete")) {
            new CidadeController().delete(req, resp);
            encaminharPagina("cidade.jsp?action=", req, resp);

        } else if (action.equals("edit")) {
            String[][] criterios = {{"codigo", req.getParameter("codigo")}};
            Cidade cidade = new Generico<Cidade>(new Cidade()).visualizar(criterios);

            req.setAttribute("cidade", cidade);
            encaminharPagina("cidade.jsp?action=noe", req, resp);
        } else {
            int estado = Integer.parseInt(req.getParameter("codigo"));
            List<Cidade> cidades = new CidadeController().list(estado);
            req.setAttribute("cidades", cidades);
            encaminharPagina("cidade.jsp?action=", req, resp);
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
