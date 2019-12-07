package com.infoshareacademy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Header {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    public static void headerPrinter(){
        stdout.info("          ###################################              \n  ");
        stdout.info("        #          Four Plus One          #              \n  ");
        stdout.info("        #             Library             #              \n  ");
        stdout.info("        ###################################              \n  ");
    }
}
