package com.qa.orangehrm.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class AnnotationTransformer implements IAnnotationTransformer {
	@Override
	public void transform(ITestAnnotation annotation, 
			@SuppressWarnings("rawtypes") Class testClass, 
			@SuppressWarnings("rawtypes") Constructor testConstructor, 
			Method testMethod) {
		annotation.setRetryAnalyzer(Retry.class);
	}
}