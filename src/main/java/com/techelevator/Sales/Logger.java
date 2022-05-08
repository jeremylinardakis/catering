package com.techelevator.Sales;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private File auditFile;
    private PrintWriter writer;


    public Logger(String pathName){
        this.auditFile = new File(pathName);
        if(!auditFile.exists()){
            try {
                this.writer = new PrintWriter(this.auditFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            try {
                this.writer = new PrintWriter(new FileWriter(this.auditFile, true));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void write(String logMessage){
        this.writer.println(logMessage);
        this.writer.flush();
    }

    public void close() throws IOException {
        this.writer.close();
    }


}
