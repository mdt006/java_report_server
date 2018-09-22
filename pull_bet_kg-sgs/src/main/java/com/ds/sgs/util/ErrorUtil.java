package com.ds.sgs.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/**   
 *
 * @author worf 
 * @date 2018年6月9日 上午11:25:36  
 */
public class ErrorUtil {
	
	public static String LogExceptionStack(Throwable e) {  
        StringWriter errorsWriter = new StringWriter();  
        e.printStackTrace(new PrintWriter(errorsWriter));  
        return errorsWriter.toString();  
    } 

}
