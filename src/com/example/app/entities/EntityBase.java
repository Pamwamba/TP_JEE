package com.example.app.entities;

public abstract class EntityBase {

    public static Integer sequence = 0;

    protected Integer id;
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

}
