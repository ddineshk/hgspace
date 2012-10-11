package com.dinesh.piloting.struts.action;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.dinesh.piloting.struts.form.MyUploadForm;

public class MyUploadAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		MyUploadForm myUploadForm = (MyUploadForm)form;
		
		FormFile formFile = myUploadForm.getFormFile();
		String filePath = getServlet().getServletContext().getRealPath("/") +"upload";
		
		File folder = new File(filePath);
	    if(!folder.exists()){
	    	folder.mkdir();
	    }
	    
	    String fileName = formFile.getFileName();
	    
	    if(!("").equals(fileName)){  
	    	 
	        System.out.println("Server path:" +filePath);
	        File newFile = new File(filePath, fileName);
 
	        if(!newFile.exists()){
	          FileOutputStream fos = new FileOutputStream(newFile);
	          fos.write(formFile.getFileData());
	          fos.flush();
	          fos.close();
	        }  
 
	        request.setAttribute("uploadedFilePath",newFile.getAbsoluteFile());
	        request.setAttribute("uploadedFileName",newFile.getName());
	    }
		return mapping.findForward("success");
	}

}
