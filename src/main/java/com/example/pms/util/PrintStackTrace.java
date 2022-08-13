package com.example.pms.util;

import java.io.PrintWriter;
import java.io.StringWriter;

public class PrintStackTrace {

    public static String printStackTraceString(Exception e) {
        StringWriter errors = new StringWriter();
        e.printStackTrace(new PrintWriter(errors));
        return "\n " + errors;
    }

}
