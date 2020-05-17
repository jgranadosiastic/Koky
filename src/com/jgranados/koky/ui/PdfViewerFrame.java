package com.jgranados.koky.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;

/**
 * Koky
 *
 * @author jose - 01.10.2019
 * @Title: UserManualViewerFrame
 * @Description: description
 *
 * Changes History
 */
public class PdfViewerFrame extends JFrame {

    public PdfViewerFrame(String filePath) {
        SwingController controller = new SwingController();
        SwingViewBuilder factory = new SwingViewBuilder(controller);
        JPanel viewerComponentPanel = factory.buildViewerPanel();
        setTitle(filePath);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().add(viewerComponentPanel);
        controller.openDocument(filePath);
        pack();
    }
}
