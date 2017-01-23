/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.blog.component.post;


import be.nille.request.RequestBodyImpl;
import spark.Request;

/**
 *
 * @author nholvoet
 */

public class PostCommentRequest {
    
    private final Request request;
    private final RequestBodyImpl body;
    
    public PostCommentRequest(final Request request){
        this.request = request;
        this.body = new RequestBodyImpl(request);
    }
    
    public String getPostId(){
        return request.params("id");
    }
    
    public String getCommentText(){
         return this.body.getFirstValueOf("comment")
                 .orElse("");
    }
    
    public String getCommentAuthor(){
         return this.body.getFirstValueOf("author")
                 .orElse("");
    }
    
   
    @Override
    public String toString(){
        return String.format("post id: %s, comment: %s, author: %s",getPostId(),getCommentText(), getCommentAuthor());
    }
    
    
   
    
   
    
}
