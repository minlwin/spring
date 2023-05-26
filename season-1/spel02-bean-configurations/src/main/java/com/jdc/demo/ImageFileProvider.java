package com.jdc.demo;

import java.nio.file.Path;

public class ImageFileProvider {
	
	private String baseDirectory;
	
	public void setBaseDirectory(String baseDirectory) {
		this.baseDirectory = baseDirectory;
	}
	
	public String getBaseDirectory() {
		return baseDirectory;
	}
	
	public Path getImagePath(String image) {
		return Path.of(baseDirectory, "images").resolve(image);
	}
}
