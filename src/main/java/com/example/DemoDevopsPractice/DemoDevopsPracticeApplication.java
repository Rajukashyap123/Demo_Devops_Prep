package com.example.DemoDevopsPractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
public class DemoDevopsPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoDevopsPracticeApplication.class, args);
    }
}

@Controller
class DevOpsController {

    @GetMapping("/")
    public String home() {
        return "redirect:/devops-dashboard.html";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "redirect:/devops-dashboard.html";
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello Raju-- Your Dockerized Java App is ready for deployment 🚀";
    }

    @GetMapping("/api/status")
    @ResponseBody
    public DevOpsStatus getStatus() {
        return new DevOpsStatus("running", "Docker Container Active", "Build Successful", "v1.0");
    }
}

class DevOpsStatus {
    private String appStatus;
    private String containerStatus;
    private String buildStatus;
    private String version;

    public DevOpsStatus(String appStatus, String containerStatus, String buildStatus, String version) {
        this.appStatus = appStatus;
        this.containerStatus = containerStatus;
        this.buildStatus = buildStatus;
        this.version = version;
    }

    public String getAppStatus() {
        return appStatus;
    }

    public String getContainerStatus() {
        return containerStatus;
    }

    public String getBuildStatus() {
        return buildStatus;
    }

    public String getVersion() {
        return version;
    }
}

