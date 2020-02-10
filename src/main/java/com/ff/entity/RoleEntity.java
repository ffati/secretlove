package com.ff.entity;

/**
 * @ClassName RoleEntity
 * @Description TODO
 * @Author ff
 * @Date 2020/2/10 16:50
 * @ModifyDate 2020/2/10 16:50
 * @Version 1.0
 */


public class RoleEntity {

    /**暂无信息*/
    private Long id;
    /**角色名称*/
    private String roleName;
    /**角色代码*/
    private String roleCode;

    /**
     *无参构造函数
     */
    public RoleEntity(){
        super();
    }

    /**
     * 带主键构造函数
     * @param id
     */
    public RoleEntity(Long id){
        super();
        this.id=id;
    }

    /**
     * 获取暂无信息
     * @return
     */
    public Long getId(){
        return this.id;
    }

    /**
     * 设置暂无信息
     * @param id
     */
    public void setId(Long id){
        this.id=id;
    }
    /**
     * 获取角色名称
     * @return
     */
    public String getRoleName(){
        return this.roleName;
    }

    /**
     * 设置角色名称
     * @param roleName
     */
    public void setRoleName(String roleName){
        this.roleName=(roleName == null ? null : roleName.trim());
    }
    /**
     * 获取角色代码
     * @return
     */
    public String getRoleCode(){
        return this.roleCode;
    }

    /**
     * 设置角色代码
     * @param roleCode
     */
    public void setRoleCode(String roleCode){
        this.roleCode=(roleCode == null ? null : roleCode.trim());
    }


}
