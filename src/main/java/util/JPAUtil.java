package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("java");
	
	public static EntityManager criarEntityManager() {
		return emf.createEntityManager();
	}
	
	public static void close()
	{
		emf.close();
	}
}
