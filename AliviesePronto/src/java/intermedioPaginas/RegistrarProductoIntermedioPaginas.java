package intermedioPaginas;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;
import metodosLogicaPaginas.ProductoMetodosLogicaPaginas;
import transporteDatos.ProductoTransporteDatos;

@ManagedBean(name = "registrarProductoIntermedioPaginas")
@SessionScoped
public class RegistrarProductoIntermedioPaginas {

    private String nombre;
    private String descripcion;
    private String marca;
    private String imagen;
    private String presentacion;
    private Long precioUnitarioCompra;
    private Long precioUnitarioVenta;
    private Integer cantidadInventario;
    private Integer cantidadMinimaInventario;
    private String tipo;

    public RegistrarProductoIntermedioPaginas() {
    }

    @PostConstruct
    public void init() {

        nombre = null;
        descripcion = null;
        marca = null;
        imagen = null;
        presentacion = null;
        precioUnitarioCompra = null;
        precioUnitarioVenta = null;
        cantidadInventario = null;
        cantidadMinimaInventario = null;
        tipo = null;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public Long getPrecioUnitarioCompra() {
        return precioUnitarioCompra;
    }

    public void setPrecioUnitarioCompra(Long precioUnitarioCompra) {
        this.precioUnitarioCompra = precioUnitarioCompra;
    }

    public Long getPrecioUnitarioVenta() {
        return precioUnitarioVenta;
    }

    public void setPrecioUnitarioVenta(Long precioUnitarioVenta) {
        this.precioUnitarioVenta = precioUnitarioVenta;
    }

    public Integer getCantidadInventario() {
        return cantidadInventario;
    }

    public void setCantidadInventario(Integer cantidadInventario) {
        this.cantidadInventario = cantidadInventario;
    }

    public Integer getCantidadMinimaInventario() {
        return cantidadMinimaInventario;
    }

    public void setCantidadMinimaInventario(Integer cantidadMinimaInventario) {
        this.cantidadMinimaInventario = cantidadMinimaInventario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String registrarProducto() {

        /*
        nombre = "productoNombre";
        descripcion = "productoDescripcion";
        marca = "productoMarca";
        imagen = "productoImagen";
        presentacion = "productoPresentacion";
        precioUnitarioCompra = 1234l;
        precioUnitarioVenta = 5678l;
        cantidadInventario = 9012;
        cantidadMinimaInventario = 3456;
        tipo = "productoTipo";
         */
        
        upload();


        if (nombre != null && descripcion != null && marca != null && imagen != null
                && presentacion != null && precioUnitarioCompra != null && precioUnitarioVenta != null
                && cantidadInventario != null && cantidadMinimaInventario != null && tipo != null) {

            ProductoTransporteDatos productoTransporteDatos = new ProductoTransporteDatos();
            productoTransporteDatos.setNombre(nombre);
            productoTransporteDatos.setDescripcion(descripcion);
            productoTransporteDatos.setMarca(marca);
            productoTransporteDatos.setImagen(imagen);
            productoTransporteDatos.setPresentacion(presentacion);
            productoTransporteDatos.setPrecioUnitarioCompra(precioUnitarioCompra);
            productoTransporteDatos.setPrecioUnitarioVenta(precioUnitarioVenta);
            productoTransporteDatos.setCantidadInventario(cantidadInventario);
            productoTransporteDatos.setCantidadMinimaInventario(cantidadMinimaInventario);
            productoTransporteDatos.setTipo(tipo);

            ProductoMetodosLogicaPaginas registrarProductoMetodosLogicaPaginas = new ProductoMetodosLogicaPaginas();
            
            if (registrarProductoMetodosLogicaPaginas
                    .RegistrarProducto(productoTransporteDatos)) {

                return "pagina exito";

            } else {

                return "pagina fracaso";

            }

        } else {

            return "Por favor ingrese los datos completos";

        }

    }

    private Part inputFile;
    private InputStream fileContent;
    private File localFile;

    public void upload() {
        try {
            fileContent = inputFile.getInputStream();
            localFile = new File(File.separator + "Imagenes" + File.separator + inputFile.getSubmittedFileName());
            FileOutputStream out = new FileOutputStream(localFile);
            imagen = localFile.getAbsolutePath();
            int read = 0;
            final byte[] bytes = new byte[1024];

            while ((read = fileContent.read(bytes)) != -1) {
                out.write(bytes);
            }
            out.close();
            
            System.out.println("New file " + "file001.jpg" + " created at ");
        } catch (IOException e) {
            System.out.println("");
        }
    }

    public Part getInputFile() {
        return inputFile;
    }

    public void setInputFile(Part inputFile) {
        this.inputFile = inputFile;
    }


}
