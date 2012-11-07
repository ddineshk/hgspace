package com.dinesh.piloting.struts2.action;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class FileUploadAction extends ActionSupport implements ServletRequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1349574007971286035L;
	private HttpServletRequest servletRequest;
	private File userImage;
    private String userImageContentType;
    private String userImageFileName;
	
    public String execute(){
    	try{
            String filePath = servletRequest.getSession().getServletContext().getRealPath("/");
            System.out.println("Server Path : "+ filePath);
            File fileToCreate = new File(filePath,this.userImageFileName);
            FileUtils.copyFile(this.userImage,fileToCreate);
    	}catch(Exception ex){
    		ex.printStackTrace();
    		addActionError(ex.getMessage());
    		return INPUT;
    	}
    	return SUCCESS;
    }
    
	/**
	 * @return the servletRequest
	 */
	public HttpServletRequest getServletRequest() {
		return servletRequest;
	}

	/**
	 * @return the userImage
	 */
	public File getUserImage() {
		return userImage;
	}

	/**
	 * @param userImage the userImage to set
	 */
	public void setUserImage(File userImage) {
		this.userImage = userImage;
	}

	/**
	 * @return the userImageContentType
	 */
	public String getUserImageContentType() {
		return userImageContentType;
	}

	/**
	 * @param userImageContentType the userImageContentType to set
	 */
	public void setUserImageContentType(String userImageContentType) {
		this.userImageContentType = userImageContentType;
	}

	/**
	 * @return the userImageFileName
	 */
	public String getUserImageFileName() {
		return userImageFileName;
	}

	/**
	 * @param userImageFileName the userImageFileName to set
	 */
	public void setUserImageFileName(String userImageFileName) {
		this.userImageFileName = userImageFileName;
	}

	@Override
	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
	}
	
	
}
