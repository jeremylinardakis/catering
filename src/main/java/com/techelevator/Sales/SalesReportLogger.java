package com.techelevator.Sales;

import javax.imageio.IIOException;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//Was not able to use this class

public class SalesReportLogger {
    private File salesReport;
    private PrintWriter salesWriter;

    public SalesReportLogger(String rightNow){
        this.salesReport = new File(rightNow);
            try {
                this.salesWriter = new PrintWriter(this.salesReport);
            } catch (FileNotFoundException e) {
                System.out.println("Can't get this to work");;
            }

    }

    public void write(String logMessage){
        this.salesWriter.println(logMessage);
        this.salesWriter.flush();
    }

    public void close() throws IOException {
        this.salesWriter.close();
    }

}
