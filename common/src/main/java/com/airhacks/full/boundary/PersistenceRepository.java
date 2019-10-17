package com.airhacks.full.boundary;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by joaosousa on 2019-10-03.
 */
public abstract class PersistenceRepository<T extends PanacheEntityBase>  {

    @Inject
    EntityManager em;

    protected Class<T> type;

    @SuppressWarnings("unchecked")
    protected PersistenceRepository() {
        Class<? extends PersistenceRepository> aClass = getClass();
        while (!(aClass.getGenericSuperclass() instanceof ParameterizedType)) {
            aClass = aClass.getClass().cast(aClass.getSuperclass());
        }

        Type paramType = ParameterizedType.class.cast(aClass.getGenericSuperclass()).getActualTypeArguments()[0];
        try {
            this.type = Class.forName(paramType.getTypeName()).getClass().cast(paramType);
        } catch (ClassNotFoundException e) {

        }
    }

    protected Class<T> getType() {
        return type;
    }

    protected EntityManager getManager() {
        return em;
    }

    protected abstract List<String> getSortableFields();

    protected abstract List<String> getSearchableFields();


}
