package com.security.valpro.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Sex {
    public enum GenderType{
        Male("男"),
        FEMALE("女");
        private String genderStr;
        private GenderType(String arg0){
            this.genderStr=arg0;
        }

        public String toString(){
            return genderStr;
        }
    }

    GenderType gender() default GenderType.Male;
}
