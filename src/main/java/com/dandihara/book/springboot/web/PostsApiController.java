package com.dandihara.book.springboot.web;

import com.dandihara.book.springboot.service.posts.PostsService;
import com.dandihara.book.springboot.web.dto.PostsResponseDto;
import com.dandihara.book.springboot.web.dto.PostsSaveRequestDto;
import com.dandihara.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }
    @RequestMapping(value = "/api/v1/posts/{id}",method = RequestMethod.DELETE)
    //@DeleteMapping("/api/vi/posts/{id}")// << 왜 안되지 ?
    public Long delete(@PathVariable Long id){
        postsService.delete(id);
        return id;
    }
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id){
        return postsService.findById(id);
    }



}
