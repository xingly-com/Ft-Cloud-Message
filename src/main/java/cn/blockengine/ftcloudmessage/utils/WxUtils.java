package cn.blockengine.ftcloudmessage.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

@Slf4j
public class WxUtils {
    public static final String file = "-----BEGIN PRIVATE KEY-----\n" +
            "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCWRKKSiCP5NW/c\n" +
            "IKdP8yOVBo9dadxO3IMGe54xx9zcTq2LDCmsrb1pl6O3GBWkFXytiyzhXUWRU+bh\n" +
            "jkvlhxvllGCoo1YeoykGsfTV5EcWbN/mb4gXg6dFKjCuQqvSGqlnvv2RdxUypan4\n" +
            "/MEXSYj50vJM9DTU5jUyOwepATTZZQDPT6bwf+ngSYvQtvvHlDBNtyE4HGSh5Bfl\n" +
            "f+PQ4SZPbBrCuKm0xU3V+vL87fdIA7InMkSVKXe8ybc/nDVPc+FKGTjOElwWFyuF\n" +
            "/mq5JtBBhV+TamO7WpyiQMgrYkkrh1NuRDJytwKILq+VuqTgZlzwvpT9s2moEgPd\n" +
            "E5wJIlqbAgMBAAECggEAZ/Azjy1xzIekxtsjP47LFuKBubhmdXnbe1l4M7Ct2Qjm\n" +
            "yx3vmYxXTrlfuV6EYYmnQpbYxU1xuDMTqQJ3Bt1sc2Etdpf8EpcC4qmm02fhr+ZA\n" +
            "/LA6ryEWSyYCpBZjqKFeee9Gjx6SYATsy9dwa/4mK784b/gerwBI3WStSL4X4yIF\n" +
            "i/9ilhrHQZpytRR12qtkowzKcEbGrCQEQfXOk/xsqZ1boSq+qyW5JjjbhXdNVbFn\n" +
            "nT3Yghvvk4aWOXxfk9twEklvt/WTdz/QIv6cRNpyMJJcFJR4ur6oaQA+uwxdrERC\n" +
            "TxpyWomCwK5/vGFlApSYNMPnEUWBdA8lxJUno0feYQKBgQDHxlGUVirZdehgroAZ\n" +
            "lcXHZpFBBiX69VGHRLpUbRg/x41fhpdhvo9s0xuUaVxEeJpbO1iqqNzhOxs5dzJ9\n" +
            "4oYmgYhd1VD78ySYJHxTbJQr0I3hHZXQZ1ARB1LXC56tb/QepzvymDUmLIBWUUdU\n" +
            "ybRLLIaLTUFGChfqQwW8KJ0UqwKBgQDAj2NzWbl7tokmZH2g17rLeCFDx7e+k6th\n" +
            "/3upWJ60m6K6F1XdT+qZHXi1LT17Dc9+IgFnusrAYQn8RwXtb3m6UmouqcaI6U8j\n" +
            "pL3FTXjskD//Iq5rli+4kM+1Hoyje6LYl/8wQXKq8skngO1bAsHMaMsYhKihyAYS\n" +
            "yANEfk9x0QKBgCUq54iik2xL/IToUlrwO5DCq2menDhZpeZ1yfjlJyrOlKXeI5IC\n" +
            "4ypLCImPJKR0j7tDilaN/jJFTeZeH9295FmLpfRXOK73aKqJtzvKKrMQJSVp3LKe\n" +
            "Vg4k/6uUtNvtxUxirsuOt+y3QNVOX+gNcua9jPaj0+4U+KgT+iAsqjTrAoGBAJDn\n" +
            "FhqGiWrMOLb4ZgU0ce+NTdL4po+2BgDvxXnxIzSb7b+FseqhqdNg9yW3jo1cHik3\n" +
            "o8EQMmTEYURDmfVLrtmEDT1iKvF6SEB1Rw0DOJ0kC9SNn518XhrQdk1AWOrpLek5\n" +
            "sCH7DjQQEUk13ude0sFklniz00YzBEb71mGjf1sRAoGBAIaqt3rtCt0MnasUYFwW\n" +
            "s3W4hzOYkcgMiuVFPAM1QjcoPslSWuvqEoq3mIPEPVa/ujxmcXROk+9KVFdTEPQh\n" +
            "FawJfVZmdmOSIc7zwo80x5whgEoeRIPwr+QwMl57+lg9PuRjFPF711V8wfwyQGSM\n" +
            "Oc2n8kEAyZIk2Q/CcioGBcFH\n" +
            "-----END PRIVATE KEY-----";

    public static PrivateKey getPrivateKey() throws IOException {
        try {
            String privateKey = file.replace("-----BEGIN PRIVATE KEY-----", "")
                    .replace("-----END PRIVATE KEY-----", "")
                    .replaceAll("\\s+", "");

            KeyFactory kf = KeyFactory.getInstance("RSA");
            return kf.generatePrivate(
                    new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKey)));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("当前Java环境不支持RSA", e);
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException("无效的密钥格式");
        }
    }

    public static void main(String[] args) throws IOException {
        log.info(getPrivateKey().toString());
    }
}
