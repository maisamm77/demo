package com.example.demo.annotation;

import java.lang.annotation.*;
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ReturnStringInstead {
	String name();
}
