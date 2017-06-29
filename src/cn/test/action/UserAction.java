package cn.test.action;

import java.util.Map;

import cn.test.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.test.imp.UserImp;
import cn.test.service.UserService;
import cn.test.utils.StringUtils;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	private User user=new User();
	@Override
	public User getModel() {
		return user;
	}
	public String register(){
		ActionContext context = ActionContext.getContext();
		if (!StringUtils.isEmpty(user.getUsername(),user.getPassword())) {
			UserService userservice=new UserImp();
			User fetchUser=userservice.getUserByUsername(user.getUsername());
			if (fetchUser!=null&&fetchUser.getUid()!=0) {
				context.put("username_tip",getText("username.exist"));
			}else {
				int uid = userservice.InsertUser(user);
				if(uid>0){
					user.setUid(uid);
					context.getSession().put("confirmUser", user);
					context.put("message","注册成功!");
					return "success";
				}
				context.put("control_tip", getText("control.register.error"));
			}
		}else {
			context.put("username_tip", StringUtils.isEmpty(user.getUsername())?getText("username.empty"):"");
			context.put("password_tip", StringUtils.isEmpty(user.getPassword())?getText("password.empty"):"");
		}
		return "register";
	}
	
	/**登录请求
	 * @return
	 */
	public String login(){
		ActionContext context = ActionContext.getContext();
		if (!StringUtils.isEmpty(user.getUsername(),user.getPassword())) {
			UserService userservice=new UserImp();
			User fetchUser=userservice.getUserByUsername(user.getUsername());
			if (fetchUser==null||(fetchUser!=null&&fetchUser.getUid()==0)) {
				context.put("username_tip",getText("username.noexist"));
			}else if (!user.getPassword().equals(fetchUser.getPassword())) {
				context.put("password_tip",getText("password.wrong"));
			}else {
				context.getSession().put("confirmUser", fetchUser);
				context.put("message","登录成功!");
				return "success";
			}
		}else {
			context.put("control_tip", getText("control.login.firstreq"));
			context.put("username_tip", StringUtils.isEmpty(user.getUsername())?getText("username.empty"):"");
			context.put("password_tip", StringUtils.isEmpty(user.getPassword())?getText("password.empty"):"");
		}
		return "login";
	}
	
}
