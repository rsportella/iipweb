package br.com.is.Address.Controller;

import br.com.is.Address.Entity.Pais;
import br.com.is.Util.DAO.Generico;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Portella,Rodolfo <rodolfosportella@gmail.com>
 */
public class PaisController {

    public boolean save(HttpServletRequest request, HttpServletResponse response) {

        boolean retorno = false;
        Pais pa = new Pais();
        int codigo = ((request.getParameter("codigo").isEmpty())
                ? 0 : Integer.valueOf(request.getParameter("codigo")));
        pa.setCodigo(codigo);
        pa.setNome(request.getParameter("nome"));
        pa.setSigla(request.getParameter("sigla"));
        boolean status = ((request.getParameter("status") != null) ? true : false);
        pa.setStatus(status);

        if (new Generico<Pais>(pa).gravar()) {
            System.out.println("Gravado com sucesso");
            retorno = true;
        }

        return retorno;
    }

    public boolean delete(HttpServletRequest request, HttpServletResponse response) {

        boolean retorno = false;
        String[][] criterios = {{"codigo", request.getParameter("codigo")}};
        Pais pa = new Generico<Pais>(new Pais()).visualizar(criterios);
        if (new Generico<Pais>(pa).excluir()) {
            System.out.println("Excluído com sucesso");
            retorno = true;
        }

        return retorno;
    }

    public List list() {
        return new Generico<Pais>(new Pais()).Listar(null);
    }
}
