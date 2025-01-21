package data;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Nacho
 */
public class App extends Thread{

    private final String rutaArchivoBD;
    private final int BancoDelQueHacerLaQuery=1;
    
    public App(String name, String rutaArchivo) {
        super(name);
        rutaArchivoBD = rutaArchivo;
    }
    
    public static void main(String[] args) {
        App a=new App("Cotizacion bancos con UCanAccess","//res//Valores.mdb");
        a.start();
    }

    @Override
    public void run() {
        
        //si la BD no existe cierro el programa
        if(!GestorBD.existeLaBD(rutaArchivoBD))
            return;
        
        try {
            //Me conecto a la base de datos
            Connection con = GestorBD.establecerConexionAccess(rutaArchivoBD);  
            //hago la consulta de los bancos
            String consulta="Select * from Valores";
            ResultSet resConsulta = GestorBD.hacerConsulta(con, consulta);
            List<String> bancos = GestorBD.sacarValoresDeColumna(resConsulta,2);
            
            //pinto los bancos
            System.out.println("Estos son los bancos disponibles\n________________________");
            System.out.println(bancos);
            
            //hago la consulta de las cotizaciones
            String consultaCotizaciones=
                    "SELECT Cotizaciones.valor\n" +
                    "FROM Cotizaciones\n" +
                    "WHERE (((Cotizaciones.id)="+BancoDelQueHacerLaQuery+"));";
            ResultSet resConsultaCotizaciones = GestorBD.hacerConsulta(con, consultaCotizaciones);
            
            //pinto las cotizaciones
            System.out.println("\nEstos son los valores de las cotizaciones del banco con id "+BancoDelQueHacerLaQuery);
            System.out.println("____________________________________________________________");
            while(resConsultaCotizaciones.next()){
                System.out.println(resConsultaCotizaciones.getString(1));
            }

            
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al usar el driver de UCanAccess:\n"+ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error con la Base de datos:\n"+ex.getMessage());
        }
        
    }
}
