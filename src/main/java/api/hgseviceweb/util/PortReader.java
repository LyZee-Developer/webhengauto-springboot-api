package api.hgseviceweb.util;

import org.springframework.core.env.Environment;

public class PortReader {
     private final Environment env;

    public PortReader(Environment env) {
        this.env = env;
    }

    public int getPort() {
        return Integer.parseInt(env.getProperty("server.port"));
    }
}
