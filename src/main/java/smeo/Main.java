package smeo;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, MalformedURLException {
        String path = "/Users/yusufsemo/Desktop/mypdf.pdf";

        //create an image
//        String imgPath = "images/birds.jpeg";
//        ImageData imgData = ImageDataFactory.create(imgPath);
//        Image imageBirds = new Image(imgData);
//        imageBirds.scale(0.5f,0.5f);

        //create a table
        float columnWidth[] = {100f,100f,100f,100f,100f};
        Table table = new Table(columnWidth);

        Cell cell_11 = new Cell();
        cell_11.add(new Paragraph("Date"));
        table.addCell(cell_11);

        table.addCell(new Cell().add(new Paragraph("Card")));
        table.addCell(new Cell().add(new Paragraph("Online")));
        table.addCell(new Cell().add(new Paragraph("Cash")));
        table.addCell(new Cell().add(new Paragraph("Total")));

        table.addCell(new Cell().add(new Paragraph("10/4/2022")));
        table.addCell(new Cell().add(new Paragraph("100")));
        table.addCell(new Cell().add(new Paragraph("200")));
        table.addCell(new Cell().add(new Paragraph("300")));
        table.addCell(new Cell().add(new Paragraph("600")));

        table.addCell(new Cell().add(new Paragraph("10/5/2022")));
        table.addCell(new Cell().add(new Paragraph("200")));
        table.addCell(new Cell().add(new Paragraph("250")));
        table.addCell(new Cell().add(new Paragraph("300")));
        table.addCell(new Cell().add(new Paragraph("750")));




        //create a paragraph
        String text = "this is a test text test test test";
        Paragraph testPar = new Paragraph(text);

        PdfWriter pdfWr = new PdfWriter(path);
        PdfDocument pdfDoc = new PdfDocument(pdfWr);
        pdfDoc.addNewPage();

        Document document = new Document(pdfDoc);
        document.add(testPar);
        //document.add(imageBirds);
        document.add(table);

        System.out.println("PDF created");
        document.close();


    }
}