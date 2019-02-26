package proyectodefinitivofx.modelo;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
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
      
        String fis = "historial.jrxml";
        List historial = new ArrayList();
        
        int i=1;
        for(ConversionesTablaFX conv : conversiones){
            ConversionesReporte convRep=new ConversionesReporte(conv.getDesdeMedida().getValue(),
                    conv.getHastaMedida().getValue(), conv.getCantidad1().getValue(), conv.getCantidad2().getValue(), conv.getTipoConversion().getValue());
            historial.add(convRep);
            i++;
        }

        JasperReport jasperReport = JasperCompileManager.compileReport(fis);
        JasperPrint jasper = JasperFillManager.fillReport(jasperReport, null, new JRBeanCollectionDataSource(historial));
        

        JRViewer viewer = new JRViewer(jasper);
        

        viewer.setOpaque(true);
        viewer.setVisible(true);
        add(viewer);
        setSize(700, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
}
