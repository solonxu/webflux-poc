package org.example.wf.controller;

import org.reactivestreams.Publisher;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ZeroCopyHttpOutputMessage;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;
/c
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/file/")
public class HelloController {

    @GetMapping("/download")
    public Mono<Void> downloadByWriteWith(ServerHttpResponse response) throws IOException {
        ZeroCopyHttpOutputMessage zeroCopyResponse = (ZeroCopyHttpOutputMessage) response;
        response.getHeaders().set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=parallel.xml");
        response.getHeaders().setContentType(MediaType.IMAGE_PNG);

        Resource resource = new ClassPathResource("parallel.xml");
        File file = new File("c:\\tmp\\1.xml");
    //    File file = resource.getFile();
        return zeroCopyResponse.writeWith(file, 0, file.length());
    }

    @GetMapping("/sayhi")
    public Publisher<ResponseEntity> sayHi(ServerHttpResponse response) {

        return Mono.just(ResponseEntity.ok("hi,solon")  );
    }

}
