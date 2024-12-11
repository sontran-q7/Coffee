package com.app.coffee.menu;

import java.awt.*;
import java.awt.print.*;

public class PrintableInvoice implements Printable {
    private String invoiceText;

    public PrintableInvoice(String invoiceText) {
        this.invoiceText = invoiceText;
    }

    @Override
    public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
        if (page > 0) {
            return NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());

        g.setFont(new Font("Serif", Font.PLAIN, 10));
        g.drawString(invoiceText, 100, 100);

        return PAGE_EXISTS;
    }
}