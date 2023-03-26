package org.overrun.nucleoplasm_api.sql;

import org.overrun.nucleoplasm_api.Nucleoplasm_api;
import org.sqlite.JDBC;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SQLiteInfo {
    public final  File serverDir;
    public final ConcurrentHashMap<String, Connection> sqlMap = new ConcurrentHashMap<>();

    public SQLiteInfo(File dir) {
        serverDir = new File(dir, "sqlite-lib");
        if (!serverDir.exists()) {
            serverDir.mkdirs();
        }
        //初始阶段会生成一个example的数据库
        File example = new File(serverDir, "example.db");
        if (!example.exists()) try {example.createNewFile();loadSQLite(example);} catch (IOException ignored) {}
        var files = serverDir.listFiles();
        //读取db文件存储到sqlMap
        if (files != null) {
            for (File file : files) {
                loadSQLite(file);
            }
        }
    }
    //创建一个新的数据库
    public void createSQLite(String name) {
        File f = new File(serverDir, name);
        if (!f.exists()) {
            try {
                f.createNewFile();
                loadSQLite(f);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Nucleoplasm_api.LOGGER.info("Database " + name + " already exists!");
        }
    }

    private void loadSQLite(File file) {
        Connection c;
        try {
            Class.forName(JDBC.class.getName());
            c = DriverManager.getConnection(JDBC.PREFIX + file.getName());
            String[] split = file.getName().split("\\\\");
            var string = split[split.length - 1];
            sqlMap.put(string, c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() throws SQLException {
        for (var entry : sqlMap.entrySet()) {
            entry.getValue().close();
        }
    }

    public class TableInfo {
        private Connection c;
        public TableInfo(String name) {
            if (sqlMap.containsKey(name)) {
                c = sqlMap.get(name);
            } else {
                c = sqlMap.get("example");
            }
        }

        public TableInfo get(String name) {
            if (sqlMap.containsKey(name)) {
                c = sqlMap.get(name);
            }
            return this;
        }

        public TableInfo createTable(String sqlCommand) {
            try {
                Statement statement = c.createStatement();
                statement.executeUpdate(sqlCommand);
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return this;
        }

    }
}
