package com.example.pms.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class OidGenerator {
    // use base 36 (i.e., 0123456789abcdefghijklmnopqrstuvwyz) for encoding
    private static final int ENCODING_BASE = 36;

    private static final int TIME_LENGTH = 8;

    private static final long IP_RESET = getPower(ENCODING_BASE, 2);

    private static final long COUNTER_RESET = getPower(ENCODING_BASE, 3);

    private static String ip = getIP();
    private static String hexTime = getHexTime();
    private static long counter = 0;

    /* calculate p'th power of n */
    private static long getPower(int n, int p) {
        long result = 1;
        for (int i = 0; i < p; i++) {
            result *= n;
        }
        return result;
    }

    /* returns zero padded,
     * IP_LENGTH length,
     * ENCODING_BASE long encoded
     * ip address */
    private static String getIP() {
        long ip = 0;
        try {
            byte[] b = InetAddress.getLocalHost().getAddress();
            ip = ((b[3] & 0xFF) << 0)
                    & 0xFFFFFFFFL;
			/* ip = ((((b[0] & 0xFF) << 24)
			+ ((b[1] & 0xFF) << 16)
			+ ((b[2] & 0xFF) << 8)
			+ ((b[3] & 0xFF) << 0)
			& 0xFFFFFFFFL));
			*/
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return Long.toString(ip + IP_RESET, ENCODING_BASE).substring(1);
    }

    private static String getHexTime() {
        String s = Long.toString(System.currentTimeMillis(), ENCODING_BASE);
        int l = s.length();
        if (l > TIME_LENGTH) {
            return s.substring(l - TIME_LENGTH);
        } else {
            return s;
        }
    }

    public static String generateRRN(Long maxId, String starter) {
        if (maxId == null) {
            maxId = 0L;
        }
        maxId = maxId % 999_999;
        maxId++;
        StringBuilder retrievalReferenceNumber = new StringBuilder();
        StringBuilder lastDigitOfYear = new StringBuilder(new SimpleDateFormat("yy")
                .format(new Date()).substring(1));
        StringBuilder dayOfYear = new StringBuilder(String.valueOf(LocalDate.now().getDayOfYear()));
        StringBuilder counter = new StringBuilder();
        StringBuilder dayOfYearCounter = new StringBuilder();

        for (int i = 0; i < 6 - maxId.toString().length(); i++) {
            counter.append("0");
        }

        for (int i = 0; i < 3 - dayOfYear.toString().length(); i++) {
            dayOfYearCounter.append("0");
        }
        counter.append(maxId.toString());
        dayOfYearCounter.append(dayOfYear);

        retrievalReferenceNumber
                .append(starter)
                .append(lastDigitOfYear)
                .append(dayOfYearCounter)
                .append(counter)
        ;

        return retrievalReferenceNumber.toString();
    }

    public static String generateRRN(String starter) {
        LocalTime now = LocalTime.now();
        long maxId = now.toSecondOfDay();
        StringBuilder retrievalReferenceNumber = new StringBuilder();
        StringBuilder lastDigitOfYear = new StringBuilder(new SimpleDateFormat("yy")
                .format(new Date()).substring(1));
        StringBuilder dayOfYear = new StringBuilder(String.valueOf(LocalDate.now().getDayOfYear()));
        StringBuilder counter = new StringBuilder();
        StringBuilder dayOfYearCounter = new StringBuilder();

        for (int i = 0; i < 6 - Long.toString(maxId).length(); i++) {
            counter.append("0");
        }

        for (int i = 0; i < 3 - dayOfYear.toString().length(); i++) {
            dayOfYearCounter.append("0");
        }
        counter.append(maxId);
        dayOfYearCounter.append(dayOfYear);

        retrievalReferenceNumber
                .append(starter)
                .append(lastDigitOfYear)
                .append(dayOfYearCounter)
                .append(counter)
        ;

        return retrievalReferenceNumber.toString();
    }


    public static synchronized String generateOid() {
        String oid = ip + hexTime + Long.toString(counter + COUNTER_RESET, ENCODING_BASE);

        counter = (counter + 1) % COUNTER_RESET;

        if (counter == 0) {
            String tempTime = getHexTime();
            while (hexTime.equalsIgnoreCase(tempTime)) {
                tempTime = getHexTime();
            }
            hexTime = tempTime;
        }

        return oid.substring(0, 12);
    }

    public static void main(String[] args) throws Exception {
//		System.out.println(OidGenerator.generateOid().length());
        System.out.println(generateRRN(null, "MB"));
    }


}


