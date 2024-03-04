package smeo;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "/Users/yusufsemo/Desktop/pdf.pdf";
        DayData day = new DayData(2,1,2022,100,100,100);
        System.out.println(day);
        day.toJsonFile();

        DayData day1 = new DayData(2,2,2022,140,300,200);
        day1.toJsonFile();

        DayData day2 = new DayData(3,1,2022,140,140,1003);
        day2.toJsonFile();

        String test = day.getDate();
        String[] result = test.split("/");
        for (String part : result) {
            System.out.println(part+ "  ");
        }

        //create an image
//        String imgPath = "images/birds.jpeg";
//        ImageData imgData = ImageDataFactory.create(imgPath);
//        Image imageBirds = new Image(imgData);
//        imageBirds.scale(0.5f,0.5f);

        //create a table
        float[] columnWidth = {100f,100f,100f,100f,100f,100f,100f};
        Table table = new Table(columnWidth);

        Cell cell_11 = new Cell();
        cell_11.add(new Paragraph("Day"));
        Cell Blank = new Cell().add(new Paragraph(" sdf"))
                .setBorderLeft(Border.NO_BORDER) // Remove the left border
                .setBorderTop(Border.NO_BORDER) // Remove the top border
                .setBorderBottom(Border.NO_BORDER);
        Cell blank = new Cell().add(new Paragraph(" "));

        table.addCell(cell_11);


        table.addCell(new Cell().add(new Paragraph("Date")));
        table.addCell(new Cell().add(new Paragraph("Card")));
        table.addCell(new Cell().add(new Paragraph("Online")));
        table.addCell(new Cell().add(new Paragraph("Cash")));
        table.addCell(new Cell().add(new Paragraph("Total")));
        table.addCell(new Cell().add(new Paragraph("Week")));

        table.addCell(new Cell().add(new Paragraph("Monday")));
        table.addCell(new Cell().add(new Paragraph("10/4/2022")));
        table.addCell(new Cell().add(new Paragraph("100")));
        table.addCell(new Cell().add(new Paragraph("200")));
        table.addCell(new Cell().add(new Paragraph("300")));
        table.addCell(new Cell().add(new Paragraph("500")));
        table.addCell(Blank);

        table.addCell(new Cell().add(new Paragraph("Tuesday")));
        table.addCell(new Cell().add(new Paragraph("10/5/2022")));
        table.addCell(new Cell().add(new Paragraph("200")));
        table.addCell(new Cell().add(new Paragraph("250")));
        table.addCell(new Cell().add(new Paragraph("300")));
        table.addCell(new Cell().add(new Paragraph("750")));
        table.addCell(blank);

        table.addCell(new Cell().add(new Paragraph("Tuesday")));
        table.addCell(new Cell().add(new Paragraph("10/5/2022")));
        table.addCell(new Cell().add(new Paragraph("200")));
        table.addCell(new Cell().add(new Paragraph("250")));
        table.addCell(new Cell().add(new Paragraph("300")));
        table.addCell(new Cell().add(new Paragraph("750")));
        table.addCell(blank);


        table.addCell(new Cell().add(new Paragraph("Tuesday")));
        table.addCell(new Cell().add(new Paragraph("10/5/2022")));
        table.addCell(new Cell().add(new Paragraph("200")));
        table.addCell(new Cell().add(new Paragraph("250")));
        table.addCell(new Cell().add(new Paragraph("300")));
        table.addCell(new Cell().add(new Paragraph("750")));
        table.addCell(new Cell().add(new Paragraph("750")).setBorderTop(Border.NO_BORDER));

        table.addCell(new Cell().add(new Paragraph("Tuesday")));
        table.addCell(new Cell().add(new Paragraph("10/5/2022")));
        table.addCell(new Cell().add(new Paragraph("200")));
        table.addCell(new Cell().add(new Paragraph("250")));
        table.addCell(new Cell().add(new Paragraph("300")));
        table.addCell(new Cell().add(new Paragraph("750")));
        table.addCell(Blank);




//        Cell cell = new Cell(1, 4);
//        cell.add(new Paragraph("Tot"));
//        table.addCell(cell);

        // Add the nested table to the main table





        //create a paragraph
        String text = "";
        Paragraph testPar = new Paragraph(text).setTextAlignment(TextAlignment.CENTER).setFontSize(22);

        PdfWriter pdfWr = new PdfWriter(path);
        PdfDocument pdfDoc = new PdfDocument(pdfWr);
        pdfDoc.addNewPage();

        Document document = new Document(pdfDoc);
        document.add(testPar);
        //document.add(imageBirds);
        document.add(table);

        System.out.println("PDF created");
        document.close();
       // new JTableExamples();

    }
}
