package api.hgseviceweb.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class PortReader {
    @Value("${server.port}")
    private String serverPort;
    public void printConfig() {
        System.out.println(serverPort);
    }
}
