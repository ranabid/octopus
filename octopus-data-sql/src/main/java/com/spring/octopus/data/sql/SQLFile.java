package com.spring.octopus.data.sql;

import java.util.Map;

/**
 * Defines the set of properties files that contain sql statements.
 */
public class SQLFile {
    private final Map<String, String> sqlStatements;

    /**
     * Instantiates the service with the sql statements
     * @param sqlStatements The loaded sql statements
     */
    public SQLFile(final Map<String, String> sqlStatements) {
        this.sqlStatements = sqlStatements;
    }

    /**
     * Return a sql statement for the given key.
     * @param key The key to search.
     * @return The sql statement for the key.
     * @throws IllegalArgumentException if the statement does not exist for the given key.
     */
    public String getSQLStatement(final String key) {
        if(this.sqlStatements.containsKey(key)) {
            return this.sqlStatements.get(key);
        }
        throw new IllegalArgumentException("Unknown SQL statements for key " + key);
    }
}
