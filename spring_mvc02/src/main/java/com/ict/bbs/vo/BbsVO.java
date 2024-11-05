package com.ict.bbs.vo;

import org.springframework.web.multipart.MultipartFile;

public class BbsVO {
	private String b_idx, subject, writer, content, f_name, pwd, write_date, hit, active, old_f_name;
	private MultipartFile file_name;
	
	
	
	public String getOld_f_name() {
		return old_f_name;
	}

	public void setOld_f_name(String old_f_name) {
		this.old_f_name = old_f_name;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public MultipartFile getFile_name() {
		return file_name;
	}

	public void setFile_name(MultipartFile file_name) {
		this.file_name = file_name;
	}

	public String getB_idx() {
		return b_idx;
	}

	public void setB_idx(String b_idx) {
		this.b_idx = b_idx;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getWrite_date() {
		return write_date;
	}

	public void setWrite_date(String write_date) {
		this.write_date = write_date;
	}

	public String getHit() {
		return hit;
	}

	public void setHit(String hit) {
		this.hit = hit;
	}
	
	
}
