package minibank.login;

public class Controller {
    private Navigator navigator;

    public Controller(Navigator navigator) {
        this.navigator = navigator;
    }

    public void startApplication() {
        navigator.navigateToLogin(); // 初始跳转到登录界面
    }

    public void attemptLogin(String username, String password) {
        if ("admin".equals(username) && "1234".equals(password)) {
            navigator.navigateToHome();
        } else {
            navigator.showError("登录失败", "用户名或密码错误");
        }
    }

    public void register(String username, String password) {
        // 这里应添加真实的注册逻辑
        navigator.showInfo("注册成功", "请使用新账户登录");
        navigator.navigateToLogin();
    }
}

