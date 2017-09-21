/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.is.Person.Controller;

import br.com.is.Person.Entity.Usuario;
import br.com.is.Util.DAO.Generico;
import br.com.is.Util.Criptografia;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fabricio.pretto
 */
public class UsuarioController {
    
    public boolean authenticate(HttpServletRequest request, HttpServletResponse response) {
        Usuario u = new Usuario();
        
        u.setLogin(String.valueOf(request.getParameter("email")));
        u.setSenha(String.valueOf(Criptografia.md5Criptor(request.getParameter("senha"))));
        
        String[][] criterio = {{"login", u.getLogin()}, {"senha", u.getSenha()}};
        u = (Usuario) new Generico<Usuario>(u).visualizar(criterio);
        
        if (u != null) {
            HttpSession sessao = request.getSession();
            sessao.setAttribute("usuarioLogado", u);
            return true;
        } else {
            return false;
        }
    }
    
    public List list() {
        String[][] criterio = {{"node", "pessoa", "pe"}};
        return new Generico<Usuario>(new Usuario()).Listar(criterio);
    }
}
