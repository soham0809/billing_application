package in.sohamjoshi.billingsoftware.controller;


import in.sohamjoshi.billingsoftware.io.CategoryRequest;
import in.sohamjoshi.billingsoftware.io.CategoryResponse;
import in.sohamjoshi.billingsoftware.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {


    private final CategoryService  categoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryResponse addCategory(@RequestBody CategoryRequest request){
        return categoryService.add(request);
    }
}
