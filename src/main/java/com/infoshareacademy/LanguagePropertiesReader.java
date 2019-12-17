package com.infoshareacademy;

import java.util.*;
import java.util.stream.Stream;

public class LanguagePropertiesReader {

    Locale localeEng = new Locale("english", "Poland");
    Locale localePl = new Locale("polish", "Poland");
    ResourceBundle bundleEng = ResourceBundle.getBundle("Eng-lang", localeEng);
    ResourceBundle bundlePl = ResourceBundle.getBundle("Pol-lang",localePl);



}



