package program;


import dominio.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
    public static void main(String[] args) throws Exception {
       /* Pessoa p1 = new Pessoa(null, "Marcello", "marcelo@gmail.com");
        Pessoa p2 = new Pessoa(null, "Gabriel", "gabriel@gmail.com");
        Pessoa p3 = new Pessoa(null, "Alice", "alice@gmail.com");*/

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();

        /** - Salvando no banco de dados
        em.getTransaction().begin();
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        em.getTransaction().commit();
         **/

        //Pesquisando no banco de dados
        Pessoa p = em.find(Pessoa.class, 2);
        System.out.println(p);

        //Apagando no banco de dados
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();

        System.out.println("Pronto");
        em.close();
        emf.close();
    }
}
