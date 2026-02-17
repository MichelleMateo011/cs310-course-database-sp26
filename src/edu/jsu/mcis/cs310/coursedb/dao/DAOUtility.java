package edu.jsu.mcis.cs310.coursedb.dao;

import java.sql.*;
import com.github.cliftonlabs.json_simple.*;

public class DAOUtility {
    
    public static final int TERMID_SP26 = 1;
    
    public static String getResultSetAsJson(ResultSet rs) {
        
        JsonArray records = new JsonArray();
        
        try {
        
            if (rs != null) {

                ResultSetMetaData rsmd = rs.getMetaData();
                int columnCount = rsmd.getColumnCount();
                
                while (rs.next()) {
                    
                    JsonObject jo = new JsonObject();
                    
                    for (int i = 1; i<= columnCount; i++) {
                        
                        jo.put(rsmd.getColumnName(i), rs.getString(i));
                        
                    }
                    
                    records.add(jo);
                    
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        return Jsoner.serialize(records);
    }
}
                        
                
            
  
    
    

