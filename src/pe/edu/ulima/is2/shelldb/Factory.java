
package pe.edu.ulima.is2.shelldb;


public class Factory {
    
    public DBadapter obteneBadapter(String tipoDB){
        if(tipoDB.equalsIgnoreCase("derby")){
            return new DerbyAdapter();
        }else if(tipoDB.equalsIgnoreCase("sqlite")){
            return new SqliteAdapter();
        }else{
            return null;
        }
    }
    
}
