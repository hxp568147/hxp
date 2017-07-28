package com.example.diyviewutils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import android.app.Activity;
import android.view.View;

public class ViewUtils {
	public static void  injeck(Activity activity){
		bindView(activity);
		bindClick(activity);
	}

	private static void bindClick(Activity activity) {
		//获取字节码
		Class<Activity> clazz = (Class<Activity>) activity.getClass();
		Method[] methods = clazz.getDeclaredMethods();
	}

	private static void bindView(Activity activity) {
		//获取字节码
		Class<Activity> clazz = (Class<Activity>) activity.getClass();
		//获取所有字段
		Field[] fields = clazz.getDeclaredFields();
		//遍历获取到的字段
		for(Field field : fields){
			//判断哪些字段具有ViewInjeck注解
			ViewInjeck viewInjeck = field.getAnnotation(ViewInjeck.class);
			//
			if (viewInjeck != null) {
				int value = viewInjeck.value();
				View view = activity.findViewById(value);
				field.setAccessible(true);
				
				try {
					field.set(activity, view);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
