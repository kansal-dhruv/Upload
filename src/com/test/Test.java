package com.test;

import java.io.File;

public class Test {
	public static void main(String[] args) {
		String path="C:\\Users\\dhruv.kansal\\servlets-test\\Upload\\Files\\dkansal1999@gmail.com";
		File file=new File(path);
		for(String s:file.list()) {
			System.out.println(s);
		}
	}
}
