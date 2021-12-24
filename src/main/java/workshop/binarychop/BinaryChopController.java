package workshop.binarychop;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BinaryChopController {

    @GetMapping("/binarychop")
    public ResponseEntity<String> BinaryChop(@RequestParam String id, @RequestParam(required=false) List<String> values, BinaryChopService bcs){
        ResponseEntity response = null;
        bcs.setValues(values);
        bcs.setNumber(id);
//        int index = bcs.findIndexWithArrayListBuiltInMethod();
        var index = bcs.findIndexWithCustomBuiltMethod();

        if(index == -2)
            response = ResponseEntity.ok().body("List Empty");
        else if(index == -1)
            response = ResponseEntity.ok().body("Number not found");
        else
            response = ResponseEntity.ok().body("Number found at index: " +  index);

        return response;
    }
}
