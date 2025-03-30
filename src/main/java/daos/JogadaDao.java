package daos;

import entidades.Jogada;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class JogadaDao {

    public static void salvar(Jogada jogada) {
        EntityManager em = JPAUtil.criarEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(jogada);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Erro ao salvar jogada: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }
    public static void atualizar(Jogada jogada) {
        EntityManager em = JPAUtil.criarEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(jogada);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Erro ao atualizar jogada: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }

    public static void deletar(Jogada jogada) {
        EntityManager em = JPAUtil.criarEntityManager();
        try {
            em.getTransaction().begin();
            Jogada jogadaEncontrada = em.find(Jogada.class, jogada.getId());
            em.remove(jogadaEncontrada);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Erro ao excluir jogada: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }

    @SuppressWarnings("unchecked")
	public static List<Jogada> listarTodas() {
        EntityManager em = JPAUtil.criarEntityManager();
        try {
        	// sintaxe jpa
            Query query = em.createQuery("SELECT j FROM Jogada j", Jogada.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar jogadas: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }

    public static Jogada encontrar(Integer id) {
        EntityManager em = JPAUtil.criarEntityManager();
        try {
            return em.find(Jogada.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar jogada por ID: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }
}