/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.service.impl;

import com.dht.pojo.Comment;
import com.dht.repository.CommentRepository;
import com.dht.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Override
    public Comment addComment(String content, int productId) {
        return this.commentRepository.addComment(content, productId);
    }
    
}
