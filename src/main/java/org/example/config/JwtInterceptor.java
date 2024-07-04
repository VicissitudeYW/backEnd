// package org.example.config;
//
// import cn.hutool.core.util.StrUtil;
// import com.auth0.jwt.JWT;
// import com.auth0.jwt.JWTVerifier;
// import com.auth0.jwt.algorithms.Algorithm;
// import com.auth0.jwt.exceptions.JWTDecodeException;
// import com.auth0.jwt.exceptions.JWTVerificationException;
// import org.example.ServiceException;
// import org.example.pojo.DataUser;
// import org.example.service.UserLogin;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Component;
// import org.springframework.web.method.HandlerMethod;
// import org.springframework.web.servlet.HandlerInterceptor;
//
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
//
// @Component
// public class JwtInterceptor implements HandlerInterceptor {
//     @Autowired
//     private UserLogin userLogin;
//
//     // 白名单账号
//     private static final String WHITELIST_USERNAME = "admin";
//
//     @Override
//     public boolean preHandle(HttpServletRequest request,
//                              HttpServletResponse response, Object handler) throws Exception {
//
//
//         // 获取token
//         String token = request.getHeader("token");
//
//         // 如果不是映射到方法直接通过
//         if (!(handler instanceof HandlerMethod)) {
//             return true;
//         }
//
//         // 执行认证
//         if (StrUtil.isBlank(token)) {
//             throw new ServiceException("没有token，请重新登录");
//         }
//
//         // 获取token的userId
//         String userId;
//         try {
//             userId = JWT.decode(token).getAudience().get(0); // 得到token中的userId载荷
//         } catch (JWTDecodeException j) {
//             throw new ServiceException("token验证失败，请重新登录");
//         }
//
//         // 检查是否在白名单中
//         if (WHITELIST_USERNAME.equals(userId)) {
//             return true; // 直接通过拦截器
//         }
//
//         // 根据userId查询数据库
//         DataUser dataUser = userLogin.selectById(userId);
//         if (dataUser == null) {
//             throw new ServiceException("token验证失败，请重新登录");
//         }
//
//         // 用户密码加签验证 token
//         JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(dataUser.getUserPswd())).build();
//         try {
//             jwtVerifier.verify(token);
//         } catch (JWTVerificationException e) {
//             throw new ServiceException("token验证失败，请重新登录");
//         }
//
//         return true;
//     }
// }
