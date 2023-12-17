
package oradores;


import java.sql.Statement;
import java.sql.CallableStatement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.sql.ResultSet;


/**
 *
 * @author silvi
 */
public class ClaseOradores {
     int codigo,edadOradores;
   String nombreOradores,apellidoOradores,ciudadOradores;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getEdadOradores() {
        return edadOradores;
    }

    public void setEdadOradores(int edadOradores) {
        this.edadOradores = edadOradores;
    }

    public String getNombreOradores() {
        return nombreOradores;
    }

    public void setNombreOradores(String nombreOradores) {
        this.nombreOradores = nombreOradores;
    }

    public String getApellidoOradores() {
        return apellidoOradores;
    }

    public void setApellidoOradores(String apellidoOradores) {
        this.apellidoOradores = apellidoOradores;
    }

    public String getCiudadOradores() {
        return ciudadOradores;
    }

    public void setCiudadOradores(String ciudadOradores) {
        this.ciudadOradores = ciudadOradores;
    }
    public void InsertarOrador(JTextField paramNombre, JTextField paramApellido,JTextField paramEdad, JTextField paramCiudad){
         
        setNombreOradores(paramNombre.getText());
        setApellidoOradores(paramApellido.getText());
        setEdadOradores(Integer.parseInt(paramEdad.getText()));
        setCiudadOradores(paramCiudad.getText());
        
        Conexion objetoConexion = new Conexion();
        
        String consulta = ("Insert into Oradores (nombre,apellido,edad,ciudad) value(?,?,?,?)");
        
        try{
            
            CallableStatement cs= objetoConexion.getConnection().prepareCall(consulta);
            
            cs.setString(1, getNombreOradores());
            cs.setString(2, getApellidoOradores());
            cs.setInt(3, getEdadOradores());
            cs.setString(4, getCiudadOradores());
            
            cs.execute();
            JOptionPane.showMessageDialog(null,"Datos insertados correctamente.");
            
        }catch(Exception e){
            
             JOptionPane.showMessageDialog(null,"No se pudo insertar los datos del orador, error:" + e.toString());
        }
        
    }
    
    public void MostrarOrador(JTable paramTablaTotalOradores){
        
        Conexion objetoConexion = new Conexion();
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        TableRowSorter<TableModel> ordenarTabla = new TableRowSorter<>(modelo);
        
        paramTablaTotalOradores.setRowSorter(ordenarTabla);
        
        String sql="";
        
        modelo.addColumn("Id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Edad");
        modelo.addColumn("Ciudad");
        
        paramTablaTotalOradores.setModel(modelo);
        
        sql="select*from oradores";
        
        String[] datos = new String [5];
        
        Statement st;
        
        try{
            
            st= objetoConexion.getConnection().createStatement();
            
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
           
             datos[0] = rs.getString(1);
             datos[1] = rs.getString(2);
             datos[2] = rs.getString(3);
             datos[3] = rs.getString(4);
             datos[4] = rs.getString(5);
             
             modelo.addRow(datos);
            }
            
            paramTablaTotalOradores.setModel(modelo);
            
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null,"No se pudo mostrar los registros, error: " +e.toString());
        }
        
    }
    
    public void SeleccionarOrador(JTable paramTablaOradores, JTextField paramId,JTextField paramNombre, JTextField paramApellido, JTextField paramEdad, JTextField paramCiudad){
        
        try{
            int fila = paramTablaOradores.getSelectedRow();
            if(fila>=0){
                paramId.setText(paramTablaOradores.getValueAt(fila, 0).toString());
                 paramNombre.setText(paramTablaOradores.getValueAt(fila, 1).toString());
                  paramApellido.setText(paramTablaOradores.getValueAt(fila, 2).toString());
                   paramEdad.setText(paramTablaOradores.getValueAt(fila, 3).toString());
                    paramCiudad.setText(paramTablaOradores.getValueAt(fila, 4).toString());
            }else{
                JOptionPane.showMessageDialog(null,"Fila no seleccionada.");
            }
        
        }catch (Exception e){
         JOptionPane.showMessageDialog(null,"Error de selección, error: " +e.toString());
        }
    }
    
    public void ModificarOradores(JTextField paramCodigo,JTextField paramNombre,JTextField paramApellido,JTextField paramEdad,JTextField paramCiudad){
        
        setCodigo(Integer.parseInt(paramCodigo.getText()));
        setNombreOradores(paramNombre.getText());
        setApellidoOradores(paramApellido.getText());
        setEdadOradores(Integer.parseInt(paramEdad.getText()));
        setCiudadOradores(paramCiudad.getText());
        
        Conexion objetoConexion = new Conexion();
        
        String consulta = "UPDATE oradores SET oradores.nombre=?,oradores.apellido=?,oradores.edad=?,oradores.ciudad=? WHERE oradores.id=?";
         
        try{
            
             CallableStatement cs= objetoConexion.getConnection().prepareCall(consulta);
             
             cs.setString(1, getNombreOradores());
             cs.setString(2, getApellidoOradores());
             cs.setInt(3, getEdadOradores());
             cs.setString(4, getCiudadOradores());
             cs.setInt(5,getCodigo());
             
             cs.execute();
             
             JOptionPane.showMessageDialog(null,"Modificación exitosa.");
            
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,"No se pudo realizar la modificación, error: " + e.toString());
        
        
        
    }
    }
        
    public void EliminarOrador(JTextField paramCodigo){
        
        setCodigo(Integer.parseInt(paramCodigo.getText()));
        Conexion objetoConexion = new Conexion();
        String consulta = "DELETE FROM oradores WHERE oradores.id=?;";
        
        try{
            
            CallableStatement cs= objetoConexion.getConnection().prepareCall(consulta);
            cs.setInt(1, codigo);
            cs.execute();
            
            JOptionPane.showMessageDialog(null,"Se ha eliminado correctamente.");
            
        
            
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null,"No se pudo eliminar, error: " + e.toString());
}
}
}