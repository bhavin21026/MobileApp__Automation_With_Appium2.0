package com.cma.annotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.cma.enums.CategoryType;
import com.cma.enums.PortalType;
import com.cma.enums.story;





@Retention(RUNTIME)
@Target(METHOD)
@Documented
public @interface FrameworkAnnotation {
	
	public CategoryType[] category();
	public story[] storyId();
	public PortalType[] portal();




}
