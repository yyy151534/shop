package com.xuan.user.facadeimpl.entity;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table sys_user
 *
 * @mbg.generated do_not_delete_during_merge
 */
public class User {
    /**
     * Database Column Remarks:
     *   id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * Database Column Remarks:
     *   帐号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.u_username
     *
     * @mbg.generated
     */
    private String uUsername;

    /**
     * Database Column Remarks:
     *   密码
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.u_password
     *
     * @mbg.generated
     */
    private String uPassword;

    /**
     * Database Column Remarks:
     *   名称
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.u_name
     *
     * @mbg.generated
     */
    private String uName;

    /**
     * Database Column Remarks:
     *   电话
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.u_phone
     *
     * @mbg.generated
     */
    private String uPhone;

    /**
     * Database Column Remarks:
     *   邮箱
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.u_email
     *
     * @mbg.generated
     */
    private String uEmail;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.id
     *
     * @return the value of sys_user.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.id
     *
     * @param id the value for sys_user.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.u_username
     *
     * @return the value of sys_user.u_username
     *
     * @mbg.generated
     */
    public String getuUsername() {
        return uUsername;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.u_username
     *
     * @param uUsername the value for sys_user.u_username
     *
     * @mbg.generated
     */
    public void setuUsername(String uUsername) {
        this.uUsername = uUsername == null ? null : uUsername.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.u_password
     *
     * @return the value of sys_user.u_password
     *
     * @mbg.generated
     */
    public String getuPassword() {
        return uPassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.u_password
     *
     * @param uPassword the value for sys_user.u_password
     *
     * @mbg.generated
     */
    public void setuPassword(String uPassword) {
        this.uPassword = uPassword == null ? null : uPassword.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.u_name
     *
     * @return the value of sys_user.u_name
     *
     * @mbg.generated
     */
    public String getuName() {
        return uName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.u_name
     *
     * @param uName the value for sys_user.u_name
     *
     * @mbg.generated
     */
    public void setuName(String uName) {
        this.uName = uName == null ? null : uName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.u_phone
     *
     * @return the value of sys_user.u_phone
     *
     * @mbg.generated
     */
    public String getuPhone() {
        return uPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.u_phone
     *
     * @param uPhone the value for sys_user.u_phone
     *
     * @mbg.generated
     */
    public void setuPhone(String uPhone) {
        this.uPhone = uPhone == null ? null : uPhone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.u_email
     *
     * @return the value of sys_user.u_email
     *
     * @mbg.generated
     */
    public String getuEmail() {
        return uEmail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.u_email
     *
     * @param uEmail the value for sys_user.u_email
     *
     * @mbg.generated
     */
    public void setuEmail(String uEmail) {
        this.uEmail = uEmail == null ? null : uEmail.trim();
    }
}