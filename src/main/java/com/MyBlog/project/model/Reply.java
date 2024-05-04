package com.MyBlog.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.MyBlog.project.dto.ReplyDto;
import com.MyBlog.project.dto.ReplyDto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Reply extends BaseTimeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 400)
	private String content;
	
	@ManyToOne
	@JoinColumn(name = "boardId")
	@JsonIgnore
	private Board board;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	private User user;
	
	public ReplyDto toDto() {
		return ReplyDto.builder()
				.id(id)
				.content(content)
				.board(board)
				.user(user)
				.build();
		
	}
	
}
