// package org.example.util;
//
// import cn.hutool.core.date.DateUtil;
// import com.auth0.jwt.JWT;
// import com.auth0.jwt.algorithms.Algorithm;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.stereotype.Component;
//
// import java.util.Date;
//
// @Component
// public class TokenUtils {
//     /**
//      * 生成Token
//      */
//     public static String getToken(String userId, String sign){   // 以password作为签名
//         return JWT.create().withAudience(userId) // 将 user id 保存到 token 里面.作为载荷
//                 .withExpiresAt(DateUtil.offsetHour(new Date(),24)) // 使用huttool里的util设置24小时过期
//                 .sign(Algorithm.HMAC256(sign)); // 以 password 作为 token 的密钥
//     };
// }
