package org.homework.dev_module8;

public class SQLQuery {
    public static final String CREATE_CLIENT = "INSERT INTO client (name) VALUES (?)";
    public static final String GET_LAST_ID = "SELECT MAX(id) FROM client";
    public static final String GET_NAME_BY_ID = "SELECT NAME FROM CLIENT WHERE ID = ?";
    public static final String SET_NAME_BY_ID = "UPDATE client SET NAME = ? WHERE ID = ?";
    public static final String DELETE_BY_ID = "DELETE FROM client WHERE ID = ?";
    public static final String GET_ALL = "SELECT * FROM client";
}
