package io.github.navjotsrakhra.AutoScaleTestKubernetes;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private static long count = 0;

    @GetMapping
    public ResponseEntity<?> greeting() {
        return ResponseEntity
                .ok("Hello")
                ;
    }

    @GetMapping("/hello")
    public ResponseEntity<?> greetingWithCount() {
        return ResponseEntity
                .ok("Hello " + count++)
                ;
    }
}
