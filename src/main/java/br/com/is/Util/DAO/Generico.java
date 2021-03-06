package br.com.is.Util.DAO;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 * @author Portella, Rodolfo <rodolfosportella@gmail.com>
 * @param <T>
 */
public class Generico<T> {

    public Object obj;
    public Session s;

    public Generico(Object obj) {
        s = HibernateUtil.getSession();
        s.beginTransaction();
        this.obj = obj;
    }

    public boolean gravar() {
        try {
            s.saveOrUpdate(this.obj);
            s.getTransaction().commit();
            return true;
        } catch (Exception e) {
            s.getTransaction().rollback();
            System.out.println("Erro ao gravar: " + e.getMessage());
            return false;
        } finally {
            s.close();
        }
    }

    public boolean excluir() {
        try {
            s.delete(this.obj);
            s.getTransaction().commit();
            return true;
        } catch (Exception e) {
            s.getTransaction().rollback();
            System.out.println("Erro ao excluir: " + e.getMessage());
            return false;
        } finally {
            s.close();
        }
    }

    public T visualizar(String[][] criterios) {
        try {
            Criteria criteria = s.createCriteria(this.obj.getClass());
            if (criterios != null) {
                for (String[] criterio : criterios) {
                    criteria.add(Restrictions.eq(criterio[0], ((criterio[1].matches("^[0-9]*$")) ? Integer.valueOf(criterio[1]) : criterio[1])));
                }
            }
            return (T) criteria.uniqueResult();
        } catch (Exception e) {
            s.getTransaction().rollback();
            System.out.println("Erro ao visualizar: " + e.getMessage());
            return null;
        } finally {
            s.close();
        }
    }

    /* Regras de uso
     * Vetor de 3 posições
     * 1 - Tipo de consulta 
     * 2 - Onde consultar na tabela 
     * 3 - Dado a ser procurado
     *
     * Tipos de consultas
     *
     * contain - Verifica com a clausula LIKE [contain, coluna, %valor%]
     * equal - Verifica igualdade [equal, coluna, valor]
     * node - Cria Alias entre tabalas [node, tabela, nomenclatura]
     * order - Ordena os elementos conforme o solicitaddo [order, coluna, asc/desc]
     */
    public List Listar(String[][] criterios) {
        try {
            Criteria criteria = s.createCriteria(this.obj.getClass());
            if (criterios != null) {
                for (String[] criterio : criterios) {
                    if ("contain".equals(criterio[0])) {
                        criteria.add(Restrictions.like(criterio[1], criterio[2]).ignoreCase());
                    } else if ("equal".equals(criterio[0])) {
                        criteria.add(Restrictions.eq(criterio[1], ((criterio[2].matches("^[0-9]*$")) ? Integer.valueOf(criterio[2]) : criterio[2])));
                    } else if ("node".equals(criterio[0])) {
                        criteria.createAlias(criterio[1], criterio[2]);
                    } else if ("order".equals(criterio[0])) {

                    }
                }
            }
            return criteria.list();
        } catch (Exception e) {
            s.getTransaction().rollback();
            System.out.println("Erro ao listar composta: " + e.getMessage());
            return null;
        } finally {
            s.close();
        }
    }

    public int ProximoCodigo() {
        try {
            return (int) s.createCriteria(this.obj.getClass())
                    .setProjection(Projections.max("codigo"))
                    .uniqueResult() + 1;
        } catch (Exception e) {
            s.getTransaction().rollback();
            System.out.println("Erro ao listar tudo: " + e.getMessage());
            return 1;
        } finally {
            s.close();
        }
    }

}
