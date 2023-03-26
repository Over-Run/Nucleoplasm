package org.overrun.nucleoplasm_api.sql;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.overrun.nucleoplasm_api.Nucleoplasm_api.dir;

public class JSQLInfo {
    public final File serverDir;
    protected JSQLInfo(String dir) {
        serverDir = new File(dir, "sqlite-lib");
        if (!serverDir.exists()) {
            serverDir.mkdirs();
        }
        String url = "jdbc:sqlite:" + serverDir.getName() + File.separator + "example";
        try {
            Connection conn = DriverManager.getConnection(url);
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected JSQLInfo(File dir) {
        serverDir = new File(dir, "sqlite-lib");
        if (!serverDir.exists()) {
            serverDir.mkdirs();
        }
        createSQLInfo("example");

    }

    public JSQLInfo createSQLInfo(String name) {
        File dbPath = new File(serverDir, "example");
        String url = "jdbc:sqlite:" + dbPath.getName().replace(File.separatorChar, '/');
        try {
            Connection conn = DriverManager.getConnection(url);
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static JSQLInfo load() {
        return new JSQLInfo(dir);
    }
}
