package com.javaee.ass.entity.role;

import com.javaee.ass.entity.enums.RoleEnum;
import org.apache.ibatis.type.Alias;

import java.util.Objects;

@Alias("userDO")
public class UserDO {
    protected String pkId;
    private String password;
    protected RoleEnum role;
    protected String nickName;

    public UserDO() {
    }


    public String getPkId() {
        return this.pkId;
    }

    public String getPassword() {
        return this.password;
    }

    public RoleEnum getRole() {
        return this.role;
    }

    public String getNickName() {
        return this.nickName;
    }

    public void setPkId(String pkId) {
        this.pkId = pkId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof UserDO)) return false;
        final UserDO other = (UserDO) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$pkId = this.pkId;
        final Object other$pkId = other.pkId;
        if (!Objects.equals(this$pkId, other$pkId)) return false;
        final Object this$password = this.password;
        final Object other$password = other.password;
        if (!Objects.equals(this$password, other$password)) return false;
        final Object this$role = this.role;
        final Object other$role = other.role;
        if (!Objects.equals(this$role, other$role)) return false;
        final Object this$nickName = this.nickName;
        final Object other$nickName = other.nickName;
        return Objects.equals(this$nickName, other$nickName);
    }

    protected boolean canEqual(final Object other) {
        return other instanceof UserDO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $pkId = this.pkId;
        result = result * PRIME + ($pkId == null ? 43 : $pkId.hashCode());
        final Object $password = this.password;
        result = result * PRIME + ($password == null ? 43 : $password.hashCode());
        final Object $role = this.role;
        result = result * PRIME + ($role == null ? 43 : $role.hashCode());
        final Object $nickName = this.nickName;
        result = result * PRIME + ($nickName == null ? 43 : $nickName.hashCode());
        return result;
    }

    public String toString() {
        return "UserDO(pkId=" + this.pkId + ", password=" + this.password + ", role=" + this.role.getRoleType() + ", nickName=" + this.nickName + ")";
    }
}
