package cn.xidian.web.action;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;

@Component
@SuppressWarnings("serial")
public class FileDownAction extends ActionSupport implements RequestAware {

	private Map<String, Object> request;
	// 文件下载
	private InputStream fileInput;
	private String fileName;
	private String saveFileName;

	// 文件下载
	public String downFile() throws Exception {
		String downFileName = new String(saveFileName.getBytes("ISO8859-1"), "utf-8");
		fileInput = ServletActionContext.getServletContext().getResourceAsStream("help\\" + downFileName);
		request.put("Message", "下载成功！");
		return "success";
	}

	

	public String downStuFile() throws Exception {
		String downFileName = new String(saveFileName.getBytes("ISO8859-1"), "utf-8");
		fileInput = ServletActionContext.getServletContext().getResourceAsStream("upload\\" + downFileName);
		request.put("Message", "下载成功！");
		return "success";
	}

	public Map<String, Object> getRequest() {
		return request;
	}

	public String exportfile() throws Exception {
		// String downFileName = new String(saveFileName.getBytes("ISO8859-1"),
		// "utf-8");

		fileInput = ServletActionContext.getServletContext().getResourceAsStream("export//ITEM.doc");
		request.put("Message", "下载成功！");
		return "success";
	}

	public String ExportFile() throws Exception {
		// String downFileName = new String(saveFileName.getBytes("ISO8859-1"),
		// "utf-8");

		fileInput = ServletActionContext.getServletContext().getResourceAsStream("export//ITEM.doc");
		request.put("Message", "下载成功！");
		return "success";
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public InputStream getFileInput() {
		return fileInput;
	}

	public void setFileInput(InputStream fileInput) {
		this.fileInput = fileInput;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getSaveFileName() {
		return saveFileName;
	}

	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}

}
