/**************************************************************************************** 

 ****************************************************************************************/
package com.su.action;

/**
 * <Description> <br>
 *
 * @author James<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016年9月7日 <br>
 */

import com.alibaba.fastjson.JSON;
import com.su.utils.Plupload;
import com.su.utils.PluploadUtil;
import com.su.utils.SystemConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("file")
public class FileAction extends BaseAction {
    private String filepath = SystemConfig.readValue("file.path");

    @RequestMapping(value ="mobile/upload", method = RequestMethod.POST)
    @ResponseBody
    public String mobile_upload(Plupload plupload, HttpServletRequest request, HttpServletResponse response) {
        plupload.setRequest(request);
        plupload.setChunk(2);
        plupload.setChunks(3);
        File dir = new File(this.filepath);
        Map<String, String> json = new HashMap();
        json.put("filename", "");
        try {
            PluploadUtil.upload(plupload, dir);
            if (PluploadUtil.isUploadFinish(plupload)) {
                json.put("code", "true");
                json.put("filename", plupload.getName());
            } else {
                json.put("code", "false");
            }
        } catch (IllegalStateException e) {
            json.put("code", "false");
        } catch (IOException e) {
            json.put("code", "false");
        }
        return JSON.toJSONString(json);
    }

    @RequestMapping(value = "web/upload", method = RequestMethod.POST)
    @ResponseBody
    public String web_upload(Plupload plupload, HttpServletRequest request, HttpServletResponse response) {
        plupload.setRequest(request);

        File dir = new File(this.filepath);
        Map<String, String> json = new HashMap();
        json.put("filename", "");
        try {

            String filePaths   = PluploadUtil.upload(plupload, dir);
    System.out.println(filePaths+"filePaths");;
            if (PluploadUtil.isUploadFinish(plupload)) {
                json.put("code", "true");
                json.put("filename",filePaths);
            } else {
                json.put("code", "false");
            }
        } catch (IllegalStateException e) {
            json.put("code", "false");
        } catch (IOException e) {
            json.put("code", "false");
        }
        return JSON.toJSONString(json);
    }

    @RequestMapping(value = {
            "web/kupload"
    }, method = {
            org.springframework.web.bind.annotation.RequestMethod.POST
    })
    @ResponseBody
    public String lweb_upload(Plupload plupload, HttpServletRequest request, HttpServletResponse response) {
        String strBackUrl = "http://" + request.getServerName() +
                ":" +
                request.getServerPort();
        plupload.setChunk(2);
        plupload.setChunks(3);
        plupload.setRequest(request);
        System.out.println("strBackUrl===>" + strBackUrl);

        File dir = new File(this.filepath);
        Map<String, Object> json = new HashMap();
        try {

String filePath   =         PluploadUtil.upload(plupload, dir);
            if (PluploadUtil.isUploadFinish(plupload)) {
                json.put("error", Integer.valueOf(0));
                json.put("url", filePath);
            } else {
                json.put("error", Integer.valueOf(1));
                json.put("message", "上传失败");
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
            json.put("error", Integer.valueOf(1));
            json.put("message", "上传失败");
        } catch (IOException e) {
            e.printStackTrace();
            json.put("error", Integer.valueOf(1));
            json.put("message", "上传失败");
        }
        System.out.println(JSON.toJSONString(json));
        return JSON.toJSONString(json);
    }

}
