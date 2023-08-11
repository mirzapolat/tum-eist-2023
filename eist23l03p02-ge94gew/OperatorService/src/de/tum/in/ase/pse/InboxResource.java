package de.tum.in.ase.pse;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
public class InboxResource {

    @PostMapping("/r2")
    public ResponseEntity<String> droidReadyR2(@RequestBody String droid) {
        return ResponseEntity.ok("Ready Droid: " +  droid);
    }

    @PostMapping("/3po")
    public ResponseEntity<String> droidReady3PO(@RequestBody String droid) {
        return ResponseEntity.ok("Ready Droid: " +  droid);
    }
}
