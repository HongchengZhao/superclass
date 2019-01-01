package com.pomeloish.superclass.controller;

import com.pomeloish.superclass.model.Notification;
import com.pomeloish.superclass.service.NotifyService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping(value="api/notifications")
public class NotifyController {
    @Autowired
    private NotifyService notifyService;

    @PostMapping("/addNotify")
    public boolean addNotify(@RequestBody Notification notification){
        return notifyService.addNotify(notification);
    }

    @PutMapping("/updateNotify")
    public boolean updateNotify(@RequestBody Notification notification){
        return notifyService.updateNotify(notification);
    }

    @DeleteMapping("/deleteNotify/{id}")
    public boolean deleteNotify(@PathVariable ("id") Integer id){
        return notifyService.deleteNotify(id);
    }

    @GetMapping(value="/{notificationId}")
    public Notification seeNotify(@PathVariable("notificationId") Integer notificationId){
        return notifyService.seeNotify(notificationId);
    }
}
