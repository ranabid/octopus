package com.spring.octopus.data.sql.properties;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataSQLProperties {
    private Map<String, List<String>> sqlFiles = new HashMap<String, List<String>>();
    private Map<String, dataSourceProperties> connections = new HashMap<String, dataSourceProperties>();

    public static class dataSourceProperties {
        private String url = "";
        private String user = "";
        private String password = "";
        private int maxPoolSize = 5;

        /**
         * Additional driver specific properties that can be set as-is to the configuration
         */
        private Map<String, String> dataSourceProperties = new HashMap<String, String>();

        /**
         * Additional connection pool specific properties that can be set as-is to the configuration
         */
        private Map<String, String> poolProperties = new HashMap<String, String>();

        public String getUrl() {
            return url;
        }

        public void setUrl(final String url) {
            this.url = url;
        }

        public String getUser() {
            return user;
        }

        public void setUser(final String user) {
            this.user = user;
        }

        /*public String getPassword() {
            return password;
        }*/

        public void setPassword(final String password) {
            this.password = password;
        }

        public int getMaxPoolSize() {
            return maxPoolSize;
        }

        public void setMaxPoolSize(final int maxPoolSize) {
            this.maxPoolSize = maxPoolSize;
        }

        public Map<String, String> getDataSourceProperties() {
            return dataSourceProperties;
        }

        public void setDataSourceProperties(final Map<String, String> dataSourceProperties) {
            this.dataSourceProperties = dataSourceProperties;
        }

        public Map<String, String> getPoolProperties() {
            return poolProperties;
        }

        public void setPoolProperties(final Map<String, String> poolProperties) {
            this.poolProperties = poolProperties;
        }
    }
}
