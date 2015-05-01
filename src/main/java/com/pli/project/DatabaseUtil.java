package com.pli.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by lipeng on 2015/4/24.
 */
public class DatabaseUtil {

    public JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void millionInsert(){
        int id = 0;
        for(int i = 0; i < 100; i++){
            StringBuffer sql = new StringBuffer("insert into stable (id2, message) values");
            for(int j = 1; j < 10000; j++) {
                int random26 = (int) (Math.random() * 26);
                char c1 = (char) ((int) 'a' + random26);
                random26 = (int) (Math.random() * 26);
                char c2 = (char) ((int) 'a' + random26);
                String message = String.valueOf(c1).toUpperCase() + String.valueOf(c2).toUpperCase();
                sql.append("(" + (id++) + ",'" + message + "'),");
            }
            sql.deleteCharAt(sql.length() - 1).append(";");
            jdbcTemplate.execute(sql.toString());
            sql = new StringBuffer();
        }
    }

    public void millionInsertIndex(){
        int id = 0;
        for(int i = 0; i < 100000000; i++){
            int id1 = (int) (Math.random() * 100000000);
            int id2 = (int) (Math.random() * 100000000);
            int id3 = (int) (Math.random() * 100000000);
            int id4 = (int) (Math.random() * 100000000);
            int id5 = (int) (Math.random() * 100000000);
            int id6 = (int) (Math.random() * 100000000);
            int id7 = (int) (Math.random() * 100000000);
            int id8 = (int) (Math.random() * 100000000);
            int id9 = (int) (Math.random() * 100000000);
            int id10 = (int) (Math.random() * 100000000);
            StringBuffer sql = new StringBuffer("insert into itable4 (id1, id2, id3, id4, id5, id6, id7, id8, id9, id10) values");
            sql.append("(" + id1
                    + "," + id2
                    + "," + id3
                    + "," + id4
                    + "," + id5
                    + "," + id6
                    + "," + id7
                    + "," + id8
                    + "," + id9
                    + "," + id10
                    + "),");
            sql.deleteCharAt(sql.length() - 1).append(";");
            jdbcTemplate.execute(sql.toString());
            sql = new StringBuffer();
        }
    }

    public static String getRandomCode(){
        int random26 = (int) (Math.random() * 26);
        char c1 = (char) ((int) 'a' + random26);
        random26 = (int) (Math.random() * 26);
        char c2 = (char) ((int) 'a' + random26);
        return String.valueOf(c1).toUpperCase() + String.valueOf(c2).toUpperCase();
    }


}


