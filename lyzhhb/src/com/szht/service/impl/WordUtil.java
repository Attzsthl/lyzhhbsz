package com.szht.service.impl;

import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.hwpf.usermodel.Table;
import org.apache.poi.hwpf.usermodel.TableCell;
import org.apache.poi.hwpf.usermodel.TableIterator;
import org.apache.poi.hwpf.usermodel.TableRow;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.junit.Test;
import org.springframework.stereotype.Service;
 @Service
public class WordUtil
{
 @Test
 public ArrayList<ArrayList<ArrayList<String>>> testWord(){
		ArrayList<ArrayList<ArrayList<String>>> alltables=new ArrayList<ArrayList<ArrayList<String>>>();
  try{
      FileInputStream in = new FileInputStream("E:\\项目文件\\智慧环保\\溧阳文件\\溧阳 水环境\\2010河流\\2010-01河流水质监测成果表.doc");//载入文档
      POIFSFileSystem pfs = new POIFSFileSystem(in);   
      HWPFDocument hwpf = new HWPFDocument(pfs);   
      Range range = hwpf.getRange();//得到文档的读取范围
      TableIterator it = new TableIterator(range);
     //迭代文档中的表格
      while (it.hasNext()) {   
          Table tb = (Table) it.next();   
          //迭代行，默认从0开始
          ArrayList<ArrayList<String>> tableArrayList=new ArrayList<ArrayList<String>>();
          for (int i = 0; i < tb.numRows(); i++) {   
        	  ArrayList<String> rowlist=new ArrayList<String>();
              TableRow tr = tb.getRow(i);   
              //迭代列，默认从0开始
              for (int j = 0; j < tr.numCells(); j++) {   
                  TableCell td = tr.getCell(j);//取得单元格
                  //取得单元格的内容
                  String parString="";
                  for(int k=0;k<td.numParagraphs();k++){   
                      Paragraph para =td.getParagraph(k);   
                      String s = para.text();   
                      s=s.replaceAll("", "");
                      s=s.replaceAll("\r", "");
                      s=s.replaceAll("\n", "");
                      if(!s.equals("")){
                    	  parString+=s;
                      }                      
                  } //end for    
                  rowlist.add(parString);
              }   //end for
              tableArrayList.add(rowlist);
          }   //end for
          alltables.add(tableArrayList);
      } //end while
  }catch(Exception e){
   e.printStackTrace();
  }
  return alltables;
 }//end method
  
}
