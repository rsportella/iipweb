package br.com.is.Address.Controller;

import br.com.is.Address.Entity.Logradouro;
import br.com.is.Util.DAO.Generico;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Portella,Rodolfo <rodolfosportella@gmail.com>
 */
public class LogradouroController {

    public boolean save(HttpServletRequest request, HttpServletResponse response) {

        boolean retorno = false;
        Logradouro te = new Logradouro();
        int codigo = ((request.getParameter("codigo").isEmpty())
                ? 0 : Integer.valueOf(request.getParameter("codigo")));
        te.setCodigo(codigo);
        te.setNome(request.getParameter("nome"));
        te.setSigla(request.getParameter("sigla"));
        boolean status = ((request.getParameter("status") != null) ? true : false);
        te.setStatus(status);

        if (new Generico<Logradouro>(te).gravar()) {
            System.out.println("Gravado com sucesso");
            retorno = true;
        }

        return retorno;
    }

    public boolean delete(HttpServletRequest request, HttpServletResponse response) {

        boolean retorno = false;
        String[][] criterios = {{"codigo", request.getParameter("codigo")}};
        Logradouro te = new Generico<Logradouro>(new Logradouro()).visualizar(criterios);
        if (new Generico<Logradouro>(te).excluir()) {
            System.out.println("Excluído com sucesso");
            retorno = true;
        }

        return retorno;
    }

    public List list() {
        return new Generico<Logradouro>(new Logradouro()).Listar(null);
    }
}
