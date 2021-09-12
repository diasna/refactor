package id.diasna.refactor.adapter;

import org.apache.commons.codec.digest.DigestUtils;
import id.diasna.refactor.port.PasswordEncoder;

public class Sha256PasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(String str) {
        return DigestUtils.sha256Hex(str);
    }
}
