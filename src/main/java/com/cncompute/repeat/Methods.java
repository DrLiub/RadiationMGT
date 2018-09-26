package com.cncompute.repeat;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.cncompute.pojo.Registrationsup;
import com.cncompute.pojo.User;
import com.github.pagehelper.Page;
/**
 * 重复调用方法
 * 
 * @author 劉 2018年8月2日15:55:48
 */
@Service
public class Methods {
	/**
	 * 判断用户是否登录，没有登录跳转登录界面 并返回当前登录用户ID
	 * 
	 * @param request
	 * @return
	 */
	public  String getUser(HttpServletRequest request) {
		String userid = null;
		try {
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			userid = user.getUserid();
		} catch (Exception e) {

		}
		return userid;
	}

	/**
	 * 产生随机数的方法
	 * 
	 * @return
	 */
	public String random() {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateNowStr = sdf.format(d);
		int x = (int) (Math.random() * 100);
		String str = String.valueOf(x);
		String colbu = dateNowStr + str;
		return colbu;
	}

	/**
	 * 产生随机数的方法
	 * 
	 * @return
	 */
	public static String getUUID() {
		UUID uuid = UUID.randomUUID();
		String str = uuid.toString();
		String uuidStr = str.replace("-", "");
		return uuidStr;
	}

	/**
	 * 获取当前时间
	 * 
	 * @return
	 */
	public Date getTime() {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String colclosed = sdf.format(d);
		java.text.SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = formatter.parse(colclosed);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 单上传文件
	 * @RequestParam("file") MultipartFile file
	 * @param request
	 */
	public String fileUpload(HttpServletRequest request, MultipartFile file) {
		try {
			if (file.isEmpty()) {
				return "文件为空";
			}
			// 获取文件名
			String fileName = file.getOriginalFilename();
			// logger.info("上传的文件名为：" + fileName);
			// 获取文件的后缀名
			String suffixName = fileName.substring(fileName.lastIndexOf("."));
			// logger.info("文件的后缀名为：" + suffixName);
			// 设置文件存储路径
			String filePath = "D://aim//";
			String id=getUUID();
			String path = filePath + id + suffixName;//文件路径
			File dest = new File(path);
			// 检测是否存在目录
			if (!dest.getParentFile().exists()) {
				dest.getParentFile().mkdirs();// 新建文件夹
			}
			file.transferTo(dest);// 文件写入
			String page2="Page/"+id + suffixName;//文件存储数据库路径
			return page2;
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "上传失败";
	}

	/**
	 * 多文件上传和下载
	 * @param request
	 * fileName 上传文件前端name
	 * format 上传文件格式
	 * address 上传地址
	 * @return
	 */
	public List<Object> handleFileUpload(HttpServletRequest request, String fileName, String address) {
		List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles(fileName);
		MultipartFile file = null;
		String path = null;
		String rannumber = null;
		File dir = new File(address);
		if (dir.exists()) {
		} else {
			dir.mkdir();
		}

		// 检测是否存在目录
		List<Object> list = new ArrayList<Object>();
		BufferedOutputStream stream = null;
		for (int i = 0; i < files.size(); ++i) {
			file = files.get(i);
			String filePath = address;
			if (!file.isEmpty()) {
				try {
					byte[] bytes = file.getBytes();
					rannumber = getUUID();
					//文件名称
					String fileName1 = file.getOriginalFilename();
//					System.out.println(fileName1.indexOf("."));//获得某个指定的字符串值在字符串中首次出现的位置
//					System.out.println(fileName1.substring(2, 3));
				    //获得文件后缀名
					String suffixName = fileName1.substring(fileName1.lastIndexOf("."));
					stream = new BufferedOutputStream(new FileOutputStream(new File(filePath + rannumber + suffixName)));// 设置文件路径及名字
					path = "Path/" + rannumber + suffixName;
					list.add(path);
					stream.write(bytes);// 写入
					stream.close();
				} catch (Exception e) {
					stream = null;
					// return "第 " + i + " 个文件上传失败 ==> "
					// + e.getMessage();
				}
			} else {
				// return "第 " + i
				// + " 个文件上传失败因为文件为空";
			}
		}
		return list;
	}

	/**
	 * 判断time是否在now的n天之内
	 * 
	 * @param time
	 * @param now
	 * @param n
	 *            正数表示在条件时间n天之后，负数表示在条件时间n天之前
	 * @return
	 */
	public static boolean belongDate(Date time, Date now, int n) {
		Calendar calendar = Calendar.getInstance(); // 得到日历
		calendar.setTime(now);// 把当前时间赋给日历
		calendar.add(Calendar.DAY_OF_MONTH, n);
		Date before7days = calendar.getTime(); // 得到n前的时间
		if (before7days.getTime() < time.getTime()) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * 将日期转格式
	 * @param currentTime
	 * @return
	 */
	public static String getStringDate(Date currentTime) {
		  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		  String dateString = formatter.format(currentTime);
		  return dateString;
		 }
	/**
     * 利用正则表达式判断字符串是否是数字
     * @param str
     * @return
     */
    public boolean isNumeric(String str){
           Pattern pattern = Pattern.compile("[0-9]*");
           Matcher isNum = pattern.matcher(str);
           if( !isNum.matches() ){
               return false;
           }
           return true;
    }
    
    
  //文件下载相关代码
    /**
     * 
     * @param request
     * @param response
     * @param fileName 要导出的文件名称
     * @param realPath 文件所在位置
     * @return
     */
    public String downloadFile(HttpServletRequest request, HttpServletResponse response,String fileName,String realPath ) {
//         fileName = "7527495ea2954c1cb9baa1ef6212eeca.xlsx";// 设置文件名，根据业务需要替换成要下载的文件名
        if (fileName != null) {
            //设置文件路径
//             realPath = "D://aim//";
            File file = new File(realPath , fileName);
            if (file.exists()) {
            	try {
            		response.setContentType("application/force-download");// 设置强制下载不打开
                    response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
				} catch (Exception e) {
					// TODO: handle exception
				}
                
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }
    /**
     * 分页
     * @param page
     * @param pag 当前页数页面传来
     * @param starting 起始页面
     * @param end 末尾页数
     * @param index 当前页数
     * @param request 
     */
	public void sendPage(Page page,String pag,int starting,int end,int index,HttpServletRequest request,String jnum) {
		int eachnum =3;//每页显示几页数据*
		int Pages=page.getPages();//总页面
		if(Pages==0) {
			request.setAttribute("sta", 1);//起始页面
			request.setAttribute("end", 1);//结束页面
			return;
		}
		if(!("".equals(jnum)||jnum==null)) {
			if(Pages>eachnum) {
			    request.setAttribute("sta", Pages-eachnum+1);
				request.setAttribute("end", Pages);
			}else {
			    request.setAttribute("sta", 1);
				request.setAttribute("end", Pages);
			}
			return;
		}
		if("".equals(pag)||pag==null) {
			//默认向页面传值
			request.setAttribute("sta", starting);
			if(Pages>eachnum) {
				request.setAttribute("end", eachnum);//末尾页数
			}else {
				request.setAttribute("end", Pages);
			}
		}else {
			//前台传来页面请求
			if(index+(eachnum/2)<=Pages&&index>(eachnum/2)) {
				request.setAttribute("sta", index-(eachnum/2));//起始页面
				request.setAttribute("end", index+(eachnum/2));//结束页面
			}else if(index+(eachnum/2)<=Pages&&index<(eachnum/2)&&eachnum<=Pages) {
				request.setAttribute("sta", 1);//起始页面
				request.setAttribute("end", eachnum);//结束页面
			}else if(index+(eachnum/2)<=Pages&&index<=(eachnum/2)&&eachnum>Pages) {
				request.setAttribute("sta", 1);//起始页面
				request.setAttribute("end", Pages);//结束页面
			}else if(index+(eachnum/2)<=Pages&&index<=(eachnum/2)&&eachnum<Pages) {
				request.setAttribute("sta", 1);//起始页面
				request.setAttribute("end", eachnum);//结束页面
			}else if(index+(eachnum/2)>=Pages&&index<=(eachnum/2)&&eachnum>Pages) {
				request.setAttribute("sta", 1);//起始页面
				request.setAttribute("end", Pages);//结束页面
			}else if(index+(eachnum/2)>=Pages&&index>(eachnum/2)&&eachnum>Pages) {
				request.setAttribute("sta", 1);//起始页面
				request.setAttribute("end", Pages);//结束页面
			}else if(index==1){
				request.setAttribute("sta", index);
				if(Pages>eachnum) {
					request.setAttribute("end", eachnum);
				}else {
					request.setAttribute("end", Pages);
				}
			}else {
				request.setAttribute("sta", Pages-eachnum+1);
				request.setAttribute("end", Pages);
			}
		}
    	}
	/**
	 * 导出Excel辐射环境监测设备
	 * @param response
	 * @param classmateList
	 * @throws IOException
	 */
	public void downloadAllClassmate(HttpServletResponse response ,List<Registrationsup> classmateList) throws IOException {
	        HSSFWorkbook workbook = new HSSFWorkbook();
	        HSSFSheet sheet = workbook.createSheet("信息表");
	        String fileName = "information"  + ".xls";//设置要导出的文件的名字
	        //新增数据行，并且设置单元格数据
	        int rowNum = 1;
	        String[] headers = { "仪器名称", "品牌", "型号", "购置日期", "状态", "数量", "位置信息", "管理责任人"};
	        //headers表示excel表中第一行的表头

	        HSSFRow row = sheet.createRow(0);
	        //在excel表中添加表头

	        for(int i=0;i<headers.length;i++){
	            HSSFCell cell = row.createCell(i);
	            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
	            cell.setCellValue(text);
	        }

	        //在表中存放查询到的数据放入对应的列
	        for (Registrationsup teacher : classmateList) {
	            HSSFRow row1 = sheet.createRow(rowNum);
	            row1.createCell(0).setCellValue(teacher.getRenameof());
	            row1.createCell(1).setCellValue(teacher.getRebrand());
	            row1.createCell(2).setCellValue(teacher.getRemodel());
	            row1.createCell(3).setCellValue(teacher.getRebuytime());
	            row1.createCell(4).setCellValue(teacher.getReitemssatte());
	            row1.createCell(5).setCellValue(teacher.getRenum());
	            row1.createCell(6).setCellValue(teacher.getRelocation());
	            row1.createCell(7).setCellValue(teacher.getRehead());
	            rowNum++;
	        }
	        response.setContentType("application/octet-stream");
	        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
	        response.flushBuffer();
	        workbook.write(response.getOutputStream());
	    }
	}
