package in.sohamjoshi.billingsoftware.service;

import in.sohamjoshi.billingsoftware.io.ItemRequest;
import in.sohamjoshi.billingsoftware.io.ItemResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ItemService {

    ItemResponse add(ItemRequest request, MultipartFile file );
    List<ItemResponse> fetchitems();
    void deleteItem(String itemId );

}
