package pe.edu.ulima.is2.shelldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DerbyAdapter implements DBadapter {

    private Connection nConn;

    @Override
    public void conectarse(String nombreBD) throws SQLException, ClassNotFoundException {
        nConn = DriverManager.getConnection("jdbc:derby:" + nombreBD
                + ";create=true;user=is2;password=123");

    }

    @Override
    public String ejecutar(String sq1) throws SQLException {
        
        String resp = "";

        Statement statement = nConn.createStatement();
        if (statement.execute(sq1)) {
            // Entrega un resulset
            ResultSet rs = statement.getResultSet();
            while (rs.next()) {
                int numColumns = rs.getMetaData().getColumnCount();
                //String[] valoresColumna = new String[numColumns];
                for (int i = 0; i < numColumns; i++) {
                    String nombreColumna
                            = rs.getMetaData().getColumnName(i + 1);
                    int tipoColumna
                            = rs.getMetaData().getColumnType(i + 1);

                    String valorColumna = "";
                    if (tipoColumna == java.sql.Types.VARCHAR) {
                        valorColumna = rs.getString(nombreColumna);
                    } else if (tipoColumna == java.sql.Types.INTEGER) {
                        valorColumna
                                = String.valueOf(rs.getInt(nombreColumna));
                    }
                    //valoresColumna[i] = valorColumna;
                    System.out.print(valorColumna + "\t\t");
                }
                resp += "\n";
            }
        } else {
            resp += sq1 + "\n";

            resp += "Se ejecutó la sentencia correctamente\n";
        }
        
        return resp;

    }


}
