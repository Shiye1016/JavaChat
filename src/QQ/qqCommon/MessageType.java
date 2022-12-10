package QQ.qqCommon;

public interface MessageType {
    //1.在接口中定义了一些常量
    //2.不同的常量的值表示不同的消息类型
    String MESSAGE_LOGIN_SUCCEED = "1";//表示登录成功

    String MESSAGE_LOGIN_FAIL = "2";//登录失败

    String MESSAGE_COMM_MES = "3";//普通信息包

    String MESSAGE_GET_ONLINE_FRIEND = "4";//请求在线用户列表

    String MESSAGE_RET_ONLINE_FRIEND = "5";//返回在线用户列表

    String MESSAGE_CLIENT_EXIT = "6";//客户端请求退出

    String MESSAGE_REGISTERED_SUCCEED = "7";//注册成功

    String MESSAGE_REGISTERED_FAIL = "8";//注册失败

}