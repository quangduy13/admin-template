package quangduy.com.admin.entity;

public class Permission {

    private int userId;
    private String userName;
    private String userEmail;
    private String userInfor;
    private String userImgUrl;
    private boolean userStatus;
    private String userCreateAt;

    private int roleId;
    private String roleName;
    private String roleContent;
    private boolean roleStatus;
    private String roleCreateAt;
    private String roleUpdateAt;

    private int functionId;
    private String functionUrl;
    private String functionContent;
    private boolean functionStatus;
    private String functionCreateAt;
    private String functionUpdateAt;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserInfor() {
        return userInfor;
    }

    public void setUserInfor(String userInfor) {
        this.userInfor = userInfor;
    }

    public String getUserImgUrl() {
        return userImgUrl;
    }

    public void setUserImgUrl(String userImgUrl) {
        this.userImgUrl = userImgUrl;
    }

    public boolean isUserStatus() {
        return userStatus;
    }

    public void setUserStatus(boolean userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserCreateAt() {
        return userCreateAt;
    }

    public void setUserCreateAt(String userCreateAt) {
        this.userCreateAt = userCreateAt;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleContent() {
        return roleContent;
    }

    public void setRoleContent(String roleContent) {
        this.roleContent = roleContent;
    }

    public boolean isRoleStatus() {
        return roleStatus;
    }

    public void setRoleStatus(boolean roleStatus) {
        this.roleStatus = roleStatus;
    }

    public String getRoleCreateAt() {
        return roleCreateAt;
    }

    public void setRoleCreateAt(String roleCreateAt) {
        this.roleCreateAt = roleCreateAt;
    }

    public String getRoleUpdateAt() {
        return roleUpdateAt;
    }

    public void setRoleUpdateAt(String roleUpdateAt) {
        this.roleUpdateAt = roleUpdateAt;
    }

    public int getFunctionId() {
        return functionId;
    }

    public void setFunctionId(int functionId) {
        this.functionId = functionId;
    }

    public String getFunctionUrl() {
        return functionUrl;
    }

    public void setFunctionUrl(String functionUrl) {
        this.functionUrl = functionUrl;
    }

    public String getFunctionContent() {
        return functionContent;
    }

    public void setFunctionContent(String functionContent) {
        this.functionContent = functionContent;
    }

    public boolean isFunctionStatus() {
        return functionStatus;
    }

    public void setFunctionStatus(boolean functionStatus) {
        this.functionStatus = functionStatus;
    }

    public String getFunctionCreateAt() {
        return functionCreateAt;
    }

    public void setFunctionCreateAt(String functionCreateAt) {
        this.functionCreateAt = functionCreateAt;
    }

    public String getFunctionUpdateAt() {
        return functionUpdateAt;
    }

    public void setFunctionUpdateAt(String functionUpdateAt) {
        this.functionUpdateAt = functionUpdateAt;
    }
}
