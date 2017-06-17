package com.su.utils;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.su.service.db.entry.SheetEntry;

public class FlieUtil {

	/**
	 * ��־
	 */
	private static final Logger log = Logger.getLogger(FlieUtil.class);

	/**
	 * Ĭ��excel��׺
	 */
	private static final String EXCEL_SUFFIX = ".xls";

	/**
	 * ��ȡ�ļ�������δָ���ַ���룬����ʹ�÷������ַ����
	 * 
	 * @param filePath
	 *            �ļ�����·��
	 * @return ����
	 * @throws IOException
	 *             IO�쳣
	 */
	public static byte[] getContent(String filePath) throws IOException {
		File file = new File(filePath);
		long fileSize = file.length();
		if (fileSize > Integer.MAX_VALUE) {
			log.error("file too big , filePath = " + filePath);
			return null;
		}
		FileInputStream fi = new FileInputStream(file);
		byte[] buffer = new byte[(int) fileSize];
		int offset = 0;
		int numRead = 0;
		while (offset < buffer.length
				&& (numRead = fi.read(buffer, offset, buffer.length - offset)) >= 0) {
			offset += numRead;
		}
		fi.close();

		if (offset != buffer.length) {
			throw new IOException("Could not completely read file "
					+ file.getName());
		}

		return buffer;
	}

	/**
	 * the traditional io way ֱ�Ӷ�ȡ��Ч�ʽϵͣ����޷���ȡ����ļ�
	 * 
	 * @param filePath
	 *            �ļ�����·��
	 * @return ����
	 * @throws IOException
	 *             IO�쳣
	 */
	public static byte[] toByteArray(String filename) throws IOException {

		File f = new File(filename);
		if (!f.exists()) {
			throw new FileNotFoundException(filename);
		}

		ByteArrayOutputStream bos = new ByteArrayOutputStream((int) f.length());
		BufferedInputStream in = null;
		try {
			in = new BufferedInputStream(new FileInputStream(f));
			int buf_size = 1024;
			byte[] buffer = new byte[buf_size];
			int len = 0;
			while (-1 != (len = in.read(buffer, 0, buf_size))) {
				bos.write(buffer, 0, len);
			}
			return bos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (null != in) {

				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (null != bos) {
				bos.close();
			}
		}
	}

	/**
	 * ͨ��ByteBuffer�������Ķ�ȡ��toByteArrayЧ�ʸߣ��ҿ��Զ����ļ�
	 * 
	 * @param filename
	 * @return
	 * @throws IOException
	 */
	public static byte[] toByteArray2(String filename) throws IOException {

		File f = new File(filename);
		if (!f.exists()) {
			throw new FileNotFoundException(filename);
		}

		FileChannel channel = null;
		FileInputStream fs = null;
		try {
			fs = new FileInputStream(f);
			channel = fs.getChannel();
			ByteBuffer byteBuffer = ByteBuffer.allocate((int) channel.size());
			while ((channel.read(byteBuffer)) > 0) {
				// do nothing
				// System.out.println("reading");
			}
			return byteBuffer.array();
		} catch (IOException e) {
			log.error("read buffer is error", e);
			throw e;
		} finally {
			if (null != channel) {
				try {
					channel.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (null != fs) {
				try {
					fs.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * ͨ���ڴ�ӳ���ȡ�ļ�
	 * 
	 * @param filename
	 * @return
	 * @throws IOException
	 */
	public static byte[] toByteArray3(String filename) throws IOException {

		FileChannel fc = null;
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(filename, "r");
			fc = raf.getChannel();
			MappedByteBuffer byteBuffer = fc.map(MapMode.READ_ONLY, 0,
					fc.size()).load();
			byteBuffer.isLoaded();
			byte[] result = new byte[(int) fc.size()];
			if (byteBuffer.remaining() > 0) {
				// System.out.println("remain");
				byteBuffer.get(result, 0, byteBuffer.remaining());
			}
			return result;
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (null != fc) {
				try {
					fc.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (null != raf) {
				raf.close();
			}
		}
	}

	/**
	 * ��workBook��д���µ�sheet
	 * 
	 * @param wb
	 *            workBook������
	 * @param sheetName
	 *            sheet���
	 * @param sheetIndex
	 *            �ڼ���sheet(��0��ʼ)
	 * @param head
	 *            ��ͷ�ֶ�
	 * @param data
	 *            ���
	 * @param isIndexes
	 *            �Ƿ������
	 * @return workBook������
	 */
	public static HSSFWorkbook getWorkBook(HSSFWorkbook wb, String sheetName,
			int sheetIndex, String[] head, String[][] data, boolean isIndexes) {
		if (null == wb) {
			throw new NullPointerException();
		}

		// ÿ�����Ԫ����
		int maxCell = isIndexes ? head.length + 1 : head.length;

		int begin = isIndexes ? 1 : 0;

		// ��webbook�����һ��sheet
		HSSFSheet sheet = wb.createSheet(sheetName);
		sheet.setDefaultColumnWidth(15);
		// ���ñ�ͷ����
		HSSFRow row = sheet.createRow(sheetIndex);
		// ���ñ�ͷ����
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

		// ��Ԫ��
		HSSFCell cell = null;
		for (int i = 0; i < head.length; i++) {
			cell = row.createCell(i + begin);
			cell.setCellStyle(style);
			cell.setCellValue(head[i]);
		}

		for (int i = 0; i < data.length; i++) {
			// �ӵڶ��п�ʼ��������
			row = sheet.createRow(i + 1);

			if (isIndexes) {
				row.createCell(0).setCellValue(i + 1);
			}

			for (int index = 0; index < data[i].length && index < maxCell; index++) {
				if (!StringUtil.isEmpty(data[i][index])) {
					row.createCell(index + begin).setCellValue(
							data[i][index].replace("&nbsp;", ""));
				}
			}
		}

		return wb;
	}

	/**
	 * ֱ�ӽ������������д������
	 * 
	 * @param wb
	 *            ������
	 * @return ����
	 */
	public static byte[] getBytes(HSSFWorkbook wb) {
		if (null == wb) {
			throw new NullPointerException();
		}

		ByteArrayOutputStream os = new ByteArrayOutputStream();

		try {
			wb.write(os);
			return os.toByteArray();
		} catch (Exception e) {
			log.error("HSSFWorkbook to byte is error", e);
			return new byte[] {};
		}
	}

	/**
	 * ��������ļ�
	 * 
	 * @param wb
	 *            �������
	 * @param path
	 *            ·���������ļ���
	 * @param fileName
	 *            �ļ���
	 * @param fileSuffix
	 *            �ļ���׺(���Ϊnull,��ʹ��Ĭ�Ϻ�׺)
	 * @param reWrite
	 *            ���ļ����ظ�ʱ���Ƿ���������д��
	 * @return ��������ļ���·��
	 */
	public static String write(HSSFWorkbook wb, String path, String fileName,
			String fileSuffix, boolean reWrite) {
		if (null == wb || null == path || null == fileName) {
			throw new NullPointerException();
		}

		if (StringUtil.isEmpty(fileSuffix)) {
			fileSuffix = EXCEL_SUFFIX;
		}
		// �ļ����stream
		FileOutputStream fs = null;

		File file = new File(path + File.separator + fileName + fileSuffix);
		if (file.exists() && !reWrite) {
			throw new NullPointerException();
		}

		while (file.exists()) {
			fileName += System.currentTimeMillis();
			file = new File(path + File.separator + fileName + fileSuffix);
		}

		try {
			fs = new FileOutputStream(file);
			wb.write(fs);
		} catch (IOException e) {
			log.error("write file is error", e);
		} finally {
			if (null != fs) {
				try {
					fs.close();
				} catch (IOException e) {
					log.error("close fileOutputStream error", e);
				}
			}
		}

		return path + File.separator + fileName + fileSuffix;
	}

	/**
	 * ��ʽ�����
	 * 
	 * @param alias
	 *            ��ֵ
	 * @param mapData
	 *            list���
	 * @return ��ά����
	 */
	public static String[][] convert(String[] alias,
			List<Map<String, String>> mapData) {
		if (null == alias || alias.length < 1 || null == mapData
				|| mapData.isEmpty()) {
			return new String[][] {};
		}

		String[][] result = new String[mapData.size()][alias.length];

		int row = 0;
		for (Map<String, String> map : mapData) {
			for (int i = 0; i < alias.length; i++) {
				result[row][i] = StringUtil.toStr(map.get(alias[i]));
			}

			row++;
		}

		return result;
	}

	/**
	 * ����ݲ�������д��excel����
	 * 
	 * @param head
	 *            ��ͷ�ֶ�
	 * @param alias
	 *            ��ͷ�ֶ�alias
	 * @param mapData
	 *            ��ݿ����������
	 * @param isIndex
	 *            �Ƿ���Ҫ����
	 * @return
	 */
	public static byte[] getExcel(String sheetName, String[] head,
			String[] alias, List<Map<String, String>> mapData, boolean isIndex) {
		// ����������
		HSSFWorkbook wb = new HSSFWorkbook();
		// ��ʽ�����
		String[][] data = convert(alias, mapData);

		getWorkBook(wb, sheetName, 0, head, data, isIndex);

		byte[] bytes = getBytes(wb);

		try {
			wb.close();
		} catch (IOException e) {
			log.error("colse workBook is error", e);
		}

		return bytes;
	}

	public static byte[] getExcel(List<SheetEntry> list, boolean isIndex) {
		HSSFWorkbook wb = new HSSFWorkbook();

		for (int i = 0; i < list.size(); i++) {
			SheetEntry sheet = list.get(i);

			if (1 == sheet.getType()) {
				getWorkBook(wb, sheet.getSheetName(), i, sheet.getHead(),
						sheet.getData(), isIndex);
			}

			if (2 == sheet.getType()) {
				String[][] data = convert(sheet.getAlias(), sheet.getDataMap());
				getWorkBook(wb, sheet.getSheetName(), i, sheet.getHead(), data,
						isIndex);
			}
		}

		byte[] bytes = getBytes(wb);

		try {
			wb.close();
		} catch (IOException e) {
			log.error("colse workBook is error", e);
		}

		return bytes;
	}
}
