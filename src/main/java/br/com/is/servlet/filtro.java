package br.com.is.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class filtro extends HttpServlet implements Filter {

    List<String> urls = new ArrayList<>();

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
            out.println("<title>Servlet filtro</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet filtro at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        urls.add("/iipweb/resources/");
        urls.add("/iipweb/login.jsp");
        urls.add("/iipweb/acao_usuario");
        urls.add("/iipweb/erro.jsp");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        // verifica se URL requisitada consta na lista de URLs permitidas
        // caso afirmativo, envia para página de Login
        if (urls.contains(req.getRequestURI())) {
            request.setAttribute("parametro", "login");
            chain.doFilter(request, response);
        } else {
            HttpSession  sessao = ((HttpServletRequest) request).getSession();

            // caso não pertença a lista, verifica se há usuário na sessão
            // se não houver, encaminha para o Login
            if (sessao.getAttribute("usuarioLogado") == null) {
                ((HttpServletResponse) response).sendRedirect("/iipweb/login.jsp");
            } else {
                // se usuário estiver logado, apenas abra a página solicitada
                System.out.println("Destino: " + req.getRequestURI());
                chain.doFilter(request, response);
            }
        }
    }

}
