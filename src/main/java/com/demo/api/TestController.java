package com.demo.api;

import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/demo")
public class TestController {

    @GetMapping("/test")
    public Map<String, String> testMessage() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "백엔드에서 보내는 테스트 메시지입니다!");
        response.put("status", "success");
        return response;
    }
}