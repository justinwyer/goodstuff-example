package com.lifeasageek.goodstuffexample.cdi;

import java.util.Map;
import javax.inject.Inject;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.metamodel.Metamodel;

/**
 *
 * @author Justin Wyer <justin@lifeasageek.com>
 */
public class EntityManagerWrapper implements EntityManager
{
   @Inject
   private EntityManagerProducer emp;

   @Override
   public void persist(Object entity)
   {
      emp.get().persist(entity);
   }

   @Override
   public <T> T merge(T entity)
   {
      return emp.get().merge(entity);
   }

   @Override
   public void remove(Object entity)
   {
      emp.get().remove(entity);
   }

   @Override
   public <T> T find(Class<T> entityClass, Object primaryKey)
   {
      return emp.get().find(entityClass, primaryKey);
   }

   @Override
   public <T> T find(Class<T> entityClass, Object primaryKey, Map<String, Object> properties)
   {
      return emp.get().find(entityClass, primaryKey, properties);
   }

   @Override
   public <T> T find(Class<T> entityClass, Object primaryKey, LockModeType lockMode)
   {
      return emp.get().find(entityClass, primaryKey, lockMode);
   }

   @Override
   public <T> T find(Class<T> entityClass, Object primaryKey, LockModeType lockMode, Map<String, Object> properties)
   {
      return emp.get().find(entityClass, primaryKey, lockMode, properties);
   }

   @Override
   public <T> T getReference(Class<T> entityClass, Object primaryKey)
   {
      return emp.get().getReference(entityClass, primaryKey);
   }

   @Override
   public void flush()
   {
      emp.get().flush();
   }

   @Override
   public void setFlushMode(FlushModeType flushMode)
   {
      emp.get().setFlushMode(flushMode);
   }

   @Override
   public FlushModeType getFlushMode()
   {
      return emp.get().getFlushMode();
   }

   @Override
   public void lock(Object entity, LockModeType lockMode)
   {
      emp.get().lock(entity, lockMode);
   }

   @Override
   public void lock(Object entity, LockModeType lockMode, Map<String, Object> properties)
   {
      emp.get().lock(entity, lockMode, properties);
   }

   @Override
   public void refresh(Object entity)
   {
      emp.get().refresh(entity);
   }

   @Override
   public void refresh(Object entity, Map<String, Object> properties)
   {
      emp.get().refresh(entity, properties);
   }

   @Override
   public void refresh(Object entity, LockModeType lockMode)
   {
      emp.get().refresh(entity, lockMode);
   }

   @Override
   public void refresh(Object entity, LockModeType lockMode, Map<String, Object> properties)
   {
      emp.get().refresh(entity, lockMode, properties);
   }

   @Override
   public void clear()
   {
      emp.get().clear();
   }

   @Override
   public void detach(Object entity)
   {
      emp.get().detach(entity);
   }

   @Override
   public boolean contains(Object entity)
   {
      return emp.get().contains(entity);
   }

   @Override
   public LockModeType getLockMode(Object entity)
   {
      return emp.get().getLockMode(entity);
   }

   @Override
   public void setProperty(String propertyName, Object value)
   {
      emp.get().setProperty(propertyName, value);
   }

   @Override
   public Map<String, Object> getProperties()
   {
      return emp.get().getProperties();
   }

   @Override
   public Query createQuery(String qlString)
   {
      return emp.get().createQuery(qlString);
   }

   @Override
   public <T> TypedQuery<T> createQuery(CriteriaQuery<T> criteriaQuery)
   {
      return emp.get().createQuery(criteriaQuery);
   }

   @Override
   public <T> TypedQuery<T> createQuery(String qlString, Class<T> resultClass)
   {
      return emp.get().createQuery(qlString, resultClass);
   }

   @Override
   public Query createNamedQuery(String name)
   {
      return emp.get().createNamedQuery(name);
   }

   @Override
   public <T> TypedQuery<T> createNamedQuery(String name, Class<T> resultClass)
   {
      return emp.get().createNamedQuery(name, resultClass);
   }

   @Override
   public Query createNativeQuery(String sqlString)
   {
      return emp.get().createNativeQuery(sqlString);
   }

   @Override
   public Query createNativeQuery(String sqlString, Class resultClass)
   {
      return emp.get().createNativeQuery(sqlString, resultClass);
   }

   @Override
   public Query createNativeQuery(String sqlString, String resultSetMapping)
   {
      return emp.get().createNativeQuery(sqlString, resultSetMapping);
   }

   @Override
   public void joinTransaction()
   {
      emp.get().joinTransaction();
   }

   @Override
   public <T> T unwrap(Class<T> cls)
   {
      return emp.get().unwrap(cls);
   }

   @Override
   public Object getDelegate()
   {
      return emp.get().getDelegate();
   }

   @Override
   public void close()
   {
      emp.get().close();
   }

   @Override
   public boolean isOpen()
   {
      return emp.get().isOpen();
   }

   @Override
   public EntityTransaction getTransaction()
   {
      return emp.get().getTransaction();
   }

   @Override
   public EntityManagerFactory getEntityManagerFactory()
   {
      return emp.get().getEntityManagerFactory();
   }

   @Override
   public CriteriaBuilder getCriteriaBuilder()
   {
      return emp.get().getCriteriaBuilder();
   }

   @Override
   public Metamodel getMetamodel()
   {
      return emp.get().getMetamodel();
   }
}
