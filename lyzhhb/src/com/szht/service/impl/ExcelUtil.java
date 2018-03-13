package com.szht.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
@ Service
public class ExcelUtil {
	//默认单元格内容为数字时格式
	private static DecimalFormat df = new DecimalFormat("0");
	// 默认单元格格式化日期字符串 
	private static SimpleDateFormat sdf = new SimpleDateFormat(  "yyyy-MM-dd HH:mm:ss"); 
	// 格式化数字
	private static DecimalFormat nf = new DecimalFormat("0.00000");  
	public ArrayList<ArrayList<Object>> readExcel(File file,String sheetname){
		if(file == null){
			return null;
		}
		if(file.getName().endsWith("xlsx")){
			//处理ecxel2007
			return readExcel2007(file,sheetname);
		}else{
			//处理ecxel2003
			return readExcel2003(file,sheetname);
		}
	}
	/*
	 * @return 将返回结果存储在ArrayList内，存储结构与二位数组类似
	 * lists.get(0).get(0)表示过去Excel中0行0列单元格
	 */
	public ArrayList<ArrayList<Object>> readExcel2003(File file,String sheetname){
		try{
			ArrayList<ArrayList<Object>> rowList = new ArrayList<ArrayList<Object>>();
			ArrayList<Object> colList;
			HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(file));
			HSSFSheet sheet = wb.getSheet(sheetname);
			HSSFRow row;
			HSSFCell cell;
			Object value;
			for(int i = 0 ; i <= sheet.getLastRowNum() ; i++ ){
				row = sheet.getRow(i);
				

				colList = new ArrayList<Object>();
				if(row == null){
					rowList.add(colList);
					continue;
				}


				if(row.getFirstCellNum()==-1){
					return rowList;
					//System.out.println("rowfirst:"+row.getFirstCellNum()+",rowlast:"+row.getLastCellNum()+",rowphic:"+sheet.getPhysicalNumberOfRows()+",i:"+i);
				}
				for( int j = 0 ; j <= row.getLastCellNum() ;j++){
					cell = row.getCell(j);
					if(cell == null || cell.getCellType() == HSSFCell.CELL_TYPE_BLANK){
						//当该单元格为空
						if(j != row.getLastCellNum()){//判断是否是该行中最后一个单元格
							colList.add("");
						}
						continue;
					}
					switch(cell.getCellType()){
					 case XSSFCell.CELL_TYPE_STRING:  
		                    System.out.println(i + "行" + j + " 列 is String type");  
		                    value = cell.getStringCellValue();  
		                    break;  
		                case XSSFCell.CELL_TYPE_NUMERIC:  
		                	value = nf.format(cell.getNumericCellValue());
		                    System.out.println(i + "行" + j  
		                            + " 列 is Number type ; DateFormt:"  
		                            + value.toString()); 
		                    break;  
		                case XSSFCell.CELL_TYPE_BOOLEAN:  
		                    System.out.println(i + "行" + j + " 列 is Boolean type");  
		                    value = Boolean.valueOf(cell.getBooleanCellValue());
		                    break;  
		                case XSSFCell.CELL_TYPE_BLANK:  
		                    System.out.println(i + "行" + j + " 列 is Blank type");  
		                    value = "";  
		                    break;  
		                default:  
		                    System.out.println(i + "行" + j + " 列 is default type");  
		                    value = cell.toString();  
					}// end switch
					colList.add(value);
				}//end for j
				rowList.add(colList);
			}//end for i
			
			return rowList;
		}catch(Exception e){
			return null;
		}
	}
	
	public ArrayList<ArrayList<Object>> readExcel2007(File file,String sheetname){
		try{
			ArrayList<ArrayList<Object>> rowList = new ArrayList<ArrayList<Object>>();
			ArrayList<Object> colList;
			XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(file));
			 XSSFSheet sheet=wb.getSheet(sheetname);
			XSSFRow row;
			XSSFCell cell;
			Object value;
			for(int i = 0 ; i <= sheet.getLastRowNum() ; i++ ){
				row = sheet.getRow(i);
				

				colList = new ArrayList<Object>();
				if(row == null){
					rowList.add(colList);
					continue;
				}


				if(row.getFirstCellNum()==-1){
					return rowList;
					//System.out.println("rowfirst:"+row.getFirstCellNum()+",rowlast:"+row.getLastCellNum()+",rowphic:"+sheet.getPhysicalNumberOfRows()+",i:"+i);
				}
				for( int j = 0 ; j <= row.getLastCellNum() ;j++){
					cell = row.getCell(j);
					if(cell == null || cell.getCellType() == HSSFCell.CELL_TYPE_BLANK){
						//当该单元格为空
						if(j != row.getLastCellNum()){//判断是否是该行中最后一个单元格
							colList.add("");
						}
						continue;
					}
					switch(cell.getCellType()){
					 case XSSFCell.CELL_TYPE_STRING:  
		                    System.out.println(i + "行" + j + " 列 is String type");  
		                    value = cell.getStringCellValue();  
		                    break;  
		                case XSSFCell.CELL_TYPE_NUMERIC:  
		                	value = nf.format(cell.getNumericCellValue());
//		                    if ("@".equals(cell.getCellStyle().getDataFormatString())) {  
//		                        value = df.format(cell.getNumericCellValue());  
//		                    } else if ("General".equals(cell.getCellStyle()  
//		                            .getDataFormatString())) {  
//		                        value = nf.format(cell.getNumericCellValue());  
//		                    } else {  
//		                        value = sdf.format(HSSFDateUtil.getJavaDate(cell  
//		                                .getNumericCellValue()));  
//		                    }
		                    System.out.println(i + "行" + j  
		                            + " 列 is Number type ; DateFormt:"  
		                            + value.toString()); 
		                    break;  
		                case XSSFCell.CELL_TYPE_BOOLEAN:  
		                    System.out.println(i + "行" + j + " 列 is Boolean type");  
		                    value = Boolean.valueOf(cell.getBooleanCellValue());
		                    break;  
		                case XSSFCell.CELL_TYPE_BLANK:  
		                    System.out.println(i + "行" + j + " 列 is Blank type");  
		                    value = "";  
		                    break;  
		                default:  
		                    System.out.println(i + "行" + j + " 列 is default type");  
		                    value = cell.toString();  
					}// end switch
					colList.add(value);
				}//end for j
				rowList.add(colList);
			}//end for i
			
			return rowList;
		}catch(Exception e){
			System.out.println("exception");
			return null;
		}
	}
	
	public static void writeExcel(ArrayList<ArrayList<Object>> result,String path){
		if(result == null){
			return;
		}
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet("sheet1");
		for(int i = 0 ;i < result.size() ; i++){
			XSSFRow row = sheet.createRow(i);
			if(result.get(i) != null){
				for(int j = 0; j < result.get(i).size() ; j ++){
					XSSFCell cell = row.createCell(j);
					
					String cellString=result.get(i).get(j).toString();
					XSSFFont xssfFont=wb.createFont();
					XSSFCellStyle cellStyle = (XSSFCellStyle)wb.createCellStyle(); //建立新的cell样式
					if(cellString.indexOf("green")!=-1){
						cellString=cellString.replaceAll("green", "");
						xssfFont.setColor(IndexedColors.GREEN.getIndex());
					}else if (cellString.indexOf("red")!=-1) {
						cellString=cellString.replaceAll("red", "");
						xssfFont.setColor(IndexedColors.RED.getIndex());
					}else {
						xssfFont.setColor(IndexedColors.BLACK.getIndex());
					}
					
					cellStyle.setFont(xssfFont);
					
					
					cell.setCellValue(cellString);
					

					


//					
//					cellStyle.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
//					cellStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
					
//					cellStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN); //下边框 
//					cellStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);//左边框 
//					cellStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);//上边框 
//					cellStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);//右边框
					cell.setCellStyle(cellStyle);
				}
			}
		}
		ByteArrayOutputStream os = new ByteArrayOutputStream();
        try
        {
            wb.write(os);
        } catch (IOException e){
            e.printStackTrace();
        }
        byte[] content = os.toByteArray();
        File file = new File(path);//Excel文件生成后存储的位置。
        //如果不存在目录则生成该目录
//        if(!file.exists()){  
//        	file.mkdirs();  
//        }  
        OutputStream fos  = null;
        try
        {
            fos = new FileOutputStream(file);
            fos.write(content);
            os.close();
            fos.close();
        }catch (Exception e){
            e.printStackTrace();
        }           
	}
	
	public static DecimalFormat getDf() {
		return df;
	}
	public static void setDf(DecimalFormat df) {
		ExcelUtil.df = df;
	}
	public static SimpleDateFormat getSdf() {
		return sdf;
	}
	public static void setSdf(SimpleDateFormat sdf) {
		ExcelUtil.sdf = sdf;
	}
	public static DecimalFormat getNf() {
		return nf;
	}
	public static void setNf(DecimalFormat nf) {
		ExcelUtil.nf = nf;
	}
	
	
	
}
