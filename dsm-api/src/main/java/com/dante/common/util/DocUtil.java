package com.dante.common.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import freemarker.template.Configuration;
import freemarker.template.Template;  
  
@SuppressWarnings("deprecation")
public class DocUtil {  
    private static Configuration configuration = null;  
    private static Map<String, Template> allTemplates = null;  
      
    static {  
        configuration = new Configuration();  
        configuration.setDefaultEncoding("utf-8");  
        configuration.setClassForTemplateLoading(DocUtil.class, "/com/dante/docTemplate");  
        allTemplates = new HashMap<>();   // Java 7 钻石语法  
        try {  
            allTemplates.put("resume", configuration.getTemplate("ApiInfoTemplate.ftl"));  
        } catch (IOException e) {  
            e.printStackTrace();  
            throw new RuntimeException(e);  
        }  
    }  
  
    private DocUtil() {  
        throw new AssertionError();  
    }  
  
    public static File createDoc(String fileName,Object dataModel, String type) {  
        File tempFile = new File(fileName);  
        Template template = allTemplates.get(type);  
        try {  
            // 这个地方不能直接使用FileWriter，因为需要指定编码类型否则生成的Word文档会因为有无法识别的编码而无法打开  
            Writer write = new OutputStreamWriter(new FileOutputStream(tempFile), "utf-8");  
            
            template.process(dataModel, write);  
            write.close();  
        } catch (Exception ex) {  
            ex.printStackTrace();  
            throw new RuntimeException(ex);  
        }  
        return tempFile;  
    }  
    
    public static void createDoc(String fileName,Object dataModel, String type, HttpServletResponse response) {  
        Template template = allTemplates.get(type);  
        try {  
        	response.setCharacterEncoding("utf-8");
			response.setContentType("application/msword");
			// 设置浏览器以下载的方式处理该文件默认名为resume.doc
			fileName = URLEncoder.encode(fileName, "utf-8");
			response.addHeader("Content-Disposition", "attachment;filename="+fileName);
            // 这个地方不能直接使用FileWriter，因为需要指定编码类型否则生成的Word文档会因为有无法识别的编码而无法打开  
            Writer write = new OutputStreamWriter(response.getOutputStream(), "utf-8");  
            template.process(dataModel, write);  
            write.close();  
        } catch (Exception ex) {  
            ex.printStackTrace();  
            throw new RuntimeException(ex);  
        }  
    }  
    
} 
