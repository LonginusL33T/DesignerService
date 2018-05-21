package com.aolc.designer.mesh;

import com.aolc.designer.mesh.bean.CompanyNode;
import com.aolc.designer.mesh.bean.RecuritNode;
import com.aolc.designer.mesh.bean.UserNode;
import com.aolc.designer.mesh.bean.request.CreateNodeRequest;
import com.aolc.designer.mesh.bean.request.UpdateNodeRequest;
import com.google.gson.Gson;
import okhttp3.*;
import org.json.JSONObject;

import javax.security.sasl.AuthenticationException;
import java.io.IOException;
import java.io.Reader;

public class MeshManager {
    private static MeshManager instance;
    public static String mesh_token;
    public static String host="http://localhost:8080/api/v1/";
    public static String project = "designer";
    public static final String admin ="admin";
    public static final String password = "admin";

    public static MeshManager getInstance() {
        if (instance == null) {
            synchronized(MeshManager.class) {
                if (instance == null) {
                    instance = new MeshManager();
                }
            }
        }
        try {
            instance.getMe();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return instance;
    }

    /**
     * 获取登录用户信息
     */
    public void getMe() throws IOException {
        String url = host+"auth/me";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Accept","application/json")
                .addHeader("Content-Type","application/json;charset=utf8")
                .addHeader("Authorization","Bearer "+mesh_token)
                .get()
                .build();
        Response response = client.newCall(request).execute();
        if(response.code()!=200){
            login();
        }
    }

    /**
     * 用户登录
     */
    public void login() throws IOException {
        String url = host+"auth/login";
        Gson gson = new Gson();
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(MediaType.parse("application/json"),"{\"username\":\""+admin+"\",\"password\":\""+password+"\"}");
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Accept","application/json")
                .addHeader("Content-Type","application/json;charset=utf8")
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        if(response.code() == 200){
            JSONObject jsonObject = new JSONObject(response.body().string());
            mesh_token = jsonObject.getString("token");
        }
    }
    public static String userLogin() throws IOException {
        String url = host+"auth/login";
        Gson gson = new Gson();
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(MediaType.parse("application/json"),"{\"username\":\""+admin+"\",\"password\":\""+password+"\"}");
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Accept","application/json")
                .addHeader("Content-Type","application/json;charset=utf8")
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        if(response.code() == 200){
            JSONObject jsonObject = new JSONObject(response.body().string());
            return jsonObject.getString("token");
        }else{
            return null;
        }
    }
    /**
     * 获取项目信息
     * @return
     * @throws IOException
     */
    public String getProjectInfo(String project) throws IOException {
        String url = host+project;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Accept","application/json")
                .addHeader("Content-Type","application/json;charset=utf8")
                .addHeader("Authorization","Bearer "+mesh_token)
                .get()
                .build();
        Response response = client.newCall(request).execute();
        if(response.code()==200){
            return response.body().string();
        }else {
            throw new AuthenticationException();
        }
    }

    /**
     * 获取项目的根节点
     * @return
     * @throws IOException
     */
    public String getRootNodeUUID() throws IOException {
        String result = getProjectInfo(project);
        JSONObject jsonObject = new JSONObject(result);
        return jsonObject.getJSONObject("rootNode").getString("uuid");// gson.toJsonTree(result).getAsJsonObject().getAsJsonObject("rootNode").get("uuid").getAsString();
    }

    /**
     * 创建招聘信息
     */
    public String createRecurit(String category,String address,String educationalRequirements,String experience,String jobDetail,String skillsRequirements,String compensationBenefit,String tags, String language) throws IOException {
        RecuritNode recuritNode = new RecuritNode();
        recuritNode.setCategory(category);
        recuritNode.setAddress(address);
        recuritNode.setEducational_requirements(educationalRequirements);
        recuritNode.setExperience(experience);
        recuritNode.setJob_detail(jobDetail);
        recuritNode.setSkills_requirements(skillsRequirements);
        recuritNode.setCompensation_benefit(compensationBenefit);
        recuritNode.setTags(tags);
        String result = getWebRoot("recurit");
        if (null != result) {
            JSONObject jsonObject = new JSONObject(result);
            String rootNode = jsonObject.getString("uuid");
            String url = host + project + "/nodes";
            CreateNodeRequest requestBody = new CreateNodeRequest(rootNode, "recurit", language, recuritNode);
            Gson gson = new Gson();
            OkHttpClient client = new OkHttpClient();
            RequestBody body = RequestBody.create(MediaType.parse("application/json"), gson.toJson(requestBody));
            Request request = new Request.Builder()
                    .url(url)
                    .addHeader("Accept", "application/json")
                    .addHeader("Content-Type", "application/json;charset=utf8")
                    .addHeader("Authorization", "Bearer " + mesh_token)
                    .post(body)
                    .build();
            Response response = client.newCall(request).execute();
            if (response.code() == 201) {
                return response.body().string();
            }
        }
        return  null;
    }

    /**
     * 创建企业
     * @param name
     */
    public String createCompany(String name,String code,String language) throws IOException {
        String rootNode = getRootNodeUUID();
        if (null != rootNode) {
            String url = host + project + "/nodes/";
            CreateNodeRequest requestBody = new CreateNodeRequest(rootNode, "company", language, new CompanyNode(name, code));
            Gson gson = new Gson();
            OkHttpClient client = new OkHttpClient();
            RequestBody body = RequestBody.create(MediaType.parse("application/json"), gson.toJson(requestBody));
            Request request = new Request.Builder()
                    .url(url)
                    .addHeader("Accept", "application/json")
                    .addHeader("Content-Type", "application/json;charset=utf8")
                    .addHeader("Authorization", "Bearer " + mesh_token)
                    .post(body)
                    .build();
            Response response = client.newCall(request).execute();
            if (response.code() == 201) {
                return response.body().string();
            }
        }
        return  null;
    }

    /**
     * 获取节点信息
     * @param path
     * @return
     * @throws IOException
     */
    public String getWebRoot(String path) throws IOException {
        String url = host+project+"/webroot/"+path;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Accept","application/json")
                .addHeader("Content-Type","application/json;charset=utf8")
                .addHeader("Authorization","Bearer "+mesh_token)
                .get()
                .build();
        Response response = client.newCall(request).execute();
        if(response.code()==200){
            return response.body().string();
        }else {
            throw new AuthenticationException();
        }
    }

    /**
     * 根据node
     * @param uniqueid
     * @return
     * @throws IOException
     */
    public String getNode(String uniqueid) throws IOException {
        String url = host+project+"/nodes/"+uniqueid;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json;charset=utf8")
                .addHeader("Authorization", "Bearer " + mesh_token)
                .get()
                .build();
        Response response = client.newCall(request).execute();
        if (response.code() == 200) {
            return response.body().string();
        }
        return null;
    }

    /**
     * 发布Node
     * @param uniqueid
     * @return
     * @throws IOException
     */
    public boolean publishNode(String uniqueid) throws IOException {
        String url = host+project+"/nodes/"+uniqueid+"/published";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json;charset=utf8")
                .addHeader("Authorization", "Bearer " + mesh_token)
                .post(RequestBody.create(MediaType.parse("application/json"), "{}"))
                .build();
        Response response = client.newCall(request).execute();
        if (response.code() == 200) {
            return true;
        }
        return false;
    }
    /**
     * 获取用户节点的UUID
     * @return
     * @throws IOException
     */
    public String getUsersNodeUUID() throws IOException {
        String result = getWebRoot("users");
        JSONObject jsonObject = new JSONObject(result);
        return jsonObject.getString("uuid");// gson.toJsonTree(result).getAsJsonObject().getAsJsonObject("rootNode").get("uuid").getAsString();
    }

    /**
     * 更新用户节点
     * @param uuid
     * @param name
     * @param userIntro
     * @param brandIntro
     * @param language
     * @return
     * @throws IOException
     */
    public boolean uploadUserInfo(String uuid,String name,String userIntro,String brandIntro,String language,String background) throws IOException {
        String nodeInfo = getNode(uuid);
        if(nodeInfo!=null) {
            String url = host + project + "/nodes/" + uuid;
            UserNode userNode = new UserNode(name);
            userNode.setBrand_introduction(brandIntro);
            userNode.setUser_introduction(userIntro);
            userNode.setUser_background(background);
            JSONObject jsonObject = new JSONObject(nodeInfo);
            UpdateNodeRequest requestBody = new UpdateNodeRequest(userNode, language, jsonObject.getString("version"));
            Gson gson = new Gson();
            OkHttpClient client = new OkHttpClient();
            RequestBody body = RequestBody.create(MediaType.parse("application/json"), gson.toJson(requestBody));
            Request request = new Request.Builder()
                    .url(url)
                    .addHeader("Accept", "application/json")
                    .addHeader("Content-Type", "application/json;charset=utf8")
                    .addHeader("Authorization", "Bearer " + mesh_token)
                    .post(body)
                    .build();
            Response response = client.newCall(request).execute();
            if (response.code() == 200) {
                return publishNode(uuid);
            }
        }
        return false;
    }
    /**
     * 新建用户
     * @param name
     * @param language
     * @return
     * @throws IOException
     */
    public String createUser(String name,String language) throws IOException {
        String rootNode = getUsersNodeUUID();
        if (null != rootNode) {
            String url = host + project + "/nodes/";
            CreateNodeRequest requestBody = new CreateNodeRequest(rootNode, "users", language, new UserNode(name));
            Gson gson = new Gson();
            OkHttpClient client = new OkHttpClient();
            RequestBody body = RequestBody.create(MediaType.parse("application/json"), gson.toJson(requestBody));
            Request request = new Request.Builder()
                    .url(url)
                    .addHeader("Accept", "application/json")
                    .addHeader("Content-Type", "application/json;charset=utf8")
                    .addHeader("Authorization", "Bearer " + mesh_token)
                    .post(body)
                    .build();
            Response response = client.newCall(request).execute();
            if (response.code() == 201) {
                return response.body().string();
            }
        }
        return  null;
    }

}
