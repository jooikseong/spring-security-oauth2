package com.MyBlog.project.controller.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.MyBlog.project.config.auth.PrincipalDetails;
import com.MyBlog.project.dto.ReplyDto;
import com.MyBlog.project.service.ReplyService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ReplyApiController {
	
	private final ReplyService replyService;
	
	@GetMapping("/api/board/{boardId}/replys")
	public ResponseEntity<List<ReplyDto>> replyList(@PathVariable Long boardId) {
		return ResponseEntity.ok(replyService.findAll(boardId));
	}
	
	@PostMapping("/api/board/{boardId}/reply")
	public ResponseEntity<Long> writeReply(@PathVariable("boardId") Long boardId, 
									 @RequestBody ReplyDto replyDto, 
									 @AuthenticationPrincipal PrincipalDetails principalDetails) {
		return ResponseEntity.ok(replyService.writeReply(principalDetails.getUser(), boardId, replyDto));
	}
	
	@DeleteMapping("/api/board/{boardId}/reply/{replyId}")
	public ResponseEntity<Long> deleteReply(@PathVariable("replyId") Long replyId){
		replyService.deleteReply(replyId);
		return ResponseEntity.ok(replyId);
	}
	
}
