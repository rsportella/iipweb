package br.com.is.Address.Controller;

import br.com.is.Address.Entity.Cidade;
import br.com.is.Address.Entity.Estado;
import br.com.is.Util.DAO.Generico;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Portella,Rodolfo <rodolfosportella@gmail.com>
 */
public class CidadeController {

    public boolean save(HttpServletRequest request, HttpServletResponse response) {

        boolean retorno = false;
        Cidade ci = new Cidade();
        int codigo = ((request.getParameter("codigo").isEmpty())
                ? 0 : Integer.valueOf(request.getParameter("codigo")));
        ci.setCodigo(codigo);
        ci.setNome(request.getParameter("nome"));
        String[][] criterios = {{"codigo", request.getParameter("Estado")}};
        Estado es = new Generico<Estado>(new Estado()).visualizar(criterios);
        ci.setEstado(es);
        boolean status = ((request.getParameter("status") != null) ? true : false);
        ci.setStatus(status);

        if (new Generico<Cidade>(es).gravar()) {
            System.out.println("Gravado com sucesso");
            retorno = true;
        }

        return retorno;
    }

    public boolean delete(HttpServletRequest request, HttpServletResponse response) {

        boolean retorno = false;
        String[][] criterios = {{"codigo", request.getParameter("codigo")}};
        Cidade ci = new Generico<Cidade>(new Cidade()).visualizar(criterios);
        if (new Generico<Cidade>(ci).excluir()) {
            System.out.println("Excluído com sucesso");
            retorno = true;
        }

        return retorno;
    }

    public List list(int estado) {
        String[][] criterios = {
            {"node", "estado", "est"},
            {"equal", "est.codigo", String.valueOf(estado)}
        };
        return new Generico<Cidade>(new Cidade()).Listar(criterios);
    }
}
