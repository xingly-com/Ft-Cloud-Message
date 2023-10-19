package cn.blockengine.ftcloudmessage.utils;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Slf4j
public class JwtUtils {

    //token过期时间 1 day
    public static final long EXPIRE = 1000 * 60 * 60 * 24;

    //秘钥，每个公司生成规则不一样
    public static final String APP_SECRET = "$@DF$#%DS#@$@#D3FS@#$@SER#$";

    //生成token字符串方法
    public static String getJwtToken(String userId) {
        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                .setSubject("Ft-Cloud-Message")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .claim("userId", userId)
                .signWith(SignatureAlgorithm.HS256, APP_SECRET)
                .compact();
    }

    /**
     * 判断token是否存在与有效
     */
    public static boolean checkToken(String jwtToken) {
        if (StringUtils.isEmpty(jwtToken)) {
            return false;
        }
        try {
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        } catch (Exception e) {
            log.error("[token无效] -> " + jwtToken);
            return false;
        }
        return true;
    }

    /**
     * 判断token是否存在与有效
     */
    public static boolean checkToken(HttpServletRequest request) {
        String jwtToken = null;
        try {
            jwtToken = request.getHeader("Ft-Cloud-Message");
            if (StringUtils.isEmpty(jwtToken)) {
                return false;
            }
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        } catch (Exception e) {
            log.error("[token无效] -> " + jwtToken);
            return false;
        }
        return true;
    }

    /**
     * 根据token获取用户id
     */
    public static String getUserIdByJwt(HttpServletRequest request) {
        String jwtToken = request.getHeader("Ft-Cloud-Message");
        if (StringUtils.isEmpty(jwtToken)) {
            return "";
        }
        Jws<Claims> claimsJws = null;
        try {
            claimsJws = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        } catch (Exception e) {
            log.error("[token无效] -> " + jwtToken);
            return "";
        }
        Claims claims = claimsJws.getBody();
        return (String) claims.get("userId");
    }

}
