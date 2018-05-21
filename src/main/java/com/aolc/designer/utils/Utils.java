package com.aolc.designer.utils;

import cn.smartx.core.AAA.SmartxSecurityManager;
import cn.smartx.core.AAA.model.Menu;
import cn.smartx.core.AAA.model.Operation;
import cn.smartx.core.AAA.model.Permission;
import cn.smartx.core.AAA.model.Resource;
import cn.smartx.core.AAA.service.MenuService;
import cn.smartx.core.ds.database.DataBaseLoader;
import cn.smartx.core.model.entity.AcctOperation;
import cn.smartx.core.model.entity.AcctPermission;
import cn.smartx.core.model.entity.AcctResource;
import cn.smartx.core.ui.tree.Node;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Utils {
    public static String generateUUID(){
        return UUID.randomUUID().toString().replace("-","").toLowerCase();
    }
    /**
     * 获取menu
     * @param pid
     * @param service
     * @param appCode
     * @param token
     * @return
     */
    public static List<HashMap> getMenusByPID(int pid, MenuService service,
                                              String appCode, String token) {
        List result = new ArrayList();
        List menus = service.getChildrenMenuModelById(pid);
        Iterator<Menu> iterator = menus.iterator();
        while (iterator.hasNext()) {
            Menu menu = iterator.next();
            if (SmartxSecurityManager.getInstance().isPermitted(appCode, token,
                    menu.getCode())) {
                Map menuMap = new HashMap();
                menuMap.put("sid", menu.getSid());
                menuMap.put("code", menu.getCode());
                menuMap.put("title", menu.getTitle());
                menuMap.put("url", menu.getUrl());
                menuMap.put("level", menu.getLevel());
                menuMap.put("children",
                        getMenusByPID(menu.getSid(), service, appCode, token));
                result.add(menuMap);
            }
        }
        return result;
    }
    /* 递归计算子节点
    * @param parent
    * @param permToken 权限token，用于递归权限计算
    * @param permFullName 权限的全限定名，用于和角色权限集合比较，用于构造指定角色权限树的默认值
    * @param value
    * @param permSelectedSet : 指定角色已经具有的权限
    */
    public static void addToNode(Node parent, String permToken, String permFullName, String value, Set<String> permSelectedSet) {
        if(permToken.indexOf(":") < 0){
            //无父节点权限
            Node n = new Node();
            //permSelectedSet表示是没有指定角色的初始化的权限树，默认都是选中
            if(permSelectedSet == null || permSelectedSet.contains(permFullName)){
                n.setChecked(true);
            } else {
                n.setChecked(false);
            }
            n.setName(permToken);
            n.setValue(value);
            parent.appendChildren(n);
        } else {
            String[] tokens = splitOneLevel(permToken);
            Node n = parent.getChildNode(tokens[0]);
            if(n == null){
                return;
            }
            addToNode(n, tokens[1], permFullName, value, permSelectedSet);
        }
    }

    /**
     * 分解一级":"分割的名称，返回一个二维数组,0是父名称，1是剩余的字段
     * @param name
     * @return
     */
    private static String[] splitOneLevel(String name){
        int n = name.indexOf(':');
        String[] ret = new String[2];

        ret[0] = name.substring(0, n);
        ret[1] = name.substring(n + 1);

        return ret;
    }

    public static List<Permission> getPermissionsByIds(DataBaseLoader loader, List<String> ids){
        ArrayList retList = new ArrayList();
        for(String id : ids){
            AcctPermission permission = loader.getEntity(id,AcctPermission.class);
            AcctResource acctRes = permission.getToAcctResource();
            Resource res = new Resource();
            try {
                BeanUtils.copyProperties(res, acctRes);
                AcctOperation acctOp = permission.getToAcctOperation();
                Operation op = new Operation();
                BeanUtils.copyProperties(op, acctOp);
                Permission perm = new Permission(res, op);
                BeanUtils.copyProperties(perm, permission);
                perm.setPermissionSid(loader.getPKForObject(permission));
                retList.add(perm);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return retList;
    }

}
