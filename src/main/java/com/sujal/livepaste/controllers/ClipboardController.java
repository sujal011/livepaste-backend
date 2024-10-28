package com.sujal.livepaste.controllers;
//
//import com.sujal.livepaste.dto.RequestDTO;
//import com.sujal.livepaste.dto.ResponseDTO;
//import com.sujal.livepaste.models.ClipBoard;
//import com.sujal.livepaste.services.ClipboardService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//
////@CrossOrigin(origins = "https:localhost:5273")
//@RestController
//@RequestMapping("/api/clipboards")
//public class ClipboardController {
//
//    @Autowired
//    private ClipboardService clipboardService;
//
//    @PostMapping
//    public ResponseEntity<ClipBoard> createClipboard(@RequestBody String paste) {
//        ClipBoard clipBoard = clipboardService.createClipBoard(paste);
//        return ResponseEntity.ok(clipBoard);
//    }
//
//    @GetMapping("/{url}")
//    public ResponseEntity<?> getClipboard(@PathVariable String url) {
//        Optional<ClipBoard> clipBoard=clipboardService.getClipBoardByUrl(url);
//        if (clipBoard.isPresent()){
////            ResponseDTO responseDTO = new ResponseDTO(clipBoard.get().getUrl(),clipBoard.get().getPaste());
//            return ResponseEntity.ok(clipBoard.get());
//        }else{
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Clipboard Not Found");
//        }
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<?> updateClipboard(@RequestBody RequestDTO requestDTO) {
////        securities to be added that only created user can change this
//        String id=requestDTO.getId();
//        String newPaste=requestDTO.getPaste();
//        Optional<ClipBoard> clipBoard= clipboardService.updateClipBoard(id, newPaste);
//        if (clipBoard.isPresent()){
//            return ResponseEntity.ok(clipBoard.get());
//        }else{
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Clipboard Not Found");
//        }
//    }
//
////    @GetMapping()
//
//}

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

//class ClipboardMessage {
//    private String content;
//
//    // Getters and setters
//    public String getContent() { return content; }
//    public void setContent(String content) { this.content = content; }
//}
@Controller
public class ClipboardController {

    private final SimpMessagingTemplate messagingTemplate;

    public ClipboardController(SimpMessagingTemplate messagingTemplate){
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/{clipboardId}")
    public void updateClipboard(@PathVariable String clipboardId,String message){
        messagingTemplate.convertAndSend("/topic/"+clipboardId,message);
    }

}

