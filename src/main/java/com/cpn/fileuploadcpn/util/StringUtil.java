package com.cpn.fileuploadcpn.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtil {
    public static String convertFilename(String originalFilename) {
        // Extract file extension (assuming there is one)
        int dotIndex = originalFilename.lastIndexOf('.');
        String filenameWithoutExtension = dotIndex > 0 ? originalFilename.substring(0, dotIndex) : originalFilename;
        String fileExtension = dotIndex > 0 ? originalFilename.substring(dotIndex) : "";

        // Create a timestamp with the desired format
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy_HHmmssSSS");
        String timestamp = dateFormat.format(new Date());

        // Concatenate the original filename, timestamp, and extension
        return filenameWithoutExtension + "_" + timestamp + fileExtension;
    }
}
