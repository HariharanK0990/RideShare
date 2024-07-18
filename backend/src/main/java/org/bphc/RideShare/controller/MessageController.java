package org.bphc.RideShare.controller;


import lombok.AllArgsConstructor;
import org.bphc.RideShare.dto.messages.CreateMessageDto;
import org.bphc.RideShare.service.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/message")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MessageController {
    MessageService messageService;

    @PostMapping("/user")
    public ResponseEntity<Boolean> postMessageUser(@RequestBody CreateMessageDto createMessageDto){
        try {
            Boolean bool = messageService.addUserMessage(createMessageDto.getMessage(), Long.parseLong(createMessageDto.getUserId()), Long.parseLong(createMessageDto.getRideId()));
            return new ResponseEntity<Boolean>(bool, HttpStatus.CREATED);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @PostMapping("/driver")
    public ResponseEntity<Boolean> postMessageDriver(@RequestBody CreateMessageDto createMessageDto){
        try {
            Boolean bool = messageService.addDriverMessage(createMessageDto.getMessage(), Long.parseLong(createMessageDto.getUserId()), Long.parseLong(createMessageDto.getRideId()));
            return new ResponseEntity<Boolean>(bool, HttpStatus.CREATED);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @GetMapping("/rideMessages/{id}")
    public ResponseEntity<List<String>> getMessages(@PathVariable("id") Long id){
        try {
            return new ResponseEntity<>(messageService.getRideMessages(id),HttpStatus.OK);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }
}
