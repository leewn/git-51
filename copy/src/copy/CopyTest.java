package copy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyTest {
	public static void main(String[] args) throws IOException {
		long start = System.currentTimeMillis();
//		copy(new File("G:\\传智播客_轻松掌握JavaWeb视频教程"), new File("F:\\学习资料\\传智播客_轻松掌握JavaWeb视频教程"));
		copy1(new File("G:\\传智播客_轻松掌握JavaWeb视频教程"), new File("F:\\学习资料\\传智播客_轻松掌握JavaWeb视频教程"));
		long end = System.currentTimeMillis();
		System.out.println("复制完成");
		System.out.println(end - start);
	}

	private static void copy1(File scr, File dest) throws IOException {
		FileInputStream fis = new FileInputStream(scr);
		FileOutputStream fos = new FileOutputStream(dest);
		byte[] b = new byte[1024*8];
		int len = 0;
		while((len= fis.read(b))!=-1){
			fos.write(b, 0, len);
		}
		fis.close();
		fos.close();
	}

	private static void copy(File scr, File dest) throws IOException {
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(
				scr));
		BufferedOutputStream bos = new BufferedOutputStream(
				new FileOutputStream(dest));
		byte[] b = new byte[1024 * 8];
		int len = 0;
		while ((len = bis.read(b)) != -1) {
			bos.write(b, 0, len);
		}
		bis.close();
		bos.close();
	}
}
