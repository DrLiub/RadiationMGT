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

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.cncompute.pojo.User;
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
	public List<Object> handleFileUpload(HttpServletRequest request, String fileName, String format, String address) {
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
					stream = new BufferedOutputStream(new FileOutputStream(new File(filePath + rannumber + format)));// 设置文件路径及名字
					path = "Path/" + rannumber + format;
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
}
