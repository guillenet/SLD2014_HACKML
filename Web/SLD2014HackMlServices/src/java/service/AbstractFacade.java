/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.AbstractMap;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author Hernan
 */
public abstract class AbstractFacade<T> {
    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SLD2014HackMlServicesPU");
        return emf.createEntityManager(); 
    }

    public void create(T entity) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();   
    }
    
    public T createReturn(T entity) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();    
        em.refresh(entity);
        
        return entity;
        //getEntityManager().persist(entity);
    }

    public void edit(T entity) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }

    public void remove(T entity) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(entity));
        em.getTransaction().commit();
    }
    
    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    /*public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }*/

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
    public List<T> findRange(int[] range) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        javax.persistence.criteria.CriteriaQuery cq = cb.createQuery();
        Root<T> item = cq.from(entityClass);
        try{
            item.get("eliminado");
            cq = cq.where(cb.or(cb.isNull(item.get("eliminado")),cb.notEqual(item.get("eliminado"), 1)));
        }catch(Exception e){
            
        }
        cq.select(item);
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }
    
    public List<T> findRangeOrderByDesc(int[] range) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        javax.persistence.criteria.CriteriaQuery cq = cb.createQuery();
        Root<T> item = cq.from(entityClass);
        cq.where(cb.or(cb.isNull(item.get("eliminado")),cb.notEqual(item.get("eliminado"), 1))).select(item);
        cq.orderBy(cb.asc(item.get("descripcion")));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }
    
    public T findBy(String key, String value ) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        javax.persistence.criteria.CriteriaQuery cq = cb.createQuery();
        Root<T> item = cq.from(entityClass);
        cq.where(cb.equal(item.get(key), value)).select(item);
        javax.persistence.Query q = getEntityManager().createQuery(cq);

        return (T) q.getSingleResult();
    }
    
    public List<T> findByList(String key, String value ) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        javax.persistence.criteria.CriteriaQuery cq = cb.createQuery();
        Root<T> item = cq.from(entityClass);
        //cq.where(cb.equal(item.get(key), "%" + value + "%")).select(item);
        cq.where(cb.like(cb.upper(item.<String>get(key)), "%" + value.toUpperCase() + "%")).select(item);
        javax.persistence.Query q = getEntityManager().createQuery(cq);

        return q.getResultList();
    }
    
    public List<T> findByListMap(List<AbstractMap.SimpleEntry<String,String>> listParameters) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        javax.persistence.criteria.CriteriaQuery cq = cb.createQuery(entityClass);
        Root<T> item = cq.from(entityClass);
        //cq.where(cb.like(cb.upper(item.<String>get(key)), "%" + value.toUpperCase() + "%")).select(item);
        
        //param = new AbstractMap.SimpleEntry<String, String>("","");
        
        Predicate[] aPred = new Predicate[listParameters.size()];
        int iParam = 0;
        Predicate p;
        for(AbstractMap.SimpleEntry<String,String> param : listParameters){
            p = cb.like(cb.upper(item.<String>get(param.getKey())), "%" + param.getValue().toUpperCase() + "%");
            //aPred[iParam] = cb.or(cb.isNull(item.<String>get(param.getKey())),p);
            aPred[iParam] = p;
            iParam++;
        }
        cq.where(cb.and(aPred)).select(item);
      
        //Predicate p = cb.like(cb.upper(item.<String>get("")), "%" + "a".toUpperCase() + "%");
        
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return q.getResultList();
    }
    
    public List<T> findByListMapRange(List<AbstractMap.SimpleEntry<String,String>> listParameters,int[] range ){
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        javax.persistence.criteria.CriteriaQuery cq = cb.createQuery(entityClass);
        Root<T> item = cq.from(entityClass);
        //cq.where(cb.like(cb.upper(item.<String>get(key)), "%" + value.toUpperCase() + "%")).select(item);
        
        //param = new AbstractMap.SimpleEntry<String, String>("","");
        
        Predicate[] aPred = new Predicate[listParameters.size()];
        int iParam = 0;
        Predicate p;
        for(AbstractMap.SimpleEntry<String,String> param : listParameters){
            p = cb.like(cb.upper(item.<String>get(param.getKey())), "%" + param.getValue().toUpperCase() + "%");
            //aPred[iParam] = cb.or(cb.isNull(item.<String>get(param.getKey())),p);
            aPred[iParam] = p;
            iParam++;
        }
        cq.where(cb.and(aPred)).select(item);
      
        //Predicate p = cb.like(cb.upper(item.<String>get("")), "%" + "a".toUpperCase() + "%");
        
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        
        return q.getResultList();
    }
    
    
    //------------DELETE
    /*public void deleteArticulo(Articulo e){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        e.setEliminado(true);
        em.merge(e);
        em.getTransaction().commit();
    }*/
}
