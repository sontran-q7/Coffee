package com.app.coffee.menu;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InvoicePDF {
    private String staffName;
    private Object[][] products;
    private double totalAmount;
    private String tableNumber;
    private String note;
    private float guestsBroughtAmount;
    private float changeAmount;
    
    public InvoicePDF(String staffName, Object[][] products, double totalAmount, String tableNumber, String note, float guestsBroughtAmount, float changeAmount) {
        this.staffName = staffName;
        this.products = products;
        this.totalAmount = totalAmount;
        this.tableNumber = tableNumber;
        this.note = note;
        this.guestsBroughtAmount = guestsBroughtAmount;
        this.changeAmount = changeAmount;
    }

    public void generateInvoicePDF() throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("invoice.pdf"));
        document.open();

        String rootPath = Paths.get("").toAbsolutePath().toString();

        FontFactory.register(rootPath + "/src/main/java/com/app/coffee/fonts/Arial.ttf", "Arial Unicode");
        Font font = FontFactory.getFont("Arial Unicode", BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 12);
        Font titleFont = FontFactory.getFont("Arial Unicode", BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 24, Font.BOLD);
        
        Paragraph title = new Paragraph("Bill", titleFont);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);

        Paragraph spacingBeforeTitle = new Paragraph(30f, " ");
        document.add(spacingBeforeTitle);
        
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        String dateString = dateFormat.format(currentDate);
        String timeString = timeFormat.format(currentDate);

        PdfPTable headerTable = new PdfPTable(2);
        headerTable.setWidthPercentage(100);
        headerTable.setWidths(new float[]{1, 1});

        PdfPCell leftCell;
        PdfPCell rightCell;

        leftCell = new PdfPCell(new Phrase("Order: " + staffName, font));
        leftCell.setBorder(Rectangle.NO_BORDER);
        leftCell.setHorizontalAlignment(Element.ALIGN_LEFT);
        headerTable.addCell(leftCell);

        rightCell = new PdfPCell(new Phrase("Date: " + dateString, font));
        rightCell.setBorder(Rectangle.NO_BORDER);
        rightCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        headerTable.addCell(rightCell);

        leftCell = new PdfPCell(new Phrase("Number of tables: " + tableNumber, font));
        leftCell.setBorder(Rectangle.NO_BORDER);
        leftCell.setHorizontalAlignment(Element.ALIGN_LEFT);
        headerTable.addCell(leftCell);

        rightCell = new PdfPCell(new Phrase("Hours: " + timeString, font));
        rightCell.setBorder(Rectangle.NO_BORDER);
        rightCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        headerTable.addCell(rightCell);

        document.add(headerTable);

        Paragraph spacingBeforeTable = new Paragraph(10f, " ");
        document.add(spacingBeforeTable);

        PdfPTable table = new PdfPTable(8);  
        table.setWidthPercentage(100);
        table.setWidths(new float[]{1, 2, 1, 1, 1, 1, 2, 1});  

        PdfPCell cell = new PdfPCell(new Phrase("No", font));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Product", font));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Size", font));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Quantity", font));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Sugar", font));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Price", font));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Note", font));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Total", font));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        for (Object[] product : products) {
            for (int i = 0; i < product.length; i++) {
                cell = new PdfPCell(new Phrase(product[i].toString(), font));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
            }
            int quantity = Integer.parseInt(product[3].toString());
            double price = Double.parseDouble(product[5].toString());
            double total = quantity * price;

            cell = new PdfPCell(new Phrase(String.valueOf(total), font));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
        }

        document.add(table);

        Paragraph spacingAfterTable = new Paragraph(10f, " ");
        document.add(spacingAfterTable);

        Paragraph noteAmountParagraph = new Paragraph("Note: " + note, font);
        noteAmountParagraph.setAlignment(Element.ALIGN_LEFT);
        document.add(noteAmountParagraph);
        
        Paragraph totalAmountParagraph = new Paragraph("Total amount: " + totalAmount, font);
        totalAmountParagraph.setAlignment(Element.ALIGN_LEFT);
        document.add(totalAmountParagraph);

        Paragraph guestsBroughtAmountParagraph = new Paragraph("Guests brought: " + guestsBroughtAmount, font);
        guestsBroughtAmountParagraph.setAlignment(Element.ALIGN_LEFT);
        document.add(guestsBroughtAmountParagraph);
        
        Paragraph changeAmountParagraph = new Paragraph("Change: " + changeAmount, font);
        changeAmountParagraph.setAlignment(Element.ALIGN_LEFT);
        document.add(changeAmountParagraph);
            
        document.add(Chunk.NEWLINE);

        Paragraph thankYouParagraph = new Paragraph("Thank you. See you again.", font);
        thankYouParagraph.setAlignment(Element.ALIGN_CENTER);
        document.add(thankYouParagraph);

        document.close();
    }
}
