package com.anticpu.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface AppUtil {

	
	static Map <Integer,String> convertToMap(List<Object []> ob){
		
		Map <Integer,String> map=new HashMap<>();
		
		for(Object [] list : ob)
		{
			 Integer id=(Integer)list[0];
			 String model = (String)list[1];
			map.put(id,model);
		}
		
		return map;
	}
}
