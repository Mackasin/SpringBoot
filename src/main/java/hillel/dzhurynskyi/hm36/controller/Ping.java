package hillel.dzhurynskyi.hm36.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
    public class Ping {
    private static final Logger LOG = LoggerFactory.getLogger(Ping.class);
        @GetMapping("/ping")
        @ResponseBody
        public String ping() {
            LOG.info("Call method ping");
            return "OK";
        }
}
