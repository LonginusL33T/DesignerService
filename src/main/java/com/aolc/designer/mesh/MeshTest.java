package com.aolc.designer.mesh;

import cn.smartx.core.service.validate.ValidateManager;
import cn.smartx.core.service.validate.email.MailServerInfo;
import com.aolc.designer.mesh.bean.RecuritNode;
import org.json.JSONObject;

import java.io.IOException;

public class MeshTest {
    public static void main(String[] args){
        //MailServerInfo emailServer = new MailServerInfo("smtp.shang-highstreet.cn","wedesign@shang-highstreet.cn","WeDesign2017","wedesign@shang-highstreet.cn");

        //ValidateManager.getInstance().sendByEmail(emailServer,"746949701@qq.com","忘记密码","hello");
        try {
            //System.out.println(MeshManager.getInstance().createUser("sunfly","en"));
            //System.out.println(MeshManager.getInstance().uploadUserInfo("fa6165b5777b4241a165b5777bc2414d","flydsun","<h1>user</h1>","<h1>brand</h1>","en"));
            RecuritNode recuritNode = new RecuritNode();
            recuritNode.setAddress("上海");
            recuritNode.setCategory("成衣");
            recuritNode.setCompensation_benefit("180k");
            recuritNode.setEducational_requirements("本科");
            recuritNode.setJob_detail("web服务搭建");
            String createResult = MeshManager.getInstance().createRecurit("成衣",
                    "上海",
                    "本科",
                    "三年以上",
                    "java",
                    "java","180k","面议","en");
            System.out.println(createResult);
            JSONObject jsonObject = new JSONObject(createResult);
            MeshManager.getInstance().publishNode(jsonObject.getString("uuid"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
