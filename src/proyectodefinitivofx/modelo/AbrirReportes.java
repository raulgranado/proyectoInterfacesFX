package proyectodefinitivofx.modelo;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.collections.ObservableList;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author marlera
 */
public class AbrirReportes extends JFrame {

    private ObservableList<ConversionesTablaFX> conversiones;

    public AbrirReportes(ObservableList<ConversionesTablaFX> conversiones) {
        this.conversiones=conversiones;
    }

    public void abrirReporte() throws JRException {
      
        String fis = "informe/historial.jrxml";
        List historial = new ArrayList();
        
        for(ConversionesTablaFX conv : conversiones){
            ConversionesReporte convRep=new ConversionesReporte(conv.getDesdeMedida().getValue(),
                    conv.getHastaMedida().getValue(), conv.getCantidad1().getValue(), conv.getCantidad2().getValue());
            historial.add(convRep);
        }

        JasperReport jasperReport = JasperCompileManager.compileReport(fis);
        JasperPrint jasper = JasperFillManager.fillReport(jasperReport, null, new JRBeanCollectionDataSource(historial));
        

        JRViewer viewer = new JRViewer(jasper);
        
        JRPdfExporter exporter = new JRPdfExporter();
        exporter.setExporterInput(new SimpleExporterInput(jasper));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput("Historial.pdf"));

        exporter.exportReport();

        viewer.setOpaque(true);
        viewer.setVisible(true);
        add(viewer);
        setSize(700, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
}
