package com.test;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;
@WebServlet("/upload")
public class FileTest extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		if(ServletFileUpload.isMultipartContent(req)){
            try {
            	HttpSession ses=req.getSession();
            	String path="C:\\Users\\dhruv.kansal\\servlets-test\\Upload\\Files\\";
            	File dir=new File(path+ses.getAttribute("username"));
            	if(!dir.exists())
            		dir.mkdir();
                List <FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(new ServletRequestContext(req));
                for(FileItem item : multiparts){
                    if(!item.isFormField()){
                        String name = new File(item.getName()).getName();
                        item.write( new File(path + ses.getAttribute("username")  + File.separator + name));
                    }
                }
               //File uploaded successfully
               System.out.println("File Uploaded Successfully");
            } catch (Exception ex) {
            	System.out.println("File Upload Failed due to " + ex);
            }         		
        }else{
        	System.out.println("IDK");
}
//        req.getRequestDispatcher("/result.jsp").forward(req, res);

    }
}	

