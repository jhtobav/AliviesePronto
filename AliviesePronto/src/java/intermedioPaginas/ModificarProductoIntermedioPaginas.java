package intermedioPaginas;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;
import metodosLogicaPaginas.ProductoMetodosLogicaPaginas;
import transporteDatos.ProductoTransporteDatos;

@ManagedBean(name = "modificarProductoIntermedioPaginas")
@SessionScoped
public class ModificarProductoIntermedioPaginas {

    List<ProductoTransporteDatos> productos = null;
    ProductoTransporteDatos producto;

    public ModificarProductoIntermedioPaginas() {
    }

    public String init() {

        productos = new ProductoMetodosLogicaPaginas().listarProductos();

        for (ProductoTransporteDatos productoTransporteDatos : productos) {
            System.out.println(productoTransporteDatos.getId() + " " + productoTransporteDatos.getDescripcion());
        }

        return "modificarProducto.xhtml";

    }

    public String detalleProducto(ProductoTransporteDatos producto) {
        this.producto = producto;
        return "modificarProductoEspecifico.xhtml";
    }

    public List<ProductoTransporteDatos> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoTransporteDatos> productosPublicos) {
        this.productos = productosPublicos;
    }

    public ProductoTransporteDatos getProducto() {
        return producto;
    }

    public void setProducto(ProductoTransporteDatos producto) {
        this.producto = producto;
    }

    public String modificarProducto(){
        System.out.println("Aquii...........");
        System.out.println(producto.getDescripcion());
        System.out.println("Y acaba");
        if(inputFile!=null){
            upload();
        } 

        ProductoMetodosLogicaPaginas productoMetodosLogicaPaginas = new ProductoMetodosLogicaPaginas();
        productoMetodosLogicaPaginas.actualizarProducto(producto);
        return "carrouselBienvenida.xhtml";
    }
    
    
    private Part inputFile;
    private InputStream fileContent;
    private File localFile;

    public void upload() {
        try {
            fileContent = inputFile.getInputStream();
            localFile = new File(File.separator + "Imagenes" + File.separator + inputFile.getSubmittedFileName());
            FileOutputStream out = new FileOutputStream(localFile);
            producto.setImagen("Imagenes/" + inputFile.getSubmittedFileName());
            int read = 0;
            final byte[] bytes = new byte[1024];

            while ((read = fileContent.read(bytes)) != -1) {
                out.write(bytes);
            }
            out.close();

            System.out.println("New file " + "file001.jpg" + " created at ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Part getInputFile() {
        return inputFile;
    }

    public void setInputFile(Part inputFile) {
        this.inputFile = inputFile;
    }

}
