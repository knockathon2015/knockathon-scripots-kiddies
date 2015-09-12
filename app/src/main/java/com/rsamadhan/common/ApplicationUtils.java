package com.rsamadhan.common;

import com.rsamadhan.ApplicationConstants;
import com.rsamadhan.PreferenceManager;

import java.util.Locale;

/**
 * Created by Prathmesh on 12-09-2015.
 */
public class ApplicationUtils {
    public static Locale getSelectedLocale(PreferenceManager prefs){
        Locale locale[]=Locale.getAvailableLocales();
        Locale selectedLocale;
        if(prefs.getSelectedLanguage().contains(ApplicationConstants.ENGLISH_LOCALE)){
            selectedLocale=Locale.getDefault();
        }else{
            selectedLocale=getHindiLocale(locale);
        }
        return selectedLocale;
    }

    //in case hindi locale is not available then set default locale
    private static Locale getHindiLocale(Locale[] locale) {
        Locale defaultLocale=Locale.getDefault();
        for(int i=0;i<locale.length;i++){
            if(locale[i].getLanguage().equals("hi")){
                return locale[i];
            }
        }
        return defaultLocale;
    }
}
