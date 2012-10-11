package com.dinesh.piloting.struts.form;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

import com.dinesh.piloting.struts.util.MyUtil;

public class MyUploadForm extends ActionForm {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1513792220802848846L;
	private FormFile formFile;

	/**
	 * @return the formFile
	 */
	public FormFile getFormFile() {
		return formFile;
	}

	/**
	 * @param formFile
	 *            the formFile to set
	 */
	public void setFormFile(FormFile formFile) {
		this.formFile = formFile;
	}

	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		if (getFormFile().getFileSize() == 0) {
			errors.add("common.file.err", new ActionMessage("error.common.file.required"));
			return errors;
		}

		if (!"text/xml".equals(getFormFile().getContentType())) {
			errors.add("common.file.err.ext", new ActionMessage("error.common.file.xmlfile.only"));
			return errors;
		}
		
		System.out.println(getFormFile().getFileSize());

		if (getFormFile().getFileSize() > 10240) {
			errors.add("common.file.err.size", new ActionMessage("error.common.file.size.limit", 10240));
			return errors;
		}
		
		try {
			if(!MyUtil.validateFile(getFormFile().getInputStream())){
				errors.add("common.file.err.invalid",new ActionMessage("error.common.file.content.invalid"));
				return errors;
			}
		} catch (FileNotFoundException e) {
			errors.add("common.file.err.execption",new ActionMessage("error.common.file.exception.fnf",getFormFile().getFileName()));
			return errors;
		} catch (IOException e) {
			errors.add("common.file.err.execption",new ActionMessage("error.common.file.exception.io"));
			return errors;
		}
		return errors;
	}
}
