package com.MyBlog.project.dto;

import java.util.List;

import com.MyBlog.project.model.Board;
import com.MyBlog.project.model.Reply;
import com.MyBlog.project.model.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDto {
	
	private Long id;
	
	@NonNull
	private String title;
    private String content;
    private String category;
    private int views;
    private User user;
    private List<Reply> replyList;
    
    public Board toEntity() {
    	return Board.builder()
    			.id(id)
    			.title(title)
    			.content(content)
    			.category(category)
    			.views(views)
    			.user(user)
    			.replyList(replyList)
    			.build();
    }
    
    //생성자 -> 어노테이션을 사용해도 특정 로직을 수행할 떄 사용, 명시적으로 작성, 또는 불변성 유지
    public BoardDto toDto(Board board) {
    	this.id = board.getId();
    	this.title = board.getTitle();
    	 this.content = board.getContent();
         this.category = board.getCategory();
         this.views = board.getViews();
         this.user = board.getUser();
         this.replyList = board.getReplyList();
         return this;
    }
    
}
