package com.example.app.controllers;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import com.example.app.entities.EntityBase;
import com.example.app.entities.User;

public abstract class CrudController<ID, TYPE extends EntityBase> {

    protected Map<ID, TYPE> store;

    /**
     * Retrieve the collection resource of User in the response body.
     * @return Collection of User.
     */
    protected Response getAll() {
        final Collection<TYPE> result = this.store.values();

        return Response.ok(result).build();
    }

    /**
     * Retrieve a User resource in the response body.
     * @param id Identifier of User.
     * @return User data.
     */
    protected Response getOne(final ID id) {
        final TYPE result = this.store.get(id);

        return Response.ok(result).build();
    }

    /**
     * Create a User. The URI of the created member resource is automatically assigned and returned in the response
     * Location header field.
     * @param id Identifier of User.
     * @param user User data to store.
     * @return User data updated.
     */
    @SuppressWarnings("unchecked")
    protected Response create(final ID id, final TYPE object) {

        if (object.getId() == 0) {
            object.setId(++TYPE.sequence);
        }

        this.store.put((ID)object.getId(), object);

        return Response.ok(object).build();
    }

    /**
     * Create a collection of Users. The URI of the created member resource is automatically assigned and returned in the response
     * Location header field.
     * @param usersParam Collection of Users
     * @return Users data updated.
     */
    @SuppressWarnings("unchecked")
    protected Response create(final List<TYPE> objects) {

        for (TYPE object : objects) {
            if (object.getId() == 0) {
                object.setId(++User.sequence);
            }

            this.store.put((ID)object.getId(), object);
        }

        return Response.ok(objects).build();
    }

    /**
     * Update User or create it if not exist.
     * @param id Identifier of User.
     * @param user User data.
     * @return User data updated.
     */
    protected Response update(final ID id, final TYPE object) {
        this.store.replace(id, object);

        return Response.ok(object).build();
    }

    /**
     * Delete all the representations of User.
     * @param id Identifier of User.
     * @return nothing.
     */
    protected Response delete(final ID id) {
        this.store.remove(id);

        return Response.ok().build();
    }
}
