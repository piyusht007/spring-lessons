package org.piyush.springlessons;

import com.github.pemistahl.lingua.api.Language;
import com.github.pemistahl.lingua.api.LanguageDetector;
import com.github.pemistahl.lingua.api.LanguageDetectorBuilder;

import static com.github.pemistahl.lingua.api.Language.*;

public class Test {
    public static void detect(){
        LanguageDetector detector = LanguageDetectorBuilder.fromLanguages(ENGLISH, FRENCH, GERMAN, SPANISH).build();
        Language language = detector.detectLanguageOf("languages are awesome");
        System.out.println(language);
    }

    public static void main(String[] args) {
        detect();
    }
}
