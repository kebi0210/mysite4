package com.javaex.vo;

public class GalleryVo {

	int galleryno;
	int filesize;
	String orgname;
	String exname;
	String savename;
	String filepath;
	
	public GalleryVo() {
		super();
	}

	public GalleryVo(int galleryno, int filesize, String orgname, String exname, String savename, String filepath) {
		super();
		this.galleryno = galleryno;
		this.filesize = filesize;
		this.orgname = orgname;
		this.exname = exname;
		this.savename = savename;
		this.filepath = filepath;
	}

	public int getGalleryno() {
		return galleryno;
	}

	public void setGalleryno(int galleryno) {
		this.galleryno = galleryno;
	}

	public int getFilesize() {
		return filesize;
	}

	public void setFilesize(int filesize) {
		this.filesize = filesize;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public String getExname() {
		return exname;
	}

	public void setExname(String exname) {
		this.exname = exname;
	}

	public String getSavename() {
		return savename;
	}

	public void setSavename(String savename) {
		this.savename = savename;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	@Override
	public String toString() {
		return "GalleryVo [galleryno=" + galleryno + ", filesize=" + filesize + ", orgname=" + orgname + ", exname="
				+ exname + ", savename=" + savename + ", filepath=" + filepath + "]";
	}
	
	
}
