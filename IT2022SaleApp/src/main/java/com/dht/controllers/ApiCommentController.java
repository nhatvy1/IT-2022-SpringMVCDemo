/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.controllers;

import com.dht.pojo.Comment;
import com.dht.service.CommentService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
@RequestMapping("/api")
public class ApiCommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/comments")
    public ResponseEntity<Comment> addComment(@RequestBody Map<String, String> params) {

        Comment c = this.commentService.addComment(params.get("content").toString(),
                Integer.parseInt(params.get("productId").toString()));
        if (c == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(c, HttpStatus.CREATED);
    }
}
