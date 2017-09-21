package br.com.is.Address.Controller;

import br.com.is.Address.Entity.Estado;
import br.com.is.Address.Entity.Pais;
import br.com.is.Util.DAO.Generico;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Portella,Rodolfo <rodolfosportella@gmail.com>
 */
public class EstadoController {

    public boolean save(HttpServletRequest request, HttpServletResponse response) {

        boolean retorno = false;
        Estado es = new Estado();
        int codigo = ((request.getParameter("codigo").isEmpty())
                ? 0 : Integer.valueOf(request.getParameter("codigo")));
        es.setCodigo(codigo);
        es.setNome(request.getParameter("nome"));
        es.setUf(request.getParameter("uf"));
        String[][] criterios = {{"codigo", request.getParameter("pais")}};
        Pais pa = new Generico<Pais>(new Pais()).visualizar(criterios);
        es.setPais(pa);
        boolean status = ((request.getParameter("status") != null) ? true : false);
        es.setStatus(status);

        if (new Generico<Estado>(es).gravar()) {
            System.out.println("Gravado com sucesso");
            retorno = true;
        }

        return retorno;
    }

    public boolean delete(HttpServletRequest request, HttpServletResponse response) {

        boolean retorno = false;
        String[][] criterios = {{"codigo", request.getParameter("codigo")}};
        Estado es = new Generico<Estado>(new Estado()).visualizar(criterios);
        if (new Generico<Estado>(es).excluir()) {
            System.out.println("Excluído com sucesso");
            retorno = true;
        }

        return retorno;
    }

    public List list(int pais) {
        String[][] criterios = {
            {"node", "pais", "pa"},
            {"equal", "pa.codigo", String.valueOf(pais)}
        };
        return new Generico<Estado>(new Estado()).Listar(criterios);
    }
}
