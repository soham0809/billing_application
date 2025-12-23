package in.sohamjoshi.billingsoftware.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import in.sohamjoshi.billingsoftware.io.ItemRequest;
import in.sohamjoshi.billingsoftware.io.ItemResponse;
import in.sohamjoshi.billingsoftware.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService ;
//    private final


    @PostMapping("/admin")
    public ItemResponse addItem(@RequestPart("item")ItemRequest request , @RequestPart("file")MultipartFile file){


        ObjectMapper objectMapper = new ObjectMapper();
        ItemRequest itemRequest = null ;

//        try{
//            objectMapper.readValue(item)
//        }catch(Exception e){
//
//        }
        return null ;

    }
}
