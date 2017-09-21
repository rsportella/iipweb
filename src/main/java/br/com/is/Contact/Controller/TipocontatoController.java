package br.com.is.Contact.Controller;

import br.com.is.Contact.Entity.TipoContato;
import br.com.is.Util.DAO.Generico;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Portella,Rodolfo <rodolfosportella@gmail.com>
 */
public class TipocontatoController {

    public boolean save(HttpServletRequest request, HttpServletResponse response) {

        boolean retorno = false;
        TipoContato tc = new TipoContato();
        int codigo = ((request.getParameter("codigo").isEmpty())
                ? 0 : Integer.valueOf(request.getParameter("codigo")));
        tc.setCodigo(codigo);
        tc.setNome(request.getParameter("nome"));
        tc.setSigla(request.getParameter("sigla"));
        tc.setDescricao(request.getParameter("descricao"));
        boolean status = ((request.getParameter("status") != null) ? true : false);
        System.out.println("aquiii  " + status);
        tc.setStatus(status);

        if (new Generico<TipoContato>(tc).gravar()) {
            System.out.println("Gravado com sucesso");
            retorno = true;
        }

        return retorno;
    }

    public boolean delete(HttpServletRequest request, HttpServletResponse response) {

        boolean retorno = false;
        String[][] criterios = {{"codigo", request.getParameter("codigo")}};
        TipoContato tc = new Generico<TipoContato>(new TipoContato()).visualizar(criterios);
        if (new Generico<TipoContato>(tc).excluir()) {
            System.out.println("Excluído com sucesso");
            retorno = true;
        }

        return retorno;
    }

    public List list() {
        return new Generico<TipoContato>(new TipoContato()).Listar(null);
    }
}
